package compilador.semantic.semanticActions;

import compilador.controller.SemanticError;
import compilador.controller.Token;
import compilador.semantic.parser.SemanticParser;

public interface SemanticAction {
    int getNumber();
    void execute(SemanticParser parser, Token token) throws SemanticError;
}