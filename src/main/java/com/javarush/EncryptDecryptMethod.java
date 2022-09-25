package com.javarush;

import java.util.Scanner;

public class EncryptDecryptMethod {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,\":-!? ()";


    public static void main(String[] args) {

        String input = "smells like teen spirit";
        String output = "EyqxxEиxuwqиFqqzиEBuDuF";

        System.out.println(encodeMethod(input, 12));
        System.out.println(decodeMethod(output, 12));


    }

    public static String encodeMethod(String text, int key) {
        String result = "";

        char [] charsInput = text.toCharArray();
        for (int i = 0; i < charsInput.length; i++) {

            int indexOfText = ALPHABET.indexOf(charsInput[i]);
            int lengthOfAbc = ALPHABET.length();
            int newIndex = ((indexOfText + key % lengthOfAbc) + lengthOfAbc) % lengthOfAbc;
            result = result + ALPHABET.charAt(newIndex);

        }

        return result;
    }

    public static String decodeMethod(String text, int key) {
        key = -key;
        return encodeMethod(text, key);
    }

}
