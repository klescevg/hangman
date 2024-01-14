package com.klescevg.hangman;

import java.util.Scanner;

public class HangmanGame {
    private Messages messages;
    private Dictionary dictionary;

    public HangmanGame(Messages messages) {
        this.messages = messages;
        dictionary = new Dictionary();
    }

    public void startGame() {
        System.out.println(messages.getStartGameMessage());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                //start game function

                break;
            } else if (answer.equals("0")) {
                System.out.println(messages.getByeByeMessage());
                break;
            } else {
                System.out.println(messages.getWrongInputMessage());
            }
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
