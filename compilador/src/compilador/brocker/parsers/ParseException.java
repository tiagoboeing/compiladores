package compilador.brocker.parsers;

public abstract class ParseException extends RuntimeException {

    public abstract int getLine();
    public abstract int getColumn();
    public abstract String getParseMsg();

    public static ParseException get(int column, int line, String message) {
        return new BaseParserException(column, line, message);
    }

    public static ParseException get(int column, int line, String message, String lex) {
        return new BaseParserExceptionLex(column, line, message, lex);
    }

    private static class BaseParserException extends ParseException {

        private int col;
        private int lin;
        private String msg;

        public BaseParserException(int col, int lin, String msg) {
            this.col = col;
            this.lin = lin;
            this.msg = msg;
        }

        @Override
        public int getLine() {
            return lin;
        }

        @Override
        public int getColumn() {
            return col;
        }

        @Override
        public String getParseMsg() {
            final String FORMATED = String.format(this.msg, this.lin, "%s");
            return FORMATED;
        }
    }

    private static class BaseParserExceptionLex extends BaseParserException {

        private String lex;

        public BaseParserExceptionLex(int col, int lin, String msg, String lex) {
            super(col, lin, msg);
            this.lex = lex;
        }

        @Override
        public String getParseMsg() {
            final String MSG = super.getParseMsg();
            final String FORMATED = String.format(MSG, this.lex);
            return FORMATED;
        }
    }

}