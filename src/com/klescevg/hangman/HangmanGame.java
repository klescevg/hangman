package com.klescevg.hangman;

import java.util.Scanner;

public class HangmanGame {
    private Scanner scanner;
    private Messages messages;
    private Dictionary dictionary;
    private Word word;
    private int mistakeCount;
    private char[] wrongLetters;
    private final int MAX_MISTAKES = 6;

    public HangmanGame(Messages messages) {
        scanner = new Scanner(System.in);
        this.messages = messages;
        dictionary = new Dictionary();
        word = new Word();
        mistakeCount = 0;
        wrongLetters = new char[MAX_MISTAKES];
    }

    public void startGame() {
        System.out.println(messages.getStartGameMessage());
        initDictionary();
        do {
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                word.setWord(dictionary.getRandomWord());
                playGame();

                System.out.println(messages.getStartGameMessage());
            } else if (answer.equals("0")) {
                System.out.println(messages.getByeByeMessage());
                break;
            } else {
                System.out.println(messages.getWrongInputMessage());
            }
        } while (true);
    }

    public void playGame() {
        while (mistakeCount < MAX_MISTAKES) {
            printGameState();
            char letter = readLetter();
            checkLetter(letter);
            checkWin();
        }

        mistakeCount = 0;
    }

    private void printGameState() {
        printGallows();
        System.out.print(messages.getWordMessage());
        word.printRevealedLetters();

        System.out.print(messages.getMistakesMessage() + " (" + mistakeCount + "): ");
        printWrongLetters();
    }

    public void checkWin() {
        System.out.println();
        if (mistakeCount == MAX_MISTAKES) {
            System.out.println(messages.getLossMessage());
        } else if (word.checkIfHiddenWordIsRevealed()) {
            System.out.println(messages.getWinMessage());
            mistakeCount = MAX_MISTAKES;
        }
    }

    public void checkLetter(char letter) {
        if (word.checkPresence(letter)) {
            word.addRevealedLetter(letter);
        } else {
            wrongLetters[mistakeCount] = letter;
            mistakeCount++;
        }
    }

    public char readLetter() {
        String input = "";

        while (true) {
            System.out.print(messages.getLetterMessage());
            input = scanner.nextLine();

            if (input.length() != 1 || !Character.isLowerCase(input.charAt(0))) {
                System.out.println(messages.getLetterWarningMessage());
                continue;
            } else if (checkIfLetterIsAlreadyWrong(input.charAt(0)) || word.checkIfLetterIsAlreadyRevealed(input.charAt(0))) {
                System.out.println(messages.getAlreadyEnteredLetterMessage());
                continue;
            }

            break;
        }

        return input.charAt(0);
    }

    public boolean checkIfLetterIsAlreadyWrong(char letter) {
        for (char wrongLetter : wrongLetters) {
            if (wrongLetter == letter) {
                return true;
            }
        }
        return false;
    }

    public void printWrongLetters() {
        for (int i = 0; i < mistakeCount; i++) {
            System.out.print(wrongLetters[i]);
            if (i < mistakeCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void printGallows() {
        System.out.println("   _________");
        System.out.println("   |       |");
        switch (mistakeCount) {
            case 0 -> {
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
            }
            case 1 -> {
                System.out.println("   |       O");
                System.out.println("   |");
                System.out.println("   |");
            }
            case 2 -> {
                System.out.println("   |       O");
                System.out.println("   |       |");
                System.out.println("   |");
            }
            case 3 -> {
                System.out.println("   |       O");
                System.out.println("   |      /|");
                System.out.println("   |");
            }
            case 4 -> {
                System.out.println("   |       O");
                System.out.println("   |      /|\\");
                System.out.println("   |");
            }
            case 5 -> {
                System.out.println("   |       O");
                System.out.println("   |      /|\\");
                System.out.println("   |      /");
            }
            case 6 -> {
                System.out.println("   |       O");
                System.out.println("   |      /|\\");
                System.out.println("   |      / \\");
            }
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
