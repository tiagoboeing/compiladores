package compilador.controller;

public interface ParserConstants
{
    int START_SYMBOL = 49;

    int FIRST_NON_TERMINAL    = 49;
    int FIRST_SEMANTIC_ACTION = 98;

    int[][] PARSER_TABLE =
    {
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   0,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,   2,  -1,  -1,  -1,  -1,  -1,   1,  -1,  -1,  -1,  -1,   2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   3,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,   4,  -1,  -1,  -1,  -1,  -1,   5,  -1,  -1,  -1,  -1,   4,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,   7,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   6,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  10,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,   8,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   9,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  11,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  14,  15,  -1,  -1,  13,  -1,  -1,  -1,  12,  -1,  -1,  -1,  -1,  -1,  16,  -1,  17,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  20,  21,  -1,  -1,  19,  -1,  -1,  -1,  18,  -1,  -1,  -1,  -1,  -1,  22,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  24,  24,  -1,  -1,  24,  -1,  -1,  -1,  24,  -1,  -1,  -1,  -1,  -1,  24,  -1,  -1,  -1,  -1,  -1,  -1,  23,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  25,  25,  -1,  -1,  25,  -1,  -1,  -1,  25,  -1,  -1,  -1,  -1,  -1,  25,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  26,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  27,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  28,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  29,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  30,  29,  29,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  31,  31,  -1,  -1,  31,  -1,  -1,  -1,  31,  -1,  -1,  -1,  -1,  -1,  31,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  32,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  33,  -1,  -1,  -1,  -1,  -1,  -1,  33,  33,  -1,  -1,  33,  -1,  -1,  -1,  33,  -1,  -1,  -1,  -1,  33,  33,  -1,  -1,  -1,  -1,  33,  33,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  33 },
        {  -1,  34,  -1,  -1,  -1,  -1,  -1,  -1,  35,  35,  -1,  -1,  35,  -1,  -1,  -1,  35,  -1,  -1,  -1,  -1,  34,  35,  -1,  -1,  -1,  -1,  34,  34,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  34 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  36,  36,  -1,  -1,  36,  -1,  -1,  -1,  36,  -1,  -1,  -1,  -1,  -1,  36,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  37,  -1,  -1,  -1,  -1,  -1,  -1,  38,  38,  -1,  -1,  38,  -1,  -1,  -1,  38,  -1,  -1,  -1,  -1,  37,  38,  -1,  -1,  -1,  -1,  37,  37,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  37 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  39,  39,  -1,  -1,  39,  -1,  -1,  -1,  39,  -1,  -1,  -1,  -1,  -1,  39,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  40,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  40,  -1,  -1,  -1,  -1,  -1,  40,  40,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  40 },
        {  -1,  41,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  42,  -1,  -1,  -1,  42,  -1,  -1,  -1,  -1,  -1,  -1,  41,  -1,  -1,  -1,  -1,  -1,  41,  41,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  41 },
        {  -1,  43,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  44,  -1,  -1,  -1,  -1,  -1,  45,  46,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  47 },
        {  -1,  55,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  56,  57,  58,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  60,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  61,  61,  61,  61,  61,  -1,  -1,  -1,  -1,  -1,  61,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  61,  -1,  -1,  -1,  61,  -1,  -1,  -1,  -1,  61,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  61,  61,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  62,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  63,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  50,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  52,  -1,  -1,  -1,  51,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  54,  53,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  64 },
        {  -1,  82,  82,  82,  82,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  82,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  85,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  85,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  85,  85,  85,  85,  85,  85,  85,  83,  84,  -1,  -1,  85,  85,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  75,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  75,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  75,  74,  74,  74,  74,  74,  74,  -1,  -1,  -1,  -1,  75,  75,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  76,  77,  78,  79,  80,  81,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  65,  65,  65,  65,  65,  -1,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  65,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  66,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  67,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  68,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  68,  68,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  59,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  69,  69,  69,  69,  69,  -1,  -1,  -1,  -1,  -1,  71,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  72,  -1,  -1,  -1,  70,  -1,  -1,  -1,  -1,  69,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  69,  69,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  73,  73,  73,  73,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  73,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  48,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  49,  49,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  86,  86,  86,  86,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  86,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  90,  91,  92,  94,  93,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  95,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  96,  97,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  98,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  98,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  99,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1, 101, 101, 101, 101, 101,  -1,  -1,  -1,  -1,  -1, 101,  -1,  -1,  -1,  -1,  -1,  -1,  -1, 101,  -1,  -1,  -1, 101,  -1,  -1,  -1,  -1, 101, 100,  -1,  -1,  -1,  -1,  -1,  -1, 101, 101,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  89,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  89,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  89,  89,  89,  89,  89,  89,  89,  89,  89,  87,  88,  89,  89,  -1,  -1,  -1,  -1,  -1,  -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 113,  18,  50,  53, 114,   8,  66,  11, 115 },
        {  51 },
        {   0 },
        {  56,  52 },
        {   0 },
        {  56,  52 },
        {  54 },
        {   0 },
        {   0 },
        {  54 },
        {  65,  55 },
        {  14,  19,  57,   2,  29,  59,  30 },
        {  17 },
        {  13 },
        {   9 },
        {  10 },
        {  23 },
        {  25 },
        {  17 },
        {  13 },
        {   9 },
        {  10 },
        {  23 },
        {   0 },
        {  60 },
        {  64,  61 },
        {   0 },
        {  43,  60 },
        {   2, 130,  63 },
        {   0 },
        {  41,  62 },
        {  58,  44,  62, 129 },
        {  19,   2,   8,  66,  11 },
        {  67,  71 },
        {   0 },
        {  68 },
        {  70,  69 },
        {   0 },
        {  68 },
        {  58, 128,  44,  62,  42, 129 },
        {  73,  42,  72 },
        {  71 },
        {   0 },
        {  74 },
        {  89 },
        {  76 },
        { 135,  29,  87,  30,  92 },
        {  82 },
        {  79 },
        {  81 },
        {  16, 136,  71,  80,  11, 137 },
        { 138,  15,  71 },
        {   0 },
        {  27, 139,  71,  11, 140 },
        {  26, 139,  71,  11, 140 },
        {   2, 130,  75, 134,  87, 132 },
        {  45 },
        {  46 },
        {  47 },
        {  22,  29,  62, 133,  30 },
        {  28,  29,  77,  30 },
        {  87, 112,  78 },
        {   0 },
        {  41,  77 },
        {  48,  87 },
        {  90,  88 },
        {   7,  90, 116,  88 },
        {  21,  90, 117,  88 },
        {   0 },
        {  91 },
        {  24, 109 },
        {  12, 110 },
        {  20,  90, 111 },
        {  83,  85 },
        {  86, 107,  83, 108 },
        {   0 },
        {  31 },
        {  32 },
        {  33 },
        {  34 },
        {  35 },
        {  36 },
        {  93,  84 },
        {  37,  93,  99,  84 },
        {  38,  93, 100,  84 },
        {   0 },
        {  94,  97 },
        {  39,  94, 101,  97 },
        {  40,  94, 102,  97 },
        {   0 },
        {   2, 131,  95 },
        {   3, 103 },
        {   4, 104 },
        {   6, 118 },
        {   5, 119 },
        {  29,  87,  30 },
        {  37,  94, 105 },
        {  38,  94, 106 },
        { 131 },
        {  29,  96 },
        {  30 },
        {  77,  30 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "Era esperado fim de programa",
        "Era esperado id",
        "Era esperado const_inteira",
        "Era esperado const_real",
        "Era esperado const_literal",
        "Era esperado const_caracter",
        "Era esperado and",
        "Era esperado begin",
        "Era esperado bool",
        "Era esperado char",
        "Era esperado end",
        "Era esperado false",
        "Era esperado float",
        "Era esperado forward",
        "Era esperado ifFalseDo",
        "Era esperado ifTrueDo",
        "Era esperado int",
        "Era esperado main",
        "Era esperado module",
        "Era esperado not",
        "Era esperado or",
        "Era esperado read",
        "Era esperado string",
        "Era esperado true",
        "Era esperado void",
        "Era esperado whileFalseDo",
        "Era esperado whileTrueDo",
        "Era esperado write",
        "Era esperado \"(\"",
        "Era esperado \")\"",
        "Era esperado \"==\"",
        "Era esperado \"!=\"",
        "Era esperado \"<\"",
        "Era esperado \"<=\"",
        "Era esperado \">\"",
        "Era esperado \">=\"",
        "Era esperado \"+\"",
        "Era esperado \"-\"",
        "Era esperado \"*\"",
        "Era esperado \"/\"",
        "Era esperado \",\"",
        "Era esperado \".\"",
        "Era esperado \";\"",
        "Era esperado \":\"",
        "Era esperado \"=\"",
        "Era esperado \"+=\"",
        "Era esperado \"-=\"",
        "Era esperado \"^\"",
        "<forma_geral_do_programa> inv�lido",
        "<declaracao_main> inv�lido",
        "<lista_declaracao> inv�lido",
        "<lista_declaracao1> inv�lido",
        "<modulo> inv�lido",
        "<lista_modulo> inv�lido",
        "<lista_modulo1> inv�lido",
        "<declaracao> inv�lido",
        "<tipo_modulo> inv�lido",
        "<tipo> inv�lido",
        "<parametros_formais> inv�lido",
        "<lista_parametro> inv�lido",
        "<lista_parametro1> inv�lido",
        "<lista_de_identificadores> inv�lido",
        "<lista_de_identificadores1> inv�lido",
        "<parametro> inv�lido",
        "<forma_geral> inv�lido",
        "<corpo> inv�lido",
        "<declaracao_de_variaveis> inv�lido",
        "<lista_de_variaveis> inv�lido",
        "<lista_de_variaveis1> inv�lido",
        "<variavel> inv�lido",
        "<lista_de_comandos> inv�lido",
        "<lista_de_comandos1> inv�lido",
        "<comando> inv�lido",
        "<atribuicao> inv�lido",
        "<operador_de_atribuicao> inv�lido",
        "<saida> inv�lido",
        "<lista_de_expressoes> inv�lido",
        "<lista_de_expressoes1> inv�lido",
        "<selecao> inv�lido",
        "<else> inv�lido",
        "<repeticao> inv�lido",
        "<retorno> inv�lido",
        "<aritmetica> inv�lido",
        "<aritmetica1> inv�lido",
        "<relacional1> inv�lido",
        "<operador_relacional> inv�lido",
        "<expressao> inv�lido",
        "<expressao1> inv�lido",
        "<entrada> inv�lido",
        "<elemento> inv�lido",
        "<relacional> inv�lido",
        "<comando1> inv�lido",
        "<termo> inv�lido",
        "<fator> inv�lido",
        "<fator1> inv�lido",
        "<fator2> inv�lido",
        "<termo1> inv�lido"
    };
}
