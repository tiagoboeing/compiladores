package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Token;

import java.util.HashSet;
import java.util.Set;

public enum NumericActions implements SemanticAction {
    SUM(1) {

        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            NumericActions.treatBinaryOperatorType(parser, token.getPosition());
            parser.addCode("add");
        }
    },SUB(2) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            NumericActions.treatBinaryOperatorType(parser, token.getPosition());
            parser.addCode("sub");
        }
    }, MUL(3) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            NumericActions.treatBinaryOperatorType(parser, token.getPosition());
            parser.addCode("mul");
        }
    }, DIV(4) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.popStack();
            SemanticTypes t2 = parser.popStack();

            NumericActions.validate(t1, t2, token.getPosition());

            parser.pushStack(SemanticTypes.float64);

            parser.addCode("div");
        }
    }, INT_CONST(5) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            parser.pushStack(SemanticTypes.int64);
            parser.addCode("ldc.i8 " + token.getLexeme());
            parser.addCode("conv.r8");
        }
    }, FLOAT_CONST(6) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            parser.pushStack(SemanticTypes.float64);
            parser.addCode("ldc.r8 " + token.getLexeme());
        }
    }, POSITOVE(7) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.peekStack();
            NumericActions.validate(t1, token.getPosition());
        }
    }, NEGATIVE(8) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            SemanticTypes t1 = parser.peekStack();
            NumericActions.validate(t1, token.getPosition());
            parser.addCode("ldc.r8 -1");
            parser.addCode("mul");
        }
    };

    private static void validate(SemanticTypes t1, SemanticTypes t2, int pos) throws SemanticError {
        NumericActions.validate(t1, pos);
        NumericActions.validate(t2, pos);
    }

    private static void validate(SemanticTypes t1, int pos) throws SemanticError {
        if (SemanticTypes.isNumeric(t1)) {
            throw new SemanticError("Tipos incompatíveis em expressão aritmética", pos);
        }
    }

    private static SemanticTypes getByPriority(SemanticTypes t1, SemanticTypes t2) {
        if (SemanticTypes.float64.equals(t1) || SemanticTypes.float64.equals(t2)) {
            return SemanticTypes.float64;
        } else {
            return SemanticTypes.int64;
        }
    }

    private static void treatBinaryOperatorType(SemanticParser parser, int pos) throws SemanticError {

        SemanticTypes t1 = parser.popStack();
        SemanticTypes t2 = parser.popStack();

        NumericActions.validate(t1, t2, pos);

        SemanticTypes result = NumericActions.getByPriority(t1, t2);
        parser.pushStack(result);

    }

    private int id;

    NumericActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}
