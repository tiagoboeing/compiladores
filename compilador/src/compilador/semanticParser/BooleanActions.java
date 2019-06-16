package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Token;

public enum  BooleanActions implements SemanticAction {
    TRUE(11) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            parser.pushStack(SemanticTypes.bool);
            parser.addCode("ldc.i4.1");
        }
    },
    FALSE(12) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            parser.pushStack(SemanticTypes.bool);
            parser.addCode("ldc.i4.0");
        }
    },
    NOT(13) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t = parser.peekStack();
            if (!t.equals(SemanticTypes.bool)) {
                throw new SemanticError("Não é possivel utilizar a negação em um valor do tipo " + t.name(), token.getPosition());
            }
            parser.addCode("ldc.i4.1");
            parser.addCode("xor");
        }
    };

    private int id;

    BooleanActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}
