package compilador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("view/View.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("view/view.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Compilador 2019.1");
            primaryStage.setResizable(true);
            primaryStage.setMinWidth(900);
            primaryStage.setMinHeight(650);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
