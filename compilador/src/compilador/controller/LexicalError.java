package compilador.controller;

public class LexicalError extends AnalysisError {

    String token;

    public LexicalError(String msg, int position, String token) {
        super(msg, position);
        this.token = token;
    }

    public LexicalError(String msg, int position) {
        super(msg, position);
    }

    public LexicalError(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return String.format(super.getMessage(), getLine(), token);
    }
}
