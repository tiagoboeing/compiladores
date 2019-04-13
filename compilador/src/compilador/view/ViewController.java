package compilador.view;

import compilador.Reader.FileInput;
import compilador.controller.LexicalError;
import compilador.controller.Lexico;
import compilador.controller.Token;
import compilador.decomposer.*;
import compilador.utils.Files;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.*;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ViewController {

    // shortcuts
    public static final KeyCombination keyNovo = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_ANY);
    public static final KeyCombination keyAbrir = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY);
    public static final KeyCombination keySalvar = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY);
    public static final KeyCombination keyCopiar = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY);
    public static final KeyCombination keyColar = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY);
    public static final KeyCombination keyRecortar = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_ANY);
    public static final KeyCombination keyCompilar = new KeyCodeCombination(KeyCode.F9);
    public static final KeyCombination keyEquipe = new KeyCodeCombination(KeyCode.F1);

    /* Extensões que o usuário pode selecionar
     * Ex.:  {"*.JSON", "*.json", "*.txt", "*.TXT", "*.java"}
     * {"*.*"} --> permite todos os tipos
     */
    static final String[] extensoesPermitidas = {"*.*"};
    static final String extensaoSalvar = "*.txt";

    // verifica se botão novo foi pressionado
    static boolean arquivoSalvo = false;
    static String caminhoArquivoSalvo;

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
        if (this.keyNovo.match(event)) { this.limpaTela(); return; }
        if (this.keyAbrir.match(event)) { this.abrirArquivo(); return; }
        if (this.keySalvar.match(event)) { this.salvar(); return; }
        if (this.keyCopiar.match(event)) { this.copiar(); return; }
        if (this.keyColar.match(event)) { this.colar(); return; }
        if (this.keyRecortar.match(event)) { System.out.println("Recortar"); return;  }
        if (this.keyCompilar.match(event)) { this.compilar(); return; }
        if (this.keyEquipe.match(event)) { this.mostraEquipe(); return; }
    }

    @FXML
    private void compilar(){

        Lexico lexico = new FileInput("teste.2019").getLexico();

//        Decomposer<Set<Token>, List<LexicalError>> d = DefaultDecomposers.basic("");
//        d.getTokens().stream().sorted(Comparator.comparingInt(Token::getPosition)).forEach(System.out::println);
//        d.getErrors().stream().map(Throwable::getMessage).forEach(System.out::println);
//

//        Lexico lexico = new FileInput(this.selecionarArquivo().getAbsolutePath()).getLexico();
//
//        Decomposer<Set<Token>, List<LexicalError>> d = DefaultDecomposers.basic(lexico);
//        d.getTokens().stream().sorted(Comparator.comparingInt(Token::getPosition)).map(Objects::toString).map(text -> text + "\n").forEach(this.mensagens::appendText);
//        d.getErrors().stream().map(Throwable::getMessage).map(Objects::toString).map(text -> text + "\n").forEach(this.mensagens::appendText);
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
            this.mensagemBarraStatus("OCORREU UM ERRO AO ABRIR O ARQUIVO");
        }
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
//            if(caminhoArquivoSalvo != null)
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

    @FXML
    private void mostraEquipe(){
        this.mostraMensagem("Gustavo Spies, Pedro Menzel, Tiago Boeing");
    }

    private void limpaTela(){
        this.editor.setText("");
        this.mensagens.setText("");
        this.barraStatus.setText("");
        arquivoSalvo = false;
    }

    private void mensagemBarraStatus(String texto){
        this.barraStatus.setText(texto);
    }

    private void limpaBarraStatus(){
        this.barraStatus.setText("");
    }

    private void mostraMensagem(String texto){
        this.mensagens.setText(texto);
    }

    private void conteudoEditor(String texto){
        this.editor.setText(texto);
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
    private void recortar(){}

}
