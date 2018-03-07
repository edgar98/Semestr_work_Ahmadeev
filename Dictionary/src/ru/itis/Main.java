package ru.itis;

import ru.itis.dictionary.Dictionary;

public class Main {

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary("dictionary.txt");
        FunOutput.rainbowOut(dictionary.translate("привет"));
        FunOutput.rainbowOut(dictionary.translate("я привет"));
        dictionary.insert("я", "I");
        FunOutput.rainbowOut(dictionary.translate("я привет"));
        dictionary.show();
        dictionary.delete("я");
        dictionary.show();
        dictionary.unique().show();

        FunOutput.rainbowOut("Количество переводов (разница длин <= 1) = " + dictionary.numLen1());
    }
}
