package compilador.brocker.factorys;

import compilador.brocker.PositionCalc;
import compilador.brocker.parsers.ParseException;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class TextParserFactory extends BaseFactory {

    private TextParserFactory(Reader reader, List<Integer> lineEndings) {
        super(reader, lineEndings);
    }

    public static TextParserFactory get(String input) {
        if (input == null || input.isEmpty()) {
            throw ParseException.get(0, 0, "Código fonte não informado.");
        }


        List<Integer> lineEndings = PositionCalc.getLineEndings(input);

        Reader reader = new StringReader(input);

        return new TextParserFactory(reader, lineEndings);
    }
}
