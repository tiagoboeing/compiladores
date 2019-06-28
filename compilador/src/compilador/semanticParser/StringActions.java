package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Token;

public enum StringActions implements SemanticAction {
    CONST(21) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.pushType(SemanticTypes.string);
            parser.addCode("ldstr " + token.getLexeme());
        }
    };

    private int id;

    StringActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }
}
