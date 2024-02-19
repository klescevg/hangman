package com.klescevg.hangman;

import java.util.Scanner;

public class Hangman {
    private static final String ENGLISH_OPTION = "e";
    private static final String RUSSIAN_OPTION = "r";

    public static void main(String[] args) {
        Language language = selectLanguage();
        MessageManager messageManager = new MessageManager(language);
        HangmanGame hangmanGame = new HangmanGame(messageManager);

        hangmanGame.initGame();
    }

    public static Language selectLanguage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman game. Choose a language (type e for english or r for russian).");

        while(true) {
            String language = scanner.nextLine();
            if (language.equals(ENGLISH_OPTION) || language.equals(RUSSIAN_OPTION)) {
                return (language.equals(ENGLISH_OPTION)) ? Language.ENGLISH : Language.RUSSIAN;
            } else {
                System.out.println("Wrong input, try again!");
            }
        }
    }
}