package compilador.Reader;

import compilador.controller.Lexico;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInput implements LexicoInput {

    private File file;

    @Override
    public Lexico getLexico() {

        try {
            String input = new String(Files.readAllBytes(file.toPath()));
            return new Lexico(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FileInput(String path) {
        this.file = Paths.get(path).toFile().getAbsoluteFile();
    }
}
