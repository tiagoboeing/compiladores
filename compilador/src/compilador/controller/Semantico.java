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

            /*
            case: 11
                pilha.empilha (bool)
                código.adiciona (ldc.i4.1)
                break;
            */

            /*
            case: 12
                pilha.empilha (bool)
                código.adiciona (ldc.i4.0)
                break;
            */

            /*
            case 13:
                tipo:= pilha.desempilha
                se(tipo=bool)
                então pilha.empilha (bool)
                senão erro semântico, parar
                fimse
                código.adiciona (ldc.i4.1)
                código.adiciona (xor)
                break;
            */

            /*
            case 14:
                tipo := pilha.desempilha
                se(tipo=int64)
                então código.adiciona (conv.i8)
                fimse
                código.adiciona("call void[mscorlib]System.Console::Write(" + tipo + ")")
                break;
             */

            case 15:
                code.append(".assembly extern mscorlib {}\n" +
                                ".assembly _codigo_objeto{}\n" +
                                ".module _codigo_objeto.exe\n\n" +
                                ".class public _UNICA{\n");
                break;

            case 16:
                code.append(".method static public void _principal(){\n" +
                            ".entrypoint\n");
                break;

            case 17:
                code.append("ret\n" +
                            "}\n" +
                            "}");
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
