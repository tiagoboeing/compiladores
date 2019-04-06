package compilador.Reader;

import compilador.controller.Lexico;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInput implements LexicoInput {

    private File file;

    @Override
    public Lexico getLexico() {
        try (FileReader fileReader = new FileReader(this.file)) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                return new Lexico(bufferedReader.lines().map((x) -> x + "\n").reduce(String::concat).get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FileInput(String path) {
        this.file = Paths.get(path).toFile().getAbsoluteFile();
    }
}
