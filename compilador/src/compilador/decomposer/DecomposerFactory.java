package compilador.decomposer;

import compilador.controller.LexicalError;
import compilador.controller.Lexico;
import compilador.controller.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;

public class DecomposerFactory<T, U> {


    private Optional<Lexico> innerLexico;
    private Optional<Collector<Token, ?, T>> tokenCollector;
    private Optional<Boolean> pannicMode;
    private Optional<Collector<LexicalError, ?, U>> errorCollector;

    private List<LexicalError> errorList;
    private List<Token> tokenList;

    DecomposerFactory(Lexico innerLexico) {
        this.innerLexico = Optional.of(innerLexico);
    }

    public DecomposerFactory setTokenCollector(Collector<Token, ?, T> tokenCollector) {
        this.tokenCollector = Optional.of(tokenCollector);
        return this;
    }

    public DecomposerFactory setPannicMode(Boolean pannicMode) {
        this.pannicMode = Optional.of(pannicMode);
        return this;
    }

    public DecomposerFactory setErrorCollector(Collector<LexicalError, ?, U> errorCollector) {
        this.errorCollector = Optional.of(errorCollector);
        return this;
    }

    public Decomposer<T,U> get() {
        this.errorList = new ArrayList<>();
        this.tokenList = new ArrayList<>();

        Token token;
        while ((token = getNext(this.innerLexico.get())) != null)
            tokenList.add(token);

        AtomicReference<T> t = new AtomicReference<>();
        tokenCollector.ifPresent((col) -> t.set(tokenList.stream().collect(col)));

        AtomicReference<U> u = new AtomicReference<>();
        errorCollector.ifPresent((col) -> u.set(errorList.stream().collect(col)));

        return new Decomposer<T, U>(innerLexico.get(), t.get(), u.get());

    }

    private Token getNext(Lexico lexico){
        try {
            return lexico.nextToken();
        } catch (LexicalError lr) {
            errorList.add(lr);

            if (this.pannicMode.get()) {
                return null;
            }

            return getNext(lexico);
        }
    }

}
