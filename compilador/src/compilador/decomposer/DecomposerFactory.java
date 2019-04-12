package compilador.decomposer;

import compilador.controller.LexicalError;
import compilador.controller.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;

public class DecomposerFactory<T, U> {


    private Optional<DecomposerLexico> innerLexico;
    private Optional<Collector<Token, ?, T>> tokenCollector;
    private Optional<Boolean> pannicMode;
    private Optional<Collector<LexicalError, ?, U>> errorCollector;
    private Optional<PositionCalc> positionCalc;

    private List<LexicalError> errorList;
    private List<Token> tokenList;

    private List<Integer> breakList;

    DecomposerFactory(DecomposerLexico innerLexico) {
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

    public DecomposerFactory setPositionCalc(PositionCalc positionCalc) {
        this.positionCalc = Optional.of(positionCalc);
        return this;
    }

    public Decomposer<T,U> get() {
        this.errorList = new ArrayList<>();
        this.tokenList = new ArrayList<>();

        String input = this.innerLexico.get().getInput();

        this.breakList = new ArrayList<>();
        int breakIndex = input.indexOf('\n');
        while (breakIndex > -1) {
            this.breakList.add(breakIndex);
            breakIndex = input.indexOf('\n', breakIndex+1);
        }

        Token token;
        while ((token = getNext(this.innerLexico.get())) != null)
            tokenList.add(token);

        AtomicReference<T> t = new AtomicReference<>();
        tokenCollector.ifPresent((col) -> t.set(tokenList.stream().collect(col)));

        AtomicReference<U> u = new AtomicReference<>();
        errorCollector.ifPresent((col) -> u.set(errorList.stream().collect(col)));

        return new Decomposer<T, U>(innerLexico.get(), t.get(), u.get());

    }

    public List<Integer> getBreakList() {
        return breakList;
    }

    private DecomposedToken getNext(DecomposerLexico lexico){
        try {
            DecomposedToken token = DecomposedToken.get(lexico.nextToken());
            this.positionCalc.ifPresent((x) -> x.calc(this, token));
            return token;
        } catch (LexicalError lr) {
            DecomposedError dr = DecomposedError.get(lr);
            this.positionCalc.ifPresent((x) -> x.calc(this, dr));
            errorList.add(dr);

            if (this.pannicMode.get()) {
                return null;
            }

            return getNext(lexico);
        }
    }

}
