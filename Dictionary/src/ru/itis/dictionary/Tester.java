package ru.itis.dictionary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tester {
    private Dictionary dictionary;

    @Before
    public void setUp(){
        dictionary = new Dictionary("./src/testDicts/testNumLen1");
    }

    @Test
    public void test(){
        String[] strings = {"словарь","dictionary"};
        dictionary.insert(strings[0],strings[1]);
        assertTrue(dictionary.dictionary.indexOf(strings) != -1);
    }

    @Test
    public void uniqueTest() {
        Dictionary unique = dictionary.unique();
        int firstSize = dictionary.dictionary.size();
        int secondSize = unique.dictionary.size();
        assertTrue(dictionary.dictionary.size() >= unique.dictionary.size());
    }

    @Test
    public void translateTest1() {
        assertTrue(dictionary.translate("я").equals("I "));
    }

    @Test
    public void translateTest2() {
        assertTrue(dictionary.translate("словарь").equals("dictionary "));
    }

    @Test
    public void translateTest3() {
        assertTrue(dictionary.translate("привет").equals("hello "));
    }

    @Test
    public void numLen1Test() {
        assertTrue(dictionary.numLen1() == 3);
    }

    @Test
    public void deleteTest() {
        dictionary.delete("я");
        assertTrue(dictionary.deletionResult != -1);
    }
}
