package linter;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Linter {
    // open curly brace
    private static final String OPEN_CURLY = "{";
    // close curly brace
    private static final String CLOSE_CURLY = "}";
    //if
    private static final String IF = "if";
    //else
    private static final String ELSE = "else";
    //semicolon
    private static final String SEMICOLON = ";";


    /**
     * Function to lint JS file
     * @param jsFile path of the file
     * @return list of errors
     */
    public static List<String> linterJS(String jsFile){
        //error list
        List<String> errors = new ArrayList<>();
        //error line number
        int lineNumber = 1;

        try {
            Scanner sc = new Scanner(new File(jsFile));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                // Check exceptions and if it line has no semicolon
                if((!existExceptions(line)) && !(line.endsWith(SEMICOLON))){
                    errors.add(String.format("Line %d: Missing semicolon.", lineNumber));
                }

                lineNumber += 1;

            }

            return errors;

        } catch(FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e);
            return null;
        }

    }


    //Helper to check rule exceptions
    private static boolean existExceptions(String currentLine){
        return currentLine.isEmpty() || currentLine.endsWith(OPEN_CURLY) || currentLine.endsWith(CLOSE_CURLY)
                || currentLine.contains(IF) || currentLine.contains(ELSE);
    }
}
