package compilador;

import compilador.Reader.FileInput;
import compilador.controller.Token;
import compilador.decomposer.*;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        DecomposerLexico lexico = new FileInput("teste.2019").getLexico();

        Decomposer<Set<DecomposedToken>, List<DecomposedError>> d = DefaultDecomposers.basic(lexico);
        d.getTokens().stream().sorted(Comparator.comparingInt(Token::getPosition)).forEach(System.out::println);
        d.getErrors().stream().map(Throwable::getMessage).forEach(System.out::println);

    }

}
