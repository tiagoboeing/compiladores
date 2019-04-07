package compilador;

import compilador.Reader.FileInput;
import compilador.controller.LexicalError;
import compilador.controller.Lexico;
import compilador.controller.Token;
import compilador.decomposer.Decomposer;
import compilador.decomposer.DefaultDecomposers;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Lexico lexico = new FileInput("teste.2019").getLexico();

        Decomposer<Set<Token>, List<LexicalError>> d = DefaultDecomposers.basic(lexico);
        d.getTokens().stream().sorted(Comparator.comparingInt(Token::getPosition)).forEach(System.out::println);
        d.getErrors().stream().map(Object::toString).forEach(System.out::println);

    }

}
