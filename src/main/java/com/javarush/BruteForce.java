package com.javarush;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce {

    public static final String ABC = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,\":-!? ()1234567890";


    static String[] array = new String[ABC.length()];
    public static void decryptBruteForce(String s){
        for (int i = 0; i < ABC.length(); i++) {
            array[i] = EncryptDecryptMethod.decodeMethod(s, i);
        }
        System.out.println(Arrays.toString(array));

    }
    public static boolean checkPassword(String str){


        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(str)){
                System.out.println(array[i]);
            }
        }
        return true;
    }


}
