package com.javarush;

import java.io.IOException;
import java.util.Scanner;

import static com.javarush.FileEncrypt.encryptedFileText;
import static com.javarush.FileDecrypt.decryptedFileText;

public class CypherCoding {



    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Choose the options: \n   (T)ext \n   (F)ile \n   (P)assword");
            String mainOption = scanner.nextLine();
            if (mainOption.equalsIgnoreCase("T")) {
                System.out.println("Press 1 to encrypt text 2 to decrypt text");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Enter the text to encrypt:");
                    String textEncrypt = scanner.nextLine();
                    textEncrypt = scanner.nextLine();
                    System.out.println("Enter the key:");
                    int key = scanner.nextInt();
                    System.out.println(EncryptDecryptMethod.encodeMethod(textEncrypt, key));
                    break;
                } else if (option == 2) {
                    System.out.println("Enter the text to decrypt:");
                    String textDecrypt = scanner.nextLine();
                    textDecrypt = scanner.nextLine();
                    System.out.println("Enter the key:");
                    int key = scanner.nextInt();
                    System.out.println(EncryptDecryptMethod.decodeMethod(textDecrypt, key));
                    break;
                } else {
                    System.err.println("Answer is incorrect");
                    break;
                }
            } else if (mainOption.equalsIgnoreCase("F")) {
                System.out.println("Press: \n[1 to encrypt file] \n[2 to decrypt file]");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Enter the path to encrypt file:");
                    String path = scanner.nextLine();
                    path = scanner.nextLine();
                    System.out.println("Enter the key:");
                    int key = scanner.nextInt();
                    FileEncrypt.readAndEncrypt(path, key);
                    System.out.println("Enter the new path to encrypted file:");
                    String newPath = scanner.nextLine();
                    newPath = scanner.nextLine();
                    FileEncrypt.writeNewFile(newPath, encryptedFileText);
                    break;
                } else if (option == 2) {
                    System.out.println("Enter the path to decrypt file:");
                    String pathToFile = scanner.nextLine();
                    pathToFile = scanner.nextLine();
                    System.out.println("Enter the key:");
                    int key = scanner.nextInt();
                    FileDecrypt.readAndDecrypt(pathToFile, key);
                    System.out.println("Enter the new path to decrypted file:");
                    String newPath = scanner.nextLine();
                    newPath = scanner.nextLine();
                    FileDecrypt.writeNewFile(newPath, decryptedFileText);
                    break;
                } else {
                    System.err.println("Answer is incorrect");
                    break;
                }
            } else if (mainOption.equalsIgnoreCase("P")) {
                System.out.println("Enter the encrypted password:");
                String s = scanner.nextLine();
                System.out.println("The following matches: \n");
                BruteForce.decryptBruteForce(s);
                System.out.println("Would you like to compare to the password sample? \n (Y)es / (N)o");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("Enter the sample of the password:");
                    String pass = scanner.nextLine();
                    BruteForce.checkPassword(pass);
                } else if (answer.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.err.println("Answer is incorrect");
                    break;
                }
            }
        }
    }
}
