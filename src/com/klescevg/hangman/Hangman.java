package com.klescevg.hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String language = selectLanguage();




    }

    public static String selectLanguage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman game. Choose a language (type e for english or r for russian).");
        while(true) {
            String language = scanner.nextLine();
            if (language.equals("e") || language.equals("r")) {
                return (language.equals("e")) ? "english" : "russian";
            } else {
                System.out.println("Wrong input, try again!");
            }
        }
    }

    public static void startGame(String language, Scanner scanner){
        if (language.equals("e")){
            System.out.println("Hi! Do you want to start a new game? (type y for yes or n for no)");
            while (true) {
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    //start game function
                } else if (answer.equals("n")) {
                    break;
                }else{
                    System.out.println("Wrong input, try again!");
                }
            }
        }
    }
}