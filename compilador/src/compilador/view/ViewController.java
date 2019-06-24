package compilador.view;

//import compilador.decomposer.*;
import compilador.brocker.Parser;
import compilador.brocker.factorys.FileParserFactory;
import compilador.brocker.factorys.TextParserFactory;
import compilador.brocker.parsers.ParseException;
import compilador.utils.Files;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ViewController {

    public final String COMPILADO = "Programa compilado com sucesso";
    public final String formatChars = "(\\t+|\\s+|\\n+)|(.+)";

    /* FIXME:
     * Textarea e contagem de linhas do editor não influenciam o scroll do SrollPane
     */

    // shortcuts
    public static final KeyCombination keyNovo = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
    public static final KeyCombination keyAbrir = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    public static final KeyCombination keySalvar = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
    public static final KeyCombination keyCopiar = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
    public static final KeyCombination keyColar = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN);
    public static final KeyCombination keyRecortar = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN);
    public static final KeyCombination keyCompilar = new KeyCodeCombination(KeyCode.F9);
    public static final KeyCombination keyEquipe = new KeyCodeCombination(KeyCode.F1);

    static final String ilasm = "C:\\Windows\\Microsoft.NET\\Framework64\\v4.0.30319\\ilasm.exe";

    /* Extensões que o usuário pode selecionar
     * Ex.:  {"*.JSON", "*.json", "*.txt", "*.TXT", "*.java"}
     * {"*.*"} --> permite todos os tipos
     */
    static final String[] extensoesPermitidas = {"*.*"};
    static final String extensaoSalvar = "*.txt";

    // verifica se botão novo foi pressionado
    static boolean arquivoSalvo = false;
    static String caminhoArquivoSalvo;

    // guarda código gerado
    static String codigoGerado;

    @FXML private Button novo;
    @FXML private Button abrir;
    @FXML private Button salvar;
    @FXML private Button copiar;
    @FXML private Button colar;
    @FXML private Button recortar;
    @FXML private Button compilar;
    @FXML private Button equipe;

    @FXML private TextArea editor;
    @FXML private TextArea mensagens;

    @FXML private Label linhasEditor;
    @FXML private Label barraStatus;

    @FXML private ScrollPane scroll;

    public void ViewController() {
        this.editor.setScrollLeft(2.0);
    }

    @FXML
    private void rowCount(){
        if(this.editor.getText() != null && this.editor.getText() != ""){
            Integer qttRows = this.editor.getText().split("\n").length;
            String linhas = "1";
            for(int i = 2; i <= qttRows; i++){
                linhas = i == 0 ? i+"" : linhas + "\n" + i;
            }
            this.linhasEditor.setText(linhas);
        }
    }

    @FXML
    private void keyShortcuts(KeyEvent event){
        if (keyNovo.match(event)) { this.limpaTela(); return; }
        if (keyAbrir.match(event)) { this.abrirArquivo(); return; }
        if (keySalvar.match(event)) { this.salvar(); return; }
        if (keyCopiar.match(event)) { this.copiar(); return; }
        if (keyColar.match(event)) { this.colar(); return; }
        if (keyRecortar.match(event)) { this.recortar(); return;  }
        if (keyCompilar.match(event)) { this.compilar(); return; }
        if (keyEquipe.match(event)) { this.mostraEquipe(); }
    }

    @FXML
    private void compilar(){
        this.limpaMensagens();

        Parser parser = null;

        try {
            if(!arquivoSalvo || caminhoArquivoSalvo.isEmpty()){
                if (this.editor.getText().isEmpty())
                    throw new ViewException("Não há código para ser compilado, verifique se o arquivo está corretamente salvo.");
                else
                    throw new ViewException("Salve o arquivo antes de compilar");
            } else if(this.editorCodeValid(this.editor.getText(), formatChars)) {
                parser = TextParserFactory.get(this.editor.getText()).getParser();

                this.autoSave(); // Salva arquivo automaticamente antes de compilar

                Path path = Paths.get(caminhoArquivoSalvo);
                File file = path.toFile();
                if (!file.exists())
                    throw new ViewException("O arquivo " + caminhoArquivoSalvo + " não é acessível para compilação");
                parser = FileParserFactory.get(Paths.get(caminhoArquivoSalvo).toFile()).getParser();

                parser.parse();

                codigoGerado = parser.getCode();
            } else {
                throw new ViewException("Nenhum programa para compilar na área reservada para mensagens");
            }

        } catch (ParseException pe) {
            this.mensagens.setText(pe.getParseMsg());
        } catch (ViewException ve) {
            this.mensagens.setText(ve.getMessage());
        } catch (Exception e) {
            this.mensagens.setText(
                    "Um erro inesperado ocorreu." +
                    "\n\n" +
                    e.getMessage() +
                    "\n\n"+
                    Arrays.asList(e.getStackTrace()).
                            stream().
                            map(StackTraceElement::toString).
                            collect(Collectors.joining("\n")));
        } finally {
            if(this.mensagens.getText().isEmpty()) {
                this.mensagens.setText(COMPILADO);
            }
        }
    }

    @FXML
    private void abrirArquivo(){
        File arquivo = Files.chooseFile(extensoesPermitidas);
        String conteudoArquivo = Files.readFile(arquivo);

        if(conteudoArquivo != null){
            this.editor.clear();
            this.barraStatus.setText(arquivo.getAbsolutePath());
            this.conteudoEditor(conteudoArquivo);

            caminhoArquivoSalvo = arquivo.getAbsolutePath();
            arquivoSalvo = true;
        } else {
            if(this.barraStatus.getText() != caminhoArquivoSalvo) {
                this.mensagemBarraStatus("OCORREU UM ERRO AO ABRIR O ARQUIVO");
            }
        }
    }

    private Boolean editorCodeValid(String textoEditor, String regex){
        Integer countChars = 0;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(textoEditor);

        while (matcher.find()) {
            if(matcher.group(2) != null && !matcher.group(2).isEmpty()){
                countChars++;
                break;
            }
        }
        return countChars > 0;
    }

    @FXML
    private void novoDocumento(){
        this.limpaTela();
    }

    @FXML
    private void salvar(){
        if(this.editor.getText().length() > 0 && this.editor.getText() != null) {
            if(!arquivoSalvo) {
                String path = Files.selectPath("*.txt");
                if(path != null){
                    caminhoArquivoSalvo = path;
                } else {
                    return;
                }
            }

            if(Files.saveFile(this.editor.getText(), caminhoArquivoSalvo)) {
                this.mensagens.clear();
                this.mensagemBarraStatus(caminhoArquivoSalvo);

                arquivoSalvo = true;
            }
        }else {
            this.barraStatus.setText("ERRO AO SALVAR!");
            arquivoSalvo = false;
        }
    }

    private void autoSave(){
        if(Files.saveFile(this.editor.getText(), caminhoArquivoSalvo)) {
            this.mensagemBarraStatus(caminhoArquivoSalvo);
            arquivoSalvo = true;
        } else {
            this.barraStatus.setText("ERRO AO SALVAR ARQUIVO DURANTE COMPILAÇÃO!");
            arquivoSalvo = false;
        }
    }

    @FXML
    private void mostraEquipe(){
        this.mostraMensagem("Gustavo Spiess, Tiago Boeing");
    }

    @FXML
    private void copiar() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(this.editor.getSelectedText());
        clipboard.setContent(content);
    }


    @FXML
    private void colar(){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if(clipboard.getString() != null)
            this.editor.replaceSelection(clipboard.getString());
    }

    @FXML
    private void recortar(){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(this.editor.getSelectedText());
        clipboard.setContent(content);

        if(clipboard.getString() != null)
            this.editor.replaceSelection("");
    }

    private void limpaTela(){
        this.limpaEditor();
        this.limpaMensagens();
        this.limpaBarraStatus();
        caminhoArquivoSalvo = null;
        arquivoSalvo = false;
    }

    private void mensagemBarraStatus(String texto){
        this.barraStatus.setText(texto);
    }

    private void limpaBarraStatus(){
        this.barraStatus.setText("");
    }

    private void limpaMensagens(){
        this.mensagens.setText("");
    }

    private void limpaEditor(){
        this.editor.setText("");
    }

    private void mostraMensagem(String texto){
        this.mensagens.setText(texto);
    }

    private void conteudoEditor(String texto){
        this.editor.setText(texto);
    }

    @FXML
    public void verCodigoGerado(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CodigoGerado.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Código gerado");
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.setResizable(true);
            stage.show();

            CodigoGeradoController gerado = loader.getController();
            gerado.clear();
            gerado.setConteudo(codigoGerado);
        } catch(Exception e) {
            System.out.println("Problema ao abrir a janela");
        }
    }

}
