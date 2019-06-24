package compilador.semanticParser;

import java.util.Arrays;
import java.util.StringJoiner;

public enum RelationalTypes {
    grater(">", "cgt", false),
    smaller("<", "clt", false),
    equals("==", "ceq", false),
    notGrater("<=", "cgt", true),
    notSmaller(">=", "clt", true),
    notEquals("!=", "ceq", true);

    private final String sign;
    private final String code;

    RelationalTypes(String sign, String code, boolean negate) {
        this.sign = sign;
        StringJoiner treatedCode = new StringJoiner("\n");
        treatedCode.add(code);
        if (negate) {
            treatedCode.add("ldc.i4.1");
            treatedCode.add("xor");
        }
        this.code = treatedCode.toString();
    }

    public String getSign() {
        return sign;
    }

    public static RelationalTypes get(String sign) {
        return Arrays.asList(RelationalTypes.values()).stream().filter(x -> x.getSign().equals(sign)).findFirst().get();
    }

    public String getCode() {
        return this.code;
    }

}
