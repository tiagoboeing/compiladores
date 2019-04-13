package compilador.decomposer;

import compilador.controller.LexicalError;

public class DecomposedError extends LexicalError implements Positionable {

    private int column;
    private int line;

    private DecomposerLexico lexico;
    private int end;

    public DecomposedError(String msg, int position, DecomposerLexico lexico) {
        super(msg, position);
        this.lexico = lexico;
        this.end = lexico.getPostiont();
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

    @Override
    public String getMessage() {
        String simbolo = lexico.getInput().substring(this.getAbsolute(), this.end);

        return String.format(super.getMessage(), getLine(), simbolo);
    }

    public static DecomposedError get(LexicalError lr, DecomposerLexico lexico) {
        DecomposedError dr = new DecomposedError(lr.getMessage(), lr.getPosition(), lexico);
        dr.setStackTrace(lr.getStackTrace());
        return dr;
    }
}
