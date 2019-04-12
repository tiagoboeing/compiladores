package compilador.decomposer;

import compilador.controller.Lexico;

public class DecomposerLexico extends Lexico {

    private String input;

    public DecomposerLexico(String input){
        super(input);
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }
}
