package compilador.Reader;

import compilador.decomposer.DecomposerLexico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInput implements LexicoInput {

    private File file;

    @Override
    public DecomposerLexico getLexico() {

        try {
            String input = new String(Files.readAllBytes(file.toPath()));
            return new DecomposerLexico(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FileInput(String path) {
        this.file = Paths.get(path).toFile().getAbsoluteFile();
    }
}
