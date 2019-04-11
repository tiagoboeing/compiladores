package compilador.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ViewController {

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
    private void mostraEquipe(){
        this.mensagens.setText("Gustavo Spies, Pedro Menzel, Tiago Boeing");
    }
}
