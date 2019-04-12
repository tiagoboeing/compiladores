package compilador.decomposer;

import compilador.controller.Lexico;

public class DecomposerLexico extends Lexico {

    public DecomposerLexico(String input){
        super(input);
    }

    public String getInput() {
        return this.input;
    }

    public int getPostiont() {
        return this.position;
    }
}
