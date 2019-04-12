package compilador.decomposer;

public interface Positionable {

    void setColumn(int column);
    void setLine(int line);

    int getColumn();
    int getLine();
    int getAbsolute();
}
