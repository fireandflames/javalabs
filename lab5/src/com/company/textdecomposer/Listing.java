package com.company.textdecomposer;

import java.util.ArrayList;

public class Listing {

    public ArrayList<Paragraph> paragraphs = new ArrayList<>();

    public Listing(String text) {
        String[] listingSplit = text.split(System.lineSeparator());
        for (String s : listingSplit) {
            Paragraph paragraph = new Paragraph(s);
            paragraphs.add(paragraph);
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Paragraph p : paragraphs) {
            str.append(p.toString()).append("\n");
        }
        return str.toString();
    }
}
