package compilador.controller;

public class Token
{
    private int id;
    private String lexeme;
    private int position;

    private Integer line;
    private Integer column;

    public Token(int id, String lexeme, int position)
    {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
    }

    public final int getId()
    {
        return id;
    }

    public final String getLexeme()
    {
        return lexeme;
    }

    public final int getPosition()
    {
        return position;
    }

    public String toString()
    {
        if (line != null)
            return id+" ( "+lexeme+" ) @ "+line+":"+column;
        return id+" ( "+lexeme+" ) @ "+position;
    };

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
