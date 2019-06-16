package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Token;

public interface SemanticAction {
    int getNumber();
    void execute(SemanticParser parser, Token token) throws SemanticError;
}