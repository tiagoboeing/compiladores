package compilador.semanticParser;

import java.util.Arrays;

public enum RelationalTypes {
    cgt(">"),
    clt("<"),
    ceq("==");

    private final String sign;

    RelationalTypes(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static RelationalTypes get(String sign) {
        return Arrays.asList(RelationalTypes.values()).stream().filter(x -> x.getSign().equals(sign)).findFirst().get();
    }
}
