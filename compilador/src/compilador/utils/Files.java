package compilador.utils;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    /* Caixa de seleção de arquivo nativa do sistema
    * @param extensões permitidas
    * @return File
    */
    public static File chooseFile(String[] extensoesPermitidas) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser
                .ExtensionFilter(
                "Todos os arquivos", extensoesPermitidas
        ));

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File arquivo = fileChooser.showOpenDialog(null);

        try {
            if(arquivo != null) {
                return arquivo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
    * @param conteudo texto a ser inserido no arquivo
    * @param caminho local/pasta com extensão onde o arquivo será salvo
    * return boolean - arquivo salvo
    */
    public static Boolean saveFile(String conteudo, String caminho){
        try {
            File file = new File(caminho);
            FileWriter w = new FileWriter(file, false);
            w.append(conteudo);
            w.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String selectPath(String extensao){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("codigo-compilador", extensao));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        return fileChooser.showSaveDialog(null).getAbsolutePath();
    }

}
