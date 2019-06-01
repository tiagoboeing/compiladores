package compilador;

/*import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;*/

import compilador.brocker.factorys.FileParserFactory;
import compilador.brocker.parsers.ParseException;
import compilador.brocker.Parser;

import java.io.File;
import java.nio.file.Paths;

public class Main /*extends Application */{

    public static void main(String[] args) {
        /*launch(args);*/

        File f = Paths.get("/home/ghspiess/program_projects/bcc_2019_1_compiladores/codeExamples/first_try.txt").toFile();//TODO

        try {
            Parser p = FileParserFactory.get(f).getParser();

            p.parse();
        } catch (ParseException pe) {
            System.out.println(pe.getParseMsg());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

/*    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("view/View.fxml"));
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
    }*/

}
