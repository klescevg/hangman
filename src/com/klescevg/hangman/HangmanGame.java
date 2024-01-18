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
        while (mistakeCount < MAX_MISTAKES){

        }
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
