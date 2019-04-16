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


    public final String COMPILADO = "Programa compilado com sucesso";

    /* FIXME:
     * Textarea e contagem de linhas do editor não influenciam o scroll do SrollPane
     */

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

    @FXML private ScrollPane scroll;

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
        this.limpaMensagens();

        if(!arquivoSalvo || caminhoArquivoSalvo.isEmpty()){
            this.mensagens.appendText("É necessário salvar o arquivo antes de compilar!");
            return;
        }

        if(!caminhoArquivoSalvo.isEmpty() && arquivoSalvo){
            /* TODO: Chamar léxico */
            //Lexico lexico = new FileInput(caminhoArquivoSalvo).getLexico();
            DecomposerLexico dl = new DecomposerLexico(caminhoArquivoSalvo);
            Decomposer<Set<DecomposedToken>, List<DecomposedError>> d = DefaultDecomposers.basic(dl);

            boolean compiled = d.getErrors().isEmpty();
            if (!compiled) {
                d.getTokens().stream().map(Objects::toString).map(x->x+"\n").forEach(this.mensagens::appendText);
                this.mensagens.appendText(COMPILADO);
            } else {
                this.mensagens.appendText(d.getErrors().get(0).getMessage());
            }

            /* TODO:
             * Erros necessitam tratamento conforme descrição:
             * https://github.com/tiagoboeing/compiladores/wiki/Parte-2---Implementa%C3%A7%C3%A3o-do-analisador-l%C3%A9xico
            */
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

    @FXML
    private void mostraEquipe(){
        this.mostraMensagem("Gustavo Spies, Pedro Menzel, Tiago Boeing");
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

}
