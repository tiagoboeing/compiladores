public interface ParserConstants
{
    int START_SYMBOL = 52;

    int FIRST_NON_TERMINAL    = 52;
    int FIRST_SEMANTIC_ACTION = 101;

    int[][] PARSER_TABLE =
    {
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   0,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   2,  -1,  -1,  -1,  -1,  -1,   1,  -1,  -1,  -1,  -1,   2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   3,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   4,  -1,  -1,  -1,  -1,  -1,   5,  -1,  -1,  -1,  -1,   4,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   7,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   6,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  10,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   8,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   9,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  11,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  14,  15,  -1,  -1,  13,  -1,  -1,  -1,  12,  -1,  -1,  -1,  -1,  -1,  16,  -1,  17,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  20,  21,  -1,  -1,  19,  -1,  -1,  -1,  18,  -1,  -1,  -1,  -1,  -1,  22,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  24,  24,  -1,  -1,  24,  -1,  -1,  -1,  24,  -1,  -1,  -1,  -1,  -1,  24,  -1,  -1,  -1,  -1,  -1,  -1,  23,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  25,  25,  -1,  -1,  25,  -1,  -1,  -1,  25,  -1,  -1,  -1,  -1,  -1,  25,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  26,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  27,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  28,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  29,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  30,  29,  29,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  31,  31,  -1,  -1,  31,  -1,  -1,  -1,  31,  -1,  -1,  -1,  -1,  -1,  31,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  32,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  33,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  33,  33,  -1,  -1,  33,  -1,  -1,  -1,  33,  -1,  -1,  -1,  -1,  33,  33,  -1,  -1,  -1,  -1,  33,  33,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  33,  -1 },
        {  -1,  34,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  35,  35,  -1,  -1,  35,  -1,  -1,  -1,  35,  -1,  -1,  -1,  -1,  34,  35,  -1,  -1,  -1,  -1,  34,  34,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  34,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  36,  36,  -1,  -1,  36,  -1,  -1,  -1,  36,  -1,  -1,  -1,  -1,  -1,  36,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  37,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  38,  38,  -1,  -1,  38,  -1,  -1,  -1,  38,  -1,  -1,  -1,  -1,  37,  38,  -1,  -1,  -1,  -1,  37,  37,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  37,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  39,  39,  -1,  -1,  39,  -1,  -1,  -1,  39,  -1,  -1,  -1,  -1,  -1,  39,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  40,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  40,  -1,  -1,  -1,  -1,  -1,  40,  40,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  40,  -1 },
        {  -1,  41,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  42,  -1,  -1,  -1,  42,  -1,  -1,  -1,  -1,  -1,  -1,  41,  -1,  -1,  -1,  -1,  -1,  41,  41,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  41,  -1 },
        {  -1,  43,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  44,  -1,  -1,  -1,  -1,  -1,  45,  46,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  47,  -1 },
        {  -1,  55,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  57,  58,  -1,  56 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  60,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  61,  61,  61,  61,  61,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  61,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  61,  -1,  -1,  -1,  61,  -1,  -1,  -1,  -1,  61,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  61,  61,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  62,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  63,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  50,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  52,  -1,  -1,  -1,  51,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  54,  53,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  64,  -1 },
        {  -1,  82,  82,  82,  82,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  82,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  85,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  85,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  85,  85,  85,  85,  85,  85,  85,  83,  84,  -1,  -1,  85,  85,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  75,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  75,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  75,  74,  74,  74,  74,  74,  74,  -1,  -1,  -1,  -1,  75,  75,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  76,  77,  78,  79,  80,  81,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  65,  65,  65,  65,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  65,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  66,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  67,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  68,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  68,  68,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  59,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  69,  69,  69,  69,  69,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  71,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  72,  -1,  -1,  -1,  70,  -1,  -1,  -1,  -1,  69,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  69,  69,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  73,  73,  73,  73,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  73,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  48,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  49,  49,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  86,  86,  86,  86,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  86,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  90,  91,  92,  94,  93,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  95,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  96,  97,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  98,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  98,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  99,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  98,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1, 101, 101, 101, 101, 101,  -1,  -1,  -1,  -1,  -1,  -1,  -1, 101,  -1,  -1,  -1,  -1,  -1,  -1,  -1, 101,  -1,  -1,  -1, 101,  -1,  -1,  -1,  -1, 101, 100,  -1,  -1,  -1,  -1,  -1,  -1, 101, 101,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  89,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  89,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  89,  89,  89,  89,  89,  89,  89,  89,  89,  87,  88,  89,  89,  -1,  -1,  -1,  -1,  -1,  -1,  -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 116,  20,  53,  56, 117,  10,  69,  13, 118 },
        {  54 },
        {   0 },
        {  59,  55 },
        {   0 },
        {  59,  55 },
        {  57 },
        {   0 },
        {   0 },
        {  57 },
        {  68,  58 },
        {  16,  21,  60,   2,  31,  62,  32 },
        {  19 },
        {  15 },
        {  11 },
        {  12 },
        {  25 },
        {  27 },
        {  19 },
        {  15 },
        {  11 },
        {  12 },
        {  25 },
        {   0 },
        {  63 },
        {  67,  64 },
        {   0 },
        {  45,  63 },
        {   2, 133,  66 },
        {   0 },
        {  43,  65 },
        {  61,  46,  65, 132 },
        {  21,   2,  10,  69,  13 },
        {  70,  74 },
        {   0 },
        {  71 },
        {  73,  72 },
        {   0 },
        {  71 },
        {  61, 131,  46,  65,  44, 132 },
        {  76,  44,  75 },
        {  74 },
        {   0 },
        {  77 },
        {  92 },
        {  79 },
        {  31,  90,  32,  95 },
        {  85 },
        {  82 },
        {  84 },
        {  18,  74,  83,  13 },
        {  17,  74 },
        {   0 },
        {  29,  74,  13 },
        {  28,  74,  13 },
        {   2, 133,  78,  90, 135 },
        {  51 },
        {  48 },
        {  49 },
        {  24,  31,  65, 136,  32 },
        {  30,  31,  80,  32 },
        {  90, 115,  81 },
        {   0 },
        {  43,  80 },
        {  50,  90 },
        {  93,  91 },
        {   9,  93, 119,  91 },
        {  23,  93, 120,  91 },
        {   0 },
        {  94 },
        {  26, 112 },
        {  14, 113 },
        {  22,  93, 114 },
        {  86,  88 },
        {  89, 110,  86, 111 },
        {   0 },
        {  33 },
        {  34 },
        {  35 },
        {  36 },
        {  37 },
        {  38 },
        {  96,  87 },
        {  39,  96, 102,  87 },
        {  40,  96, 103,  87 },
        {   0 },
        {  97, 100 },
        {  41,  97, 104, 100 },
        {  42,  97, 105, 100 },
        {   0 },
        {   2,  98 },
        {   3, 106 },
        {   4, 107 },
        {   6, 121 },
        {   5, 122 },
        {  31,  90,  32 },
        {  39,  97, 108 },
        {  40,  97, 109 },
        { 134 },
        {  31,  99 },
        {  32 },
        {  80,  32 }
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
        "Era esperado comentario_linha",
        "Era esperado comentario_bloco",
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
        "Era esperado \":=\"",
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
