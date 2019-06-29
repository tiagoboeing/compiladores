package compilador.semantic.Constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum  SemanticTypes {
    int64("Int64", "int"),
    float64("Double", "float"),
    bool("Int64", "bool"),
    character("string", "char"),
    string("string", "string"),;

    String inputType;
    String syntax;

    SemanticTypes(String inputType, String syntax) {
        this.inputType = inputType;
        this.syntax = syntax;
    }

    public String getInputType() {
        return inputType;
    }

    private String getSyntax() {
        return this.syntax;
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

    public static SemanticTypes getBySyntax(String syntax) {
        return Arrays.asList(SemanticTypes.values()).stream().filter(x -> x.getSyntax().equals(syntax)).findFirst().orElse(null);
    }

}
