package com.biotech.process;

import java.util.Scanner;

public class ConsoleFile {
    private Scanner scanner;
    private String message;
    private String defaultFile;

    public ConsoleFile(Scanner scanner, String message, String defaultFile) {
        this.scanner = scanner;
        this.message = message;
        this.defaultFile = defaultFile;
    }

    public String getFileName(){
        String fileName;
        System.out.println(message);
        if (!(defaultFile == null || defaultFile.isEmpty() || defaultFile.trim().isEmpty())){
            System.out.println("Laissez vide pour utiliser le fichier par défaut (" + defaultFile + ") : ");}
        fileName = scanner.nextLine();
        if (fileName.isEmpty()) {
            // default file path
            fileName = defaultFile;
        }
        return fileName;
    }
}
