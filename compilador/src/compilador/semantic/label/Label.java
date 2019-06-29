package compilador.semantic.label;

import java.util.concurrent.atomic.AtomicInteger;

public class Label {

    private final static AtomicInteger COUNTER = new AtomicInteger();

    private Integer number;

    public Label(){
        this.number = Label.next();
    }

    public int hashCode() {
        return getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Label) {
            Label label = (Label) o;
            return this.hashCode() == label.hashCode();
        }
        return false;
    }

    protected Integer getNumber() {
        return this.number;
    }

    private static int next() {
        return COUNTER.getAndIncrement();
    }

    public String mark() {
        return this.getName()+":";
    }

    public String br() {
        return "br " + this.getName();
    }

    private String getName() {
        return "laber" + this.getNumber();
    }

    public String brFalse() {
        return "brfalse " + this.getName();
    }

    public String brTrue() {
        return "brtrue " + this.getName();
    }
}
