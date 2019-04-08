package compilador.decomposer;

import compilador.controller.Lexico;

public class Decomposer<T, U> {
    private Lexico innerLexio;
    private T tokens;
    private U errors;

    Decomposer(Lexico innerLexio, T tokens, U errors) {
        this.innerLexio = innerLexio;
        this.tokens = tokens;
        this.errors = errors;
    }

    public Lexico getInnerLexio() {
        return innerLexio;
    }

    public T getTokens() {
        return tokens;
    }

    public U getErrors() {
        return errors;
    }

    public static <T, U> DecomposerFactory<T, U> factory(Lexico lexico){
        return new DecomposerFactory<>(lexico);
    }
}


