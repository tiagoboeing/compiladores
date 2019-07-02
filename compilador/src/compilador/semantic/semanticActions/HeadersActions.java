package compilador.semantic.semanticActions;

import compilador.controller.SemanticError;
import compilador.controller.Token;
import compilador.semantic.parser.SemanticParser;

public enum HeadersActions implements SemanticAction {
    PROGRAM_HEADER(15) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.addCode(".assembly extern mscorlib {}");
            parser.addCode(".assembly _codigo_objeto{}");
            parser.addCode(".module _codigo_objeto.exe\n");
            parser.addCode(".class public _UNICA{");
        }
    },MAIN_HEADER(16) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.addCode(".method static public void _principal(){");
            parser.addCode(".entrypoint");
        }
    },PROGRAM_FOOTER(17) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.addCode("ret");
            parser.addCode("}");
            parser.addCode("}");
        }
    };

    private int id;

    HeadersActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}
