package com.javarush;

import java.util.Scanner;

public class DataReceiver {
    static Scanner scanner = new Scanner(System.in);
    public static String getPath(){
        System.out.println("Enter a path to file:");
        return scanner.nextLine();
    }
    public static String getNewPath(){
        System.out.println("Please put a new path to create a file");
        return scanner.nextLine();
    }
    public static int getKey(){
        System.out.println("Enter the key, please");
        return Integer.parseInt(scanner.nextLine());
    }
    public static String getText(){
        System.out.println("Enter a text:");
        return scanner.nextLine();
    }
    public static String getOriginalText(){
        System.out.println("Please, input an ORIGINAL TEXT to match");
        return scanner.nextLine();
    }
    public static String getEncryptedText(){
        System.out.println("Please, input an ENCRYPTED TEXT to decrypt");
        return scanner.nextLine();
    }
    public static String getPathToOriginal(){
        System.out.println("Enter a path to file with ORIGINAL TEXT to match:");
        return scanner.nextLine();
    }
    public static String getPathToEncodedFile(){
        System.out.println("Enter a path to encoded file:");
        return scanner.nextLine();
    }

}
