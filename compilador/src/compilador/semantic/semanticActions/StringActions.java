package compilador.semantic.semanticActions;

import compilador.controller.SemanticError;
import compilador.controller.Token;
import compilador.semantic.parser.SemanticParser;
import compilador.semantic.Constants.SemanticTypes;

public enum StringActions implements SemanticAction {
    CTE_STR(21) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.pushType(SemanticTypes.string);
            parser.addCode("ldstr " + token.getLexeme());
        }
    },
    CTE_CHAR(20) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            String lexeme = token.getLexeme();
            if (lexeme.endsWith("s"))
                lexeme = " ";
            parser.pushType(SemanticTypes.string);
            parser.addCode("ldstr \"" + lexeme + "\"");
        }
    },;

    private int id;

    StringActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}
