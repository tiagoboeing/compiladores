package compilador.brocker;

import compilador.brocker.parsers.ParseException;
import compilador.controller.Semantico;

public interface Parser {
//    public Sintatico getsintatico();
//    public Lexico getSinLexico();
//    public Semantico getSemantico();

    public String getCode();

    public void parse() throws ParseException;

}
