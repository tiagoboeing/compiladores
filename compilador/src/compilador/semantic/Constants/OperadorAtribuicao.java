package compilador.semantic.Constants;

import compilador.semantic.parser.SemanticParser;

import java.util.Arrays;

public enum OperadorAtribuicao {

    EQ("=", false),
    PEQ("+=", true) {
        @Override
        public void execute(SemanticParser parser, String lexeme) {
            parser.addCode("add");
            super.execute(parser, lexeme);
        }
    },
    SEQ("-=", true) {
        @Override
        public void execute(SemanticParser parser, String lexeme) {
            parser.addCode("sub");
            super.execute(parser, lexeme);
        }
    },;

    private String lexeme;
    private boolean loc;

    OperadorAtribuicao(String lexeme, boolean loc) {
        this.lexeme = lexeme;
        this.loc = loc;
    }

    public void execute(SemanticParser parser, String lexeme) {
        SemanticTypes t1 = parser.identifierMapGetType(lexeme);
        if (SemanticTypes.int64.equals(t1))
            parser.addCode("conv.i8");

        parser.addCode("stloc " + lexeme);
    };

    public void load(SemanticParser parser, String lexeme) {
        if (this.loc) {
            SemanticTypes t1 = parser.identifierMapGetType(lexeme);
            parser.addCode("stloc " + lexeme); //TODO - Validate
            if (SemanticTypes.int64.equals(t1))
                parser.addCode("conv.r8");
        }
    }

    public static OperadorAtribuicao get(String lexeme) {
        return Arrays.asList(OperadorAtribuicao.values()).stream().filter(x->x.lexeme.equals(lexeme)).findFirst().get();
    }
}
