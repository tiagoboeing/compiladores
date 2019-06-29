package compilador.semantic.parser;

import compilador.controller.SemanticError;
import compilador.controller.Semantico;
import compilador.controller.Token;
import compilador.semantic.Constants.OperadorAtribuicao;
import compilador.semantic.Constants.RelationalTypes;
import compilador.semantic.Constants.SemanticTypes;
import compilador.semantic.semanticActions.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class SemanticParser extends Semantico {

    private Stack<SemanticTypes> typeStack = new Stack();

    private StringJoiner code = new StringJoiner("\n");

    private AtomicReference<RelationalTypes> relational = new AtomicReference<>();
    private AtomicReference<SemanticTypes> variableType = new AtomicReference<>();
    private AtomicReference<OperadorAtribuicao> atribuicao = new AtomicReference<>();

    private Stack<String> identifierStack = new Stack<>();
    private Map<String, SemanticTypes> idMap = new HashMap<>();

    private void executeAction(SemanticAction action, Token token) throws SemanticError {
        action.execute(this, token);
    }

    public void executeAction(int action, Token token)	throws SemanticError {
        System.out.println("Ação #"+action+", Token: "+token);

        SemanticAction semanticAction = SemanticActionGrouper.getAction(action);

        if (semanticAction != null) {
            executeAction(semanticAction, token);
            return;
        }

        System.out.println("Ação " + action + " não implementada");

    }

    //

    public String getCode() {
        return code.toString();
    }

    public StringJoiner addCode(CharSequence charSequence) {
        return code.add(charSequence);
    }

    //

    public RelationalTypes getRelational() {
        return relational.get();
    }

    public void setRelational(RelationalTypes relationalTypes) {
        relational.set(relationalTypes);
    }

    //

    public SemanticTypes getVariableType() {
        return variableType.get();
    }

    public void setVariableType(SemanticTypes semanticTypes) {
        variableType.set(semanticTypes);
    }

    //

    public OperadorAtribuicao getAtribution() {
        return atribuicao.get();
    }

    public void setAtribution(OperadorAtribuicao operadorAtribuicao) {
        atribuicao.set(operadorAtribuicao);
    }

    //

    public void pushIdentificagor(String s) {
        identifierStack.push(s);
    }

    public void clearIdentificador() {
        identifierStack.clear();
    }

    public Iterable<String> identificadorIterable() {
        return identifierStack;
    }

    public String popIdentificador() {
        return identifierStack.remove(0);
    }

    public String peekIdentificador() {
        return identifierStack.get(0);
    }

    //

    public boolean identifierMapContains(String id) {
        return idMap.containsKey(id);
    }

    public SemanticTypes identifierMapGetType(String id) {
        return idMap.get(id);
    }

    public SemanticTypes identifierMapPut(String s, SemanticTypes semanticTypes) {
        return idMap.put(s, semanticTypes);
    }

    //

    public SemanticTypes pushType(SemanticTypes semanticTypes) {
        return typeStack.push(semanticTypes);
    }

    public SemanticTypes popType() {
        return typeStack.pop();
    }

    public SemanticTypes peekType() {
        return typeStack.peek();
    }
}
