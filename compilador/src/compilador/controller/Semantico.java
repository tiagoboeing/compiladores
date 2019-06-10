package compilador.controller;

import java.util.Stack;

public class Semantico implements Constants
{
    private Stack stack = new Stack();
    private StringBuilder code = new StringBuilder();

    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
        switch (action){
            case 15:
                code.append(".assembly extern mscorlib { } \n" +
                                ".assembly _codigo_objeto{} \n" +
                                ".module _codigo_objeto.exe \n\n" +
                                ".class public _UNICA {");
                break;

            case 16:
                break;
        }
    }

    public void resultado(){
        System.out.println(this.stack.toString());
    }

    public StringBuilder getCode() {
        return code;
    }
}
