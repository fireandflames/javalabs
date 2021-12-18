package com.company;

import com.company.textdecomposer.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

public class Main {

    public final static String consonants = "qwrtplkjhgfdszxcvbnm";

    public static String deleteWordsWithConsonant(Listing listing, int length) {
        StringBuilder result = new StringBuilder();
        for (Paragraph paragraph : listing.paragraphs) {
            for (Sentence sentence : paragraph.sentences) {
                for (Lexeme lexeme : sentence.lexemes) {

                    char start = lexeme.word.toLowerCase().charAt(0);
                    if (consonants.indexOf(start) != -1 || consonants.toUpperCase().indexOf(start) != -1) {
                        if (lexeme.word.length() == length) {
                            if (!lexeme.hasSings) {
                                continue;
                            }
                            result.append(lexeme.sign);
                            continue;
                        }
                    }
                    result.append(lexeme);
                    }
                }
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) throws NullPointerException, MyException {

        String text = "";
        try {
            text = new String(readAllBytes(Paths.get("src/text.txt")));
        } catch (IOException e) {
            System.out.println("No input file found!");
        }
        if (text.equals(""))
            throw new MyException("Text is empty!");
        Listing listing = new Listing(text);
        PrintWriter writer;
        try {
            writer = new PrintWriter("src/output.txt");
            writer.println("Input text:");
            writer.println();
            writer.println(listing);
            writer.println("Text without words starting on consonants:");
            writer.println();
            writer.println(deleteWordsWithConsonant(listing,5));
            writer.close();
        } catch (NullPointerException | IOException e) {
            System.out.println("Error while writing your result!");
        }

    }
}
