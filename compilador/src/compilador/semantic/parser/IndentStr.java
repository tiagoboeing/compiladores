package compilador.semantic.parser;

public class IndentStr implements CharSequence {
    int length;

    public IndentStr(int length) {
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int i) {
        return ' ';
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new IndentStr(i1-i);
    }
}