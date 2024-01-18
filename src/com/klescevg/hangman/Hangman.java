package com.klescevg.hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String language = selectLanguage();
        Messages messages = new Messages(language);
        HangmanGame hangmanGame = new HangmanGame(messages);

        hangmanGame.startGame();
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
}