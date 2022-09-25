package com.javarush;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileEncrypt {
    static String encryptedFileText = "";

    public static String readAndEncrypt(String pathToFile, int delta) throws IOException {
        File file = new File(pathToFile);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        if (Files.notExists(Path.of(pathToFile))) {
            System.err.println("The path is not valid!");
        } else {
            String s = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((s = bufferedReader.readLine()) != null) {
                String[] strings = s.split("\\s+");
                for (String s1 : strings) {
                    stringBuilder.append(s1 + " ");
                }
                encryptedFileText = EncryptDecryptMethod.encodeMethod(stringBuilder.toString(), delta);
            }
        }

        return encryptedFileText;
    }

    public  static void writeNewFile(String pathToNewFile, String newFileText)throws IOException {
        File file = new File(pathToNewFile);
        FileWriter fileWriter = new FileWriter(file);

        String[] strings = newFileText.split("\\s+");
        for (String str : strings) {
            fileWriter.write(str + " ");
        }
        fileWriter.close();
    }
}
