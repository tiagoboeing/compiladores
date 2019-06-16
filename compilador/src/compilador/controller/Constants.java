package compilador.controller;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_id = 2;
    int t_const_inteira = 3;
    int t_const_real = 4;
    int t_const_literal = 5;
    int t_const_caracter = 6;
    int t_comentario_linha = 7;
    int t_comentario_bloco = 8;
    int t_and = 9;
    int t_begin = 10;
    int t_bool = 11;
    int t_char = 12;
    int t_end = 13;
    int t_false = 14;
    int t_float = 15;
    int t_forward = 16;
    int t_ifFalseDo = 17;
    int t_ifTrueDo = 18;
    int t_int = 19;
    int t_main = 20;
    int t_module = 21;
    int t_not = 22;
    int t_or = 23;
    int t_read = 24;
    int t_string = 25;
    int t_true = 26;
    int t_void = 27;
    int t_whileFalseDo = 28;
    int t_whileTrueDo = 29;
    int t_write = 30;
    int t_TOKEN_31 = 31; //"("
    int t_TOKEN_32 = 32; //")"
    int t_TOKEN_33 = 33; //"=="
    int t_TOKEN_34 = 34; //"!="
    int t_TOKEN_35 = 35; //"<"
    int t_TOKEN_36 = 36; //"<="
    int t_TOKEN_37 = 37; //">"
    int t_TOKEN_38 = 38; //">="
    int t_TOKEN_39 = 39; //"+"
    int t_TOKEN_40 = 40; //"-"
    int t_TOKEN_41 = 41; //"*"
    int t_TOKEN_42 = 42; //"/"
    int t_TOKEN_43 = 43; //","
    int t_TOKEN_44 = 44; //"."
    int t_TOKEN_45 = 45; //";"
    int t_TOKEN_46 = 46; //":"
    int t_TOKEN_47 = 47; //"="
    int t_TOKEN_48 = 48; //"+="
    int t_TOKEN_49 = 49; //"-="
    int t_TOKEN_50 = 50; //"^"
    int t_TOKEN_51 = 51; //":="

}
