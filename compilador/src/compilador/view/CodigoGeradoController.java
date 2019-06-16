package compilador.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CodigoGeradoController {

    @FXML
    private TextArea conteudo;

    public String getConteudo() {
        return conteudo.getText();
    }

    public void setConteudo(String conteudo) {
        this.conteudo.appendText(conteudo);
    }

    public void clear(){
        this.conteudo.clear();
    }
}
