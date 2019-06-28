package compilador.semanticParser;

import compilador.controller.Token;

public enum InterfaceActions implements SemanticAction {
    WRITE(14) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            SemanticTypes t2 = parser.popType();
            if (t2.equals(SemanticTypes.int64)) {
                parser.addCode("conv.i8");
            }
            parser.addCode("call void[mscorlib]System.Console::Write(" + t2.name() + ")");
        }
    };

    private int id;

    InterfaceActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}
