package compilador.semantic.semanticActions;

import compilador.controller.SemanticError;
import compilador.controller.Token;
import compilador.semantic.label.Label;
import compilador.semantic.parser.SemanticParser;

public enum FluxControlActions implements SemanticAction {

    EXP(37) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            Label l1 = new Label();//inicializa marcador da condição.
            parser.pushLabel(l1);
            parser.addCode(l1.mark());
        }
    },
    IF(38){
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            parser.popLabel();//if não precisa verificar a condição novamente

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
    },
    WHILE(41) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            Label l1 = new Label();
            parser.addCode(this.getCode(l1, token));//se não satisfizer a condição, sai do loop
            parser.pushLabel(l1);
        }

        private boolean isNegative(Token token) {
            String lexeme = token.getLexeme();
            return lexeme.toUpperCase().contains("FALSE");
        }

        private String getCode(Label l1, Token token) {
            if (this.isNegative(token))
                return l1.brTrue();
            return l1.brFalse();
        }
    },
    ENDWHILE(42) {
        @Override
        public void execute(SemanticParser parser, Token token) throws SemanticError {
            Label l2 = parser.popLabel();
            Label l1 = parser.popLabel();

            parser.addCode(l1.br());//no final do bloco do loop, pula para a verificação
            parser.addCode(l2.mark());//label após o bloco.
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
