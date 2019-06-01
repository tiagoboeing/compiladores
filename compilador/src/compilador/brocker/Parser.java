package compilador.brocker;

import compilador.brocker.parsers.ParseException;

public interface Parser {
//    public Sintatico getsintatico();
//    public Lexico getSinLexico();
//    public Semantico getSemantico();

    public void parse() throws ParseException;

}
