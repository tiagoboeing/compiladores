package compilador.semantic.semanticActions;

import compilador.controller.SemanticError;
import compilador.controller.Token;
import compilador.semantic.label.Label;
import compilador.semantic.parser.SemanticParser;

public enum FluxControlActions implements SemanticAction {

    EXP(37) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            Label l1 = new Label();
            parser.pushLabel(l1);
            parser.addCode(l1.mark());
        }
    },
    IF(38){
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.popLabel();//if não precisa verificar novamente

            Label l1 = new Label();
            parser.pushLabel(l1);
            parser.addCode(l1.brFalse());//se for falso, pula para o label que ainda não foi inserido
        }
    },
    ENDIF(39){
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            Label l1 = parser.popLabel();//insere o label para qual pulariam que está na fila
            parser.addCode(l1.mark());
        }
    },
    ELSE(40){
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {

            Label l1 = new Label();
            parser.addCode(l1.br());//Se chegou aqui, pula para o fim do bloco

            parser.addCode(parser.popLabel().mark());//fim do bloco anterior

            parser.pushLabel(l1);
        }
    },;

    private int id;

    FluxControlActions(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }

}
