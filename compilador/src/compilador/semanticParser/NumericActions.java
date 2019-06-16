package compilador.semanticParser;

import compilador.controller.Token;

public enum NumericActions implements SemanticAction {
    SUM(1) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            SemanticTypes t1 = parser.popStack();
            SemanticTypes t2 = parser.popStack();
            if (SemanticTypes.float64.equals(t1) || SemanticTypes.float64.equals(t2)) {
                parser.pushStack(SemanticTypes.float64);
            } else {
                parser.pushStack(SemanticTypes.int64);
            }
            parser.addCode("add");
        }
    }, SUB(2) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            SemanticTypes t1 = parser.popStack();
            SemanticTypes t2 = parser.popStack();
            if (SemanticTypes.float64.equals(t1) || SemanticTypes.float64.equals(t2)) {
                parser.pushStack(SemanticTypes.float64);
            } else {
                parser.pushStack(SemanticTypes.int64);
            }
            parser.addCode("sub");
        }
    }, MUL(3) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            SemanticTypes t1 = parser.popStack();
            SemanticTypes t2 = parser.popStack();
            if (SemanticTypes.float64.equals(t1) || SemanticTypes.float64.equals(t2)) {
                parser.pushStack(SemanticTypes.float64);
            } else {
                parser.pushStack(SemanticTypes.int64);
            }
            parser.addCode("mul");
        }
    }, DIV(3) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            SemanticTypes t1 = parser.popStack();
            SemanticTypes t2 = parser.popStack();
            parser.pushStack(SemanticTypes.float64);
            parser.addCode("div");
        }
    };

    private int id;

    NumericActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}
