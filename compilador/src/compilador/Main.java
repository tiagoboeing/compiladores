package compilador;

import compilador.Reader.FileInput;
import compilador.controller.LexicalError;
import compilador.controller.Lexico;
import compilador.controller.Token;
import compilador.decomposer.Decomposer;
import compilador.decomposer.DefaultDecomposers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        Lexico lexico = new FileInput("../teste.2019").getLexico();

        Decomposer<Set<Token>, List<LexicalError>> d = DefaultDecomposers.basic(lexico);
        d.getTokens().stream().sorted(Comparator.comparingInt(Token::getPosition)).forEach(System.out::println);
        d.getErrors().stream().map(Throwable::getMessage).forEach(System.out::println);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("view/View.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("view/view.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Compilador 2019.1");
            primaryStage.setResizable(true);
            primaryStage.setMinWidth(900);
            primaryStage.setMinHeight(600);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
