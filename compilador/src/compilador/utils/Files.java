package compilador.utils;

import javafx.stage.FileChooser;

import java.io.*;

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
     * Salva arquivo com um conteúdo a ser informado
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


    /*
     * Abre caixa de diálogo para selecionar local a ser salvo
     * @param extensao - tipos ao qual o arquivo será salvo
     * return String - caminho escolhido
     */
    public static String selectPath(String extensao){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("codigo-compilador", extensao));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        return fileChooser.showSaveDialog(null).getAbsolutePath();
    }

    /*
     * Lê conteúdo de um arquivo
     * @param File - arquivo
     * @return String - conteúdo do arquivo
     */
    public static String readFile(File arquivo){
        try {
            if(arquivo != null){
                FileReader arq = new FileReader(arquivo.getAbsolutePath());
                BufferedReader lerArq = new BufferedReader(arq);

                String conteudoArquivo = "";
                String linha = lerArq.readLine();
                while (linha != null) {
                    conteudoArquivo += linha + "\n";
                    linha = lerArq.readLine();
                }

                return conteudoArquivo;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }

    public static String createCacheFile(String conteudo){
        try {
            File file = new File(System.getProperty("java.io.tmpdir")+"/codigo-compilador.txt");
            FileWriter w = new FileWriter(file, false);
            w.append(conteudo);
            w.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getOnlyFilename(File file){
        String fileName = file.getName();
        if (fileName.indexOf(".") > 0)
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        return fileName;
    }
}
