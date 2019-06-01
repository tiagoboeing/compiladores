package compilador.brocker;

import java.util.function.Consumer;

public interface ParserFactory {

    public Parser getParser() throws Exception;
    //public ParserFactory setPanicMode(Boolean panicMode);

}
