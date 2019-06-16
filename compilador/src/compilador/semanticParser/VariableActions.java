package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Token;

public enum VariableActions implements SemanticAction {
    DECLARE_TYPE(30) {

        private static final String INT = "int";
        private static final String REAL = "float";

        @Override
        public void execute(SemanticParser parser, Token token) {
            String lexeme = token.getLexeme();
            if (INT.equals(lexeme)) {
                parser.setVariableType(SemanticTypes.int64);
            } else if (REAL.equals(lexeme)) {
                parser.setVariableType(SemanticTypes.float64);
            }
        }
    },
    BIND(31) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            for (String lexeme : parser.idListIterable()) {
                if (parser.idMapContains(lexeme)) {
                    throw new SemanticError("Variável " + lexeme + " já declarada", token.getPosition());
                }
                parser.idMapPut(lexeme, parser.getVariable());
                parser.addCode(".locals(" + parser.getVariable().name() + " " + lexeme + ")");
            }
            parser.clearIdList();
        }
    },
    DECLARE_NAME(32) {
        @Override
        public void execute(SemanticParser parser, Token token) {
            parser.addIdList(token.getLexeme());
        }
    },
    GET(33) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            String lexeme = token.getLexeme();
            if (!parser.idMapContains(lexeme)) {
                throw new SemanticError("Variável " + lexeme + " não declarada", token.getPosition());
            }
            SemanticTypes t1 = parser.idMapGet(lexeme);
            parser.pushStack(t1);
            parser.addCode("ldloc "+lexeme);
            if (SemanticTypes.int64.equals(t1)) {
                parser.addCode("conv.r8");
            }
        }
    },
    SET(34) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            String lexeme = parser.idListPop();
            if (!parser.idMapContains(lexeme)) {
                throw new SemanticError("Variável " + lexeme + " não declarada", token.getPosition());
            }
            SemanticTypes t1 = parser.idMapGet(lexeme);
            SemanticTypes t2 = parser.popStack();
            if (!t1.equals(t2)) {
                throw new SemanticError("Tipos incompatíveis: " + t1.name() + " e " + t2.name(), token.getPosition());
            }

            if (SemanticTypes.int64.equals(t1)) {
                parser.addCode("conv.i8");
            }

            parser.addCode("stloc " + lexeme);
        }
    },
    READ(35) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            for (String lexeme : parser.idListIterable()) {
                if (!parser.idMapContains(lexeme)) {
                    throw new SemanticError("Variável " + lexeme + " não declarada", token.getPosition());
                }
                SemanticTypes t1 = parser.idMapGet(lexeme);
                parser.addCode("call string [mscorlib]System.Console::ReadLine()");
                parser.addCode("call " + t1.name() + " [mscorlib]System." + t1.getInputType() + "::Parse(string)");
                parser.addCode("stloc " + lexeme);
            }
            parser.clearIdList();
        }
    };

    private int id;

    VariableActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}