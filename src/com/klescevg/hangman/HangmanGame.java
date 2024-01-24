package com.klescevg.hangman;

import java.util.Scanner;

public class HangmanGame {
    private Messages messages;
    private Dictionary dictionary;
    private Word word;
    private int mistakeCount;
    private char[] wrongLetters;
    private final int MAX_MISTAKES = 6;

    public HangmanGame(Messages messages) {
        this.messages = messages;
        dictionary = new Dictionary();
        word = new Word();
        mistakeCount = 0;
        wrongLetters = new char[MAX_MISTAKES];
    }

    public void startGame() {
        System.out.println(messages.getStartGameMessage());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                initDictionary();
                word.setWord(dictionary.getRandomWord());
                playGame();

                System.out.println(messages.getStartGameMessage());
            } else if (answer.equals("0")) {
                System.out.println(messages.getByeByeMessage());
                break;
            } else {
                System.out.println(messages.getWrongInputMessage());
            }
        }
    }

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        while (mistakeCount < MAX_MISTAKES){
            printGallows();
            System.out.print(messages.getWordMessage());
            word.printRevealedLetters();

            System.out.print(messages.getMistakesMessage() + " (" + mistakeCount + "): ");
            printWrongLetters();


            //checkPresence()
            mistakeCount++;
        }
    }

    public char readLetter(){
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(true) {
            System.out.print(messages.getLetterMessage());
            input = scanner.nextLine();

            if (input.length() == 1){
                break;
            }

            System.out.println(messages.getLetterWarningMessage());
        }

        return input.charAt(0);
    }

    public void printWrongLetters(){
        for (int i = 0; i < mistakeCount; i++) {
            System.out.print(wrongLetters[i]);
            if (i < mistakeCount-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void printGallows(){
        System.out.println("   _________");
        System.out.println("   |       |");
        switch(mistakeCount){
            case 0:
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                break;
            case 1:
                System.out.println("   |       O");
                System.out.println("   |");
                System.out.println("   |");
                break;
            case 2:
                System.out.println("   |       O");
                System.out.println("   |       |");
                System.out.println("   |");
                break;
            case 3:
                System.out.println("   |       O");
                System.out.println("   |      /|");
                System.out.println("   |");
                break;
            case 4:
                System.out.println("   |       O");
                System.out.println("   |      /|\\");
                System.out.println("   |");
                break;
            case 5:
                System.out.println("   |       O");
                System.out.println("   |      /|\\");
                System.out.println("   |      /");
                break;
            case 6:
                System.out.println("   |       O");
                System.out.println("   |      /|\\");
                System.out.println("   |      / \\");
                break;
        }
        System.out.println("___|___");
    }

    public void initDictionary() {
        String fileName;

        if (messages.getLanguage().equals("english")) {
            fileName = "english_nouns.txt";
        } else {
            fileName = "russian_nouns.txt";
        }

        dictionary.loadDictionary(fileName);
    }
}
