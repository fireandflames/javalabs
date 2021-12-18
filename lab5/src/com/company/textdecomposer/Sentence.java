package com.company.textdecomposer;

import java.util.ArrayList;

public class Sentence {
    public ArrayList<Lexeme> lexemes = new ArrayList<>();

    Sentence(String stringSentence) {
        String[] sentenceSplit = stringSentence.split("[ ]");
        for (String s : sentenceSplit) {
            if (s.equals("") || s.equals("\t")) {
                continue;
            }
            Lexeme lexeme = new Lexeme(s);
            lexemes.add(lexeme);
        }
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Lexeme l : lexemes) {
            str.append(l.toString());
        }
        return str.toString();
    }
}
