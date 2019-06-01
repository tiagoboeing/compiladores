package compilador.controller;

public class LexicalError extends AnalysisError
{
    String lex;

    public LexicalError(String msg, int position, String lex)
	 {
        super(msg, position);

        this.lex = lex;
    }

    public String getLex() {
        return lex;
    }
}
