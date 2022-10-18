package com.javarush;

public class CezarCypher {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,\":-!? ()1234567890";




    public static String encode(String text, int key) {
        StringBuilder result = new StringBuilder();

        char [] charsInput = text.toCharArray();
        for (char c : charsInput) {

            int indexOfText = ALPHABET.indexOf(c);
            int lengthOfAbc = ALPHABET.length();
            int newIndex = ((indexOfText + key % lengthOfAbc) + lengthOfAbc) % lengthOfAbc;
            result.append(ALPHABET.charAt(newIndex));
        }
        return result.toString();
    }

    public static String decode(String text, int key) {
        key = -key;
        return encode(text, key);
    }

}
