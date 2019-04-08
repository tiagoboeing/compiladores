package compilador.decomposer;

import compilador.controller.LexicalError;
import compilador.controller.Lexico;
import compilador.controller.Token;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultDecomposers {
    public static Decomposer<Set<Token>, List<LexicalError>> basic(Lexico lexico) {
        return Decomposer
                .factory(lexico)
                .setPannicMode(false)
                .setTokenCollector(Collectors.toSet())
                .setErrorCollector(Collectors.toList())
                .setPositionCalc(PositionCalc.lineColumn)
                .get();
    }

    public static Decomposer<Set<Token>, ?> panicMode(Lexico lexico) throws LexicalError {
        Decomposer<Set<Token>, List<LexicalError>> decomposer = Decomposer
                .factory(lexico)
                .setPannicMode(true)
                .setTokenCollector(Collectors.toSet())
                .setErrorCollector(Collectors.toList())
                .setPositionCalc(PositionCalc.lineColumn)
                .get();
        if (!decomposer.getErrors().isEmpty()) {
            throw decomposer.getErrors().get(0);
        }
        return decomposer;
    }
}
