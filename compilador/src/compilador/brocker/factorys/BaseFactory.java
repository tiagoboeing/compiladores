package compilador.brocker.factorys;

import compilador.brocker.Parser;
import compilador.brocker.ParserFactory;
import compilador.brocker.PositionCalc;
import compilador.brocker.parsers.BaseParser;
import compilador.controller.Lexico;
import compilador.controller.Semantico;
import compilador.controller.Sintatico;

import java.io.Reader;
import java.util.List;

public class BaseFactory implements ParserFactory {

    private Reader reader;
    private List<Integer> lineEndings;

    public BaseFactory(Reader reader, List<Integer> lineEndings) {
        this.reader = reader;
        this.lineEndings = lineEndings;
    }

    @Override
    public Parser getParser() throws NullPointerException {

        if (this.reader == null) {
            throw new NullPointerException("Fonte não encontrado");
        }

        if (this.lineEndings == null) {
            throw new NullPointerException("Lista de posições indisponível");
        }

        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();

        Lexico lexico = new Lexico();
        lexico.setInput(this.reader);

        return new BaseParser(sintatico, semantico, lexico, this::getLine, this::calcColumn);

    }

    protected int calcColumn(Integer abs) {
        return PositionCalc.getColumn(abs, this.lineEndings);
    }

    protected int getLine(Integer abs) {
        return PositionCalc.getLine(abs, this.lineEndings);
    }

}
