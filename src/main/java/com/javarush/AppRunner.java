package com.javarush;

import java.io.IOException;
import java.util.Scanner;



public class AppRunner {

    static String selectOption;
    static String errorOption = "Your answer is incorrect!";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose: \n   (T)ext \n   (F)ile \n   (B)rute Force Decoding");
            selectOption = scanner.nextLine();
            if (selectOption.equalsIgnoreCase("T")) {

                System.out.println("Choose: (E)ncrypt text or (D)ecrypt text");
                selectOption = scanner.nextLine();

                ifTextOption();

                break;

            } else if (selectOption.equalsIgnoreCase("F")) {
                System.out.println("Choose: (E)ncrypt file or (D)ecrypt file");
                selectOption = scanner.nextLine();

                ifFileOption();

                break;

            } else if (selectOption.equalsIgnoreCase("B")) {
                System.out.println("Choose: (T)ext or (F)ile");
                selectOption = scanner.nextLine();
                if (selectOption.equalsIgnoreCase("T")){
                    BruteForceDecoder.bruteforceDecryptText(DataReceiver.getOriginalText(), DataReceiver.getEncryptedText());
                    break;
                } else if (selectOption.equalsIgnoreCase("F")) {
                    BruteForceDecoder.bruteforceDecryptFile();
                    break;
                }else {
                    System.err.println(errorOption);
                    break;
                }

            } else {
                System.err.println(errorOption);
                break;
            }
        }
    }

    private static void ifFileOption() throws IOException {
        if (selectOption.equalsIgnoreCase("E")){
            FileManager.encryptFile();
        } else if (selectOption.equalsIgnoreCase("D")) {
            FileManager.decryptFile();
        }else {
            System.out.println(errorOption);
        }
    }

    private static void ifTextOption() {
        if (selectOption.equalsIgnoreCase("E")){
            System.out.println(CezarCypher.encode(DataReceiver.getText(), DataReceiver.getKey()));
        } else if (selectOption.equalsIgnoreCase("D")) {
            System.out.println(CezarCypher.decode(DataReceiver.getText(), DataReceiver.getKey()));
        }else {
            System.err.println(errorOption);
        }
    }

}
