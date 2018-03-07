package ru.itis.dictionary;


import ru.itis.FunOutput;
import ru.itis.lists.DictionaryLinkedList;

import java.util.Scanner;
import java.util.Set;

public class Dictionary {
    protected String filename;
    protected DictionaryLinkedList dictionary;
    protected int deletionResult;

    public Dictionary (String filename) {
        this.filename = filename;
        dictionary = new DictionaryLinkedList();
        dictionary.addAllFromFile(filename);
    }

    public Dictionary() {
        dictionary = new DictionaryLinkedList();
    }

    public void show0() {
        System.out.println("Файл словаря: " + filename);
        for (String[] strings: dictionary) {
            System.out.println(strings[0] + " = " + strings[1]);
        }
    }

    public void show() {
        System.out.println();
        FunOutput.rainbowOut("***Вывод словаря***");
        FunOutput.rainbowOut("Файл словаря: " + filename);
        for (String[] strings: dictionary) {
            FunOutput.rainbowOut(strings[0] + " = " + strings[1]);
        }
        System.out.println();
    }

    public void insert(String word, String translation) {
        String[] strings = {word, translation};
        if (dictionary.indexOf(strings) == -1) {
            dictionary.add(strings);
            dictionary.addToFile(filename, "\n" + word + " " + translation);
        }
    }

    private void insert(String[] strings) {
        dictionary.add(strings);
    }

    public void delete(String word) {
        this.deletionResult = dictionary.indexOf(word);
        dictionary.removeByIndex(dictionary.indexOf(word));
    }

    public Dictionary unique() {
        Dictionary unique = new Dictionary();
        for (String[] strings : this.dictionary) {
            unique.insert(strings);
        }
        unique.deletionResult = 0;
        for (String[] strings : unique.dictionary) {
            int currentWordCount = 0;
            while (unique.deletionResult != -1) {
                unique.delete(strings[0]);
                currentWordCount++;
            }
            if (currentWordCount == 1) unique.insert(strings);
        }
        return unique;
    }

    public int numLen1() {
        int numLen1Counter = 0;
        for (String[] currentPair : dictionary) {
            if (Math.abs(currentPair[0].length() - currentPair[1].length()) <= 1) numLen1Counter++;
        }
        return numLen1Counter;
    }

    public String translate(String text) {
        String[] textToTranslate = text.split(" ");
        StringBuilder out = new StringBuilder();
        for (String currentWord : textToTranslate) {

            try {
                out.append(dictionary.get(dictionary.indexOf(currentWord))[1] + " ");
            } catch (NullPointerException ex) {
                out.append("***** ");
                dictionary.addToFile("NotFoundWords", currentWord + " ");
            }
        }
        return out.toString();
    }

    public void addWords(int wordCount) {
        for (int i = 0; i < wordCount; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input word: ");
            String word = scanner.nextLine();
            System.out.println("Input translation: ");
            String translation = scanner.nextLine();
            this.insert(word, translation);
        }
    }
}
