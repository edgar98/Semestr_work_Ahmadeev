package ru.itis;

import java.util.Random;

public class FunOutput {
    private static boolean sad = true, random = true;

    public static String[] colours = {"\u001B[31m", "\u001B[33m", "\u001B[32m", "\u001B[36m", "\u001B[34m", "\u001B[35m"};
    public static String reset = "\u001B[0m";

    public static void rainbowOut(String toPrint) {
        if (sad) {
            System.out.println(toPrint);
        } else if (random) randOut(toPrint);
        else out(toPrint);
    }

    private static void out(String toPrint) {
        for (int i = 0, j = 0; i < toPrint.length(); i++, j++) {
            System.out.print(colours[j] + toPrint.charAt(i));
            if (j == colours.length - 1) j = -1;
        }
        System.out.println(reset);
    }

    private static void randOut(String toPrint) {
        Random random = new Random();
        for (int i = 0; i < toPrint.length(); i++) {
            System.out.print(colours[random.nextInt(6)] + toPrint.charAt(i));
        }
        System.out.println(reset);
    }
}
