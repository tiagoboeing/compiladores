package compilador.decomposer;

import compilador.controller.Token;

public class DecomposedToken extends Token implements Positionable {

    private int column;
    private int line;

    public DecomposedToken(int id, String lexeme, int position) {
        super(id, lexeme, position);
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public int getAbsolute() {
        return this.getPosition();
    }

    public static DecomposedToken get(Token t) {
        if (t == null)
            return null;
        return new DecomposedToken(t.getId(), t.getLexeme(), t.getPosition());
    }
}
