package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Semantico;
import compilador.controller.Token;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class SemanticParser extends Semantico {

    private Stack<SemanticTypes> stack = new Stack();
    private StringJoiner code = new StringJoiner("\n");
    private AtomicReference<RelationalTypes> relational;

    private static List<SemanticAction> actionList;
    static {
        actionList = new ArrayList<>();
        actionList.addAll(Arrays.asList(BooleanActions.values()));
        actionList.addAll(Arrays.asList(InterfaceActions.values()));
        actionList.addAll(Arrays.asList(HeadersActions.values()));
        actionList.addAll(Arrays.asList(NumericActions.values()));
    }

    private static SemanticAction getAction(int actionId) {
        return actionList.stream().filter(x -> x.getNumber() == actionId).findFirst().get();
    }

    private void executeAcion(SemanticAction action, Token token) throws SemanticError {
        action.execute(this, token);
    }

    public void executeAction(int action, Token token)	throws SemanticError {
        System.out.println("Ação #"+action+", Token: "+token);

        SemanticAction semanticAction = getAction(action);

        if (semanticAction != null) {
            executeAcion(semanticAction, token);
            return;
        }

        throw new SemanticError("Ação " + action + " não implementada", token.getPosition());

    }

    public void resultado(){
        System.out.println(this.stack.toString());
    }

    public String getCode() {
        return code.toString()  ;
    }

    public StringJoiner addCode(CharSequence charSequence) {
        return code.add(charSequence);
    }

    public SemanticTypes pushStack(SemanticTypes semanticTypes) {
        return stack.push(semanticTypes);
    }

    public SemanticTypes popStack() {
        return stack.pop();
    }

    public SemanticTypes peekStack() {
        return stack.peek();
    }

    public RelationalTypes getRelational() {
        return relational.get();
    }

    public void setRelational(RelationalTypes relationalTypes) {
        relational.set(relationalTypes);
    }
}
