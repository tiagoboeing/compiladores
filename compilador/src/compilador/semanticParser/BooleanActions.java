package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Token;

public enum  BooleanActions implements SemanticAction {
    OPERATOR(9) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.setRelational(RelationalTypes.get(token.getLexeme()));
        }
    },
    OPERTATION(10) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.popStack();
            SemanticTypes t2 = parser.popStack();
            if (t1.equals(t2)) {
                parser.pushStack(SemanticTypes.bool);
            } else {
                throw new SemanticError("Não é possível comparar tipos distintos", token.getPosition());
            }
            parser.addCode(parser.getRelational().getCode());
        }
    },
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
