package compilador.semantic.semanticActions;

import compilador.controller.SemanticError;
import compilador.controller.Token;
import compilador.semantic.Constants.RelationalTypes;
import compilador.semantic.parser.SemanticParser;
import compilador.semantic.Constants.SemanticTypes;

public enum  BooleanActions implements SemanticAction {
    OPERATOR(9) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.setRelational(RelationalTypes.get(token.getLexeme()));
        }
    },
    OPERATION(10) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.popType();
            SemanticTypes t2 = parser.popType();

            BooleanActions.validateComparationTypes(t1, t2, token.getPosition());

            parser.pushType(SemanticTypes.bool);
            parser.addCode(parser.getRelational().getCode());
        }

    },
    TRUE(11) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            parser.pushType(SemanticTypes.bool);
            parser.addCode("ldc.i4.1");
        }
    },
    FALSE(12) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            parser.pushType(SemanticTypes.bool);
            parser.addCode("ldc.i4.0");
        }
    },
    NOT(13) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.peekType();
            BooleanActions.validateOperationTypes(t1, token.getPosition());
            parser.addCode("ldc.i4.1");
            parser.addCode("xor");
        }
    },
    AND(18) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.popType();
            SemanticTypes t2 = parser.peekType();
            BooleanActions.validateOperationTypes(t1, t2, token.getPosition());
            parser.addCode("and");
        }
    },
    OR(19) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.popType();
            SemanticTypes t2 = parser.peekType();
            BooleanActions.validateOperationTypes(t1, t2, token.getPosition());
            parser.addCode("or");
        }
    },;

    private int id;

    BooleanActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }

    private static void validateComparationTypes(SemanticTypes t1, SemanticTypes t2, int pos) throws SemanticError {
        if (t1.equals(t2))
            return;

        if (SemanticTypes.isNumeric(t1) && SemanticTypes.isNumeric(t2))
            return;

        throw new SemanticError("Erro na linha %d - Tipos incompatíveis em expressão lógica", pos);
    }

    private static void validateOperationTypes(SemanticTypes t1, SemanticTypes t2, int pos) throws SemanticError {
        if (t1.equals(t2) && t1.equals(SemanticTypes.bool))
            return;

        throw new SemanticError("Erro na linha %d - Tipos incompatíveis em expressão lógica", pos);
    }

    private static void validateOperationTypes(SemanticTypes t1, int pos) throws SemanticError {
        if (!t1.equals(SemanticTypes.bool)) {
            throw new SemanticError("Erro na linha %d - Tipos incompatíveis em expressão lógica", pos);
        }
    }
}
