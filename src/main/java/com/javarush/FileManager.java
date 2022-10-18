package com.javarush;

import java.io.*;

public class FileManager {

    static String textFile = "";

    public static void encryptFile() throws IOException {

        readFromFile(DataReceiver.getPath());

        String encryptedFile = CezarCypher.encode(textFile, DataReceiver.getKey());

        writeNewFile(DataReceiver.getNewPath(), encryptedFile);
    }
    public static void decryptFile() throws IOException {

        readFromFile(DataReceiver.getPath());

        String decryptedFile = CezarCypher.decode(textFile, DataReceiver.getKey());

        writeNewFile(DataReceiver.getNewPath(), decryptedFile);
    }


    private static void readFromFile(String pathToFile) throws IOException {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
            textFile = bufferedReader.readLine();

        } catch (RuntimeException e){
            System.err.println("Error occurred!");
        }

    }
    public  static void writeNewFile(String path, String text)throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(text);
        fileWriter.close();

    }

}
