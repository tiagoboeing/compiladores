package compilador.decomposer;

import compilador.controller.LexicalError;

public class DecomposedError extends LexicalError implements Positionable {

    private int column;
    private int line;

    public DecomposedError(String msg, int position) {
        super(msg, position);
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

    public static DecomposedError get(LexicalError lr) {
        DecomposedError dr = new DecomposedError(lr.getMessage(), lr.getPosition());
        dr.setStackTrace(lr.getStackTrace());
        return dr;
    }
}
