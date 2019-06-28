package compilador.semanticParser;

import compilador.controller.SemanticError;
import compilador.controller.Semantico;
import compilador.controller.Token;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class SemanticParser extends Semantico {

    private Stack<SemanticTypes> typeStack = new Stack();

    private StringJoiner code = new StringJoiner("\n");

    private AtomicReference<RelationalTypes> relational = new AtomicReference<>();
    private AtomicReference<SemanticTypes> variableType = new AtomicReference<>();
    private AtomicReference<OperadorAtribuicao> atribuicao = new AtomicReference<>();

    private List<String> idList = new ArrayList<>();
    private Map<String, SemanticTypes> idMap = new HashMap<>();

    private static List<SemanticAction> actionList;
    static {
        actionList = new ArrayList<>();
        actionList.addAll(Arrays.asList(BooleanActions.values()));
        actionList.addAll(Arrays.asList(InterfaceActions.values()));
        actionList.addAll(Arrays.asList(HeadersActions.values()));
        actionList.addAll(Arrays.asList(NumericActions.values()));
        actionList.addAll(Arrays.asList(VariableActions.values()));
    }

    private static SemanticAction getAction(int actionId) {
        return actionList.stream().filter(x -> x.getNumber() == actionId).findFirst().orElse(null);
    }

    private void executeAction(SemanticAction action, Token token) throws SemanticError {
        action.execute(this, token);
    }

    public void executeAction(int action, Token token)	throws SemanticError {
        System.out.println("Ação #"+action+", Token: "+token);

        SemanticAction semanticAction = getAction(action);

        if (semanticAction != null) {
            executeAction(semanticAction, token);
            return;
        }

        throw new SemanticError("Ação " + action + " não implementada", token.getPosition());

    }

    public String getCode() {
        return code.toString();
    }

    public StringJoiner addCode(CharSequence charSequence) {
        return code.add(charSequence);
    }

    public SemanticTypes pushType(SemanticTypes semanticTypes) {
        return typeStack.push(semanticTypes);
    }

    public SemanticTypes popType() {
        return typeStack.pop();
    }

    public SemanticTypes peekType() {
        return typeStack.peek();
    }

    public RelationalTypes getRelational() {
        return relational.get();
    }

    public void setRelational(RelationalTypes relationalTypes) {
        relational.set(relationalTypes);
    }

    public SemanticTypes getVariable() {
        return variableType.get();
    }

    public void setVariableType(SemanticTypes semanticTypes) {
        variableType.set(semanticTypes);
    }

    public void addIdList(String s) {
        idList.add(s);
    }

    public void clearIdList() {
        idList.clear();
    }

    public Iterable<String> idListIterable() {
        return idList;
    }

    public String idListPop() {
        return idList.remove(0);
    }

    public String idListPeek() {
        return idList.get(0);
    }

    public boolean idMapContains(String id) {
        return idMap.containsKey(id);
    }

    public SemanticTypes idMapGetType(String id) {
        return idMap.get(id);
    }

    public SemanticTypes idMapPut(String s, SemanticTypes semanticTypes) {
        return idMap.put(s, semanticTypes);
    }

    public OperadorAtribuicao getAtribuicao() {
        return atribuicao.get();
    }

    public void setAtribuicao(OperadorAtribuicao operadorAtribuicao) {
        atribuicao.set(operadorAtribuicao);
    }
}
