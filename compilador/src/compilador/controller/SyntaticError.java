package compilador.controller;

public class SyntaticError extends AnalysisError
{
    private String lex;

    public SyntaticError(String msg, int position, String lex) {
        super(msg, position);
        this.lex = lex.equals("$") ? "fim de arquivo" : lex;
    }

    public String getLex() {
        return lex;
    }
}
