package compilador.semantic.parser;

public class indentStr implements CharSequence {
    int length;

    public indentStr(int length) {
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
        return new indentStr(i1-i);
    }
}