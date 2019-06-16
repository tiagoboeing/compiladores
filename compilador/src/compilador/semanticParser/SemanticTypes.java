package compilador.semanticParser;

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
}
