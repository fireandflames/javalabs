package com.company.textdecomposer;

public class Lexeme {
    public String word;
    public String sign;
    public Boolean hasSings;

    Lexeme(String stringLexeme) {

        if (stringLexeme.contains("!") || stringLexeme.contains("?") || stringLexeme.contains(",") || stringLexeme.contains(".")) {
            word = stringLexeme.substring(0, stringLexeme.length() - 1);
            sign = stringLexeme.substring(stringLexeme.length() - 1);
            hasSings = true;
        } else {word = stringLexeme;
        sign = " ";
        hasSings = false;}
    }

    @Override
    public String toString() {
        return word + sign;
    }
}
