package ru.itis.lists;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryLinkedList extends LinkedList<String[]> {

    public void addAllFromFile(String filename) {
        try {
            Scanner reader = new Scanner(new FileReader(filename));
            while (reader.hasNextLine()) {
                String[] newNode = reader.nextLine().split(" ");
                this.add(newNode);
            }
            reader.close();
            System.out.println("\u001B[34m" + "Словарь создан" + "\u001B[0m");
        } catch (FileNotFoundException ex) {
            System.out.println("\u001B[1;32m" + "Ошибка: Файл не найден" + "\u001B[0m");
        }

    }


    public int indexOf(String word) {
        int index = 0;
        if (head == null) return -1;
        Node currentNode = super.head;
        while (currentNode.next != null) {
            if (currentNode.value[0].equals(word)) return index;
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode.value[0].equals(word)) return index;
        return -1;
    }

    @Override
    public int indexOf(String[] element) {
        int index = 0;
        if (head == null) return -1;
        Node currentNode = super.head;
        while (currentNode.next != null) {
            if (currentNode.value[0].equals(element[0]) && currentNode.value[1].equals(element[1])) return index;
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode.value[0].equals(element[0]) && currentNode.value[1].equals(element[1])) return index;
        return -1;
    }

    public void addToFile(String filename, String toWrite) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(toWrite);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("\u001B[32mФайл пропал(((\u001B[0m");
        }
    }
}
