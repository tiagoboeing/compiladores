package compilador.view;

import compilador.Reader.FileInput;
import compilador.controller.LexicalError;
import compilador.controller.Lexico;
import compilador.controller.Token;
import compilador.decomposer.Decomposer;
import compilador.decomposer.DefaultDecomposers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ViewController {

    // shortcuts
    static final KeyCombination keyNovo = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_ANY);
    static final KeyCombination keyAbrir = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY);
    static final KeyCombination keySalvar = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY);
    static final KeyCombination keyCopiar = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY);
    static final KeyCombination keyColar = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY);
    static final KeyCombination keyRecortar = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_ANY);
    static final KeyCombination keyCompilar = new KeyCodeCombination(KeyCode.F9);
    static final KeyCombination keyEquipe = new KeyCodeCombination(KeyCode.F1);

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


    @FXML private void rowCount(){
        Integer qttRows = this.editor.getText().split("\n").length;
        String linhas = "1";
        for(int i = 2; i <= qttRows; i++){
            linhas = i == 0 ? i+"" : linhas + "\n" + i;
        }
        this.linhasEditor.setText(linhas);

    }

    @FXML
    private void keyShortcuts(KeyEvent event){
        if (this.keyNovo.match(event)) {
            System.out.println("Ctrl+N pressed");
            return;
        }
        if (this.keyAbrir.match(event)) {
            System.out.println("Abrir");
            return;
        }
        if (this.keySalvar.match(event)) {
            System.out.println("Salvar");
            return;
        }
        if (this.keyCopiar.match(event)) {
            System.out.println("Copiar");
            return;
        }
        if (this.keyColar.match(event)) {
            System.out.println("Colar");
            return;
        }
        if (this.keyRecortar.match(event)) {
            System.out.println("Recortar");
            return;
        }
        if (this.keyCompilar.match(event)) {
            this.compilar();
            return;
        }
        if (this.keyEquipe.match(event)) {
            this.mostraEquipe();
            return;
        }
    }

    @FXML
    private void compilar(){
        Lexico lexico = new FileInput("A:\\Java\\compiladores\\compilador\\teste.2019").getLexico();

        Decomposer<Set<Token>, List<LexicalError>> d = DefaultDecomposers.basic(lexico);
        d.getTokens().stream().sorted(Comparator.comparingInt(Token::getPosition)).forEach(System.out::println);
        d.getErrors().stream().map(Throwable::getMessage).forEach(System.out::println);
    }

    @FXML
    private void mostraEquipe(){
        this.mensagens.setText("Gustavo Spies, Pedro Menzel, Tiago Boeing");
    }
}
