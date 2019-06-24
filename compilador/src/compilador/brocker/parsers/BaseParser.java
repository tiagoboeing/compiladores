package compilador.brocker.parsers;

import compilador.brocker.Parser;
import compilador.controller.*;

import java.util.function.Function;

public class BaseParser implements Parser {

    private Sintatico sintatico;
    private Semantico semantico;
    private Lexico lexico;

    private Function<Integer, Integer> calcLine;
    private Function<Integer, Integer> calcColumn;

    public BaseParser(Sintatico sintatico, Semantico semantico, Lexico lexico, Function<Integer, Integer> calcLine, Function<Integer, Integer> calcColumn) {
        this.sintatico = sintatico;
        this.semantico = semantico;
        this.lexico = lexico;
        this.calcLine = calcLine;
        this.calcColumn = calcColumn;
    }

    @Override
    public void parse() throws ParseException {
        try {
            this.sintatico.parse(this.lexico, this.semantico);
        } catch (LexicalError le) {
            throw getException(le.getPosition(), le.getMessage(), le.getLex());
        } catch (SyntaticError si) {
            throw getException(si.getPosition(), si.getMessage(), si.getLex());
        } catch (SemanticError se) {
            throw getException(se.getPosition(), se.getMessage());
        }

        System.out.println(this.semantico.getCode());
    }

    public String getCode(){
        return this.semantico.getCode();
    }

    private ParseException getException(int absPos, String msg) {
        int col = calcColumn.apply(absPos);
        int lin = calcLine.apply(absPos);
        return ParseException.get(col, lin, msg);
    }

    private ParseException getException(int absPos, String msg, String lex) {
        int col = calcColumn.apply(absPos);
        int lin = calcLine.apply(absPos);
        return ParseException.get(col, lin, msg, lex);
    }


}