package compilador.brocker.factorys;

import compilador.brocker.PositionCalc;
import compilador.brocker.parsers.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileParserFactory extends BaseFactory {

    private FileParserFactory(Reader reader, List<Integer> lineEndings) {
        super(reader, lineEndings);
    }

    public static FileParserFactory get(File file) throws IOException {

        if (file == null) {
            throw ParseException.get(0, 0, "Arquivo não informado");
        }


        BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
        String input = bufferedReader.lines().collect(Collectors.joining("\n"));

        List<Integer> lineEndings = PositionCalc.getLineEndings(input);

        Reader reader = new FileReader(file);

        return new FileParserFactory(reader, lineEndings);
    }

}
