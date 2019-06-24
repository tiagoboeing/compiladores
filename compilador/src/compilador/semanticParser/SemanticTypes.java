package compilador.semanticParser;

import java.util.HashSet;
import java.util.Set;

public enum  SemanticTypes {
    bool(null),
    int64("Int64"),
    float64("Double");

    String inputType;

    SemanticTypes(String inputType) {
        this.inputType = inputType;
    }

    public String getInputType() {
        return inputType;
    }

    private final static Set<SemanticTypes> NUMBER_TYPES;
    static {
        NUMBER_TYPES = new HashSet<>(2);
        NUMBER_TYPES.add(SemanticTypes.int64);
        NUMBER_TYPES.add(SemanticTypes.float64);
    }

    public static boolean isNumeric(SemanticTypes t1) {
        return SemanticTypes.NUMBER_TYPES.contains(t1);
    }
}
