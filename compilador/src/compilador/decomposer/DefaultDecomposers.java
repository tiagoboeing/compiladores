package compilador.decomposer;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultDecomposers {
    public static Decomposer<Set<DecomposedToken>, List<DecomposedError>> basic(DecomposerLexico lexico) {
        return Decomposer
                .factory(lexico)
                .setPannicMode(false)
                .setTokenCollector(Collectors.toSet())
                .setErrorCollector(Collectors.toList())
                .setPositionCalc(PositionCalc.lineColumn)
                .get();
    }

    public static Decomposer<Set<DecomposedToken>, ?> panicMode(DecomposerLexico lexico) throws DecomposedError {
        Decomposer<Set<DecomposedToken>, List<DecomposedError>> decomposer = Decomposer
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
