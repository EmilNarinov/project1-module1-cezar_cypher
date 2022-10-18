package com.javarush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BruteForceDecoder {

    static String [] wordsOriginal;
    static String [] wordsEncoded;
    static char[] letterOriginal;
    static char[] letterEncoded;
    public static void bruteforceDecryptText(String origin, String encrypt){
        wordsOriginal = origin.split(" ");
        wordsEncoded  = encrypt.split(" ");

        letterOriginal = wordsOriginal[0].toCharArray();
        letterEncoded = wordsEncoded[0].toCharArray();

        int indexOriginal = CezarCypher.ALPHABET.indexOf(letterOriginal[0]);
        int indexEncoded = CezarCypher.ALPHABET.indexOf(letterEncoded[0]);

        int delta = (indexEncoded - indexOriginal) % CezarCypher.ALPHABET.length();

        System.out.println(CezarCypher.decode(encrypt, delta));
    }

    public static void bruteforceDecryptFile () throws IOException {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DataReceiver.getPathToOriginal()));
            String textOriginal = bufferedReader.readLine();
            int indexOriginal = getIndexOriginal(textOriginal);

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(DataReceiver.getPathToEncodedFile()));
            String textEncoded = bufferedReader1.readLine();
            int indexEncoded = getIndexEncoded(textEncoded);

            int delta = (indexEncoded - indexOriginal) % CezarCypher.ALPHABET.length();

            String decryptedText = CezarCypher.decode(textEncoded, delta);

            FileWriter fileWriter = new FileWriter(DataReceiver.getNewPath());
            fileWriter.write(decryptedText);
            fileWriter.close();

        } catch (RuntimeException e){
            System.err.println("Error occurred!");
        }
    }

    private static int getIndexEncoded(String textEncoded) {
        wordsEncoded = textEncoded.split(" ");
        letterEncoded = wordsEncoded[0].toCharArray();
        return CezarCypher.ALPHABET.indexOf(letterEncoded[0]);
    }

    private static int getIndexOriginal(String textOriginal) {
        wordsOriginal = textOriginal.split(" ");
        letterOriginal = wordsOriginal[0].toCharArray();
        return CezarCypher.ALPHABET.indexOf(letterOriginal[0]);
    }

}
