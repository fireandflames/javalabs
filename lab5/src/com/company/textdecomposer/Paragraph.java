package com.company.textdecomposer;

import java.util.ArrayList;

public class Paragraph {
    public ArrayList<Sentence> sentences = new ArrayList<>();

    Paragraph(String stringParagraph) {
        String[] paragraphSplit = stringParagraph.split("((?<=[!.?]))");
        for (String s : paragraphSplit) {

            Sentence sentence = new Sentence(s);
            sentences.add(sentence);

        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Sentence s : sentences) {
            str.append(s.toString());
        }
        return str.toString();
    }
}
