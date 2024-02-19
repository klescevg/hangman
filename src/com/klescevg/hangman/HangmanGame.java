package com.klescevg.hangman;

import java.util.Scanner;

/**
 * The HangmanGame class represents the main logic for the Hangman game.
 */
public class HangmanGame {
    private static final String START_GAME_OPTION = "1";
    private static final String EXIT_GAME_OPTION = "0";
    private static final int MAX_MISTAKES = 6;
    private Scanner scanner;
    private MessageManager messageManager;
    private Dictionary dictionary;
    private Word word;
    private int mistakeCount;
    private char[] wrongLetters;

    public HangmanGame(MessageManager messageManager) {
        scanner = new Scanner(System.in);
        this.messageManager = messageManager;
        initDictionary();
        word = new Word();
        mistakeCount = 0;
        wrongLetters = new char[MAX_MISTAKES];
    }

    /**
     * Initializes the Hangman game, prompting the user to start a new game or exit.
     */
    public void initGame() {
        System.out.println(messageManager.getStartGameMessage());

        do {
            String answer = scanner.nextLine();

            if (answer.equals(START_GAME_OPTION)) {
                startNewGame();
            } else if (answer.equals(EXIT_GAME_OPTION)) {
                System.out.println(messageManager.getByeByeMessage());
                break;
            } else {
                System.out.println(messageManager.getWrongInputMessage());
            }
        } while (true);
    }

    /**
     * Starts a new game by setting up the word and managing user input and game progression.
     */
    private void startNewGame() {
        word.setWord(dictionary.getRandomWord());
        mistakeCount = 0;

        while (mistakeCount < MAX_MISTAKES) {
            printGameState();
            char letter = readLetter();
            checkLetter(letter);
            checkWin();
        }
    }

    /**
     * Prints the current game state, including the gallows, revealed letters, and mistakes.
     */
    private void printGameState() {
        printGallows();
        System.out.print(messageManager.getWordMessage());
        word.printRevealedLetters();

        System.out.print(messageManager.getMistakesMessage() + " (" + mistakeCount + "): ");
        printWrongLetters();
    }

    /**
     * Reads a letter from the user input, validating it, and ensuring it hasn't been entered before.
     */
    private char readLetter() {
        String input = "";

        while (true) {
            System.out.print(messageManager.getLetterMessage());
            input = scanner.nextLine();

            if (input.length() != 1 || !Character.isLowerCase(input.charAt(0))) {
                System.out.println(messageManager.getLetterWarningMessage());
                continue;
            } else if (isAlreadyEntered(input.charAt(0))) {
                System.out.println(messageManager.getAlreadyEnteredLetterMessage());
                continue;
            }

            break;
        }

        return input.charAt(0);
    }

    /**
     * Checks if the entered letter is correct, updates the game state, and handles mistakes.
     */
    private void checkLetter(char letter) {
        if (word.checkLetterPresence(letter)) {
            word.addRevealedLetter(letter);
        } else {
            wrongLetters[mistakeCount] = letter;
            mistakeCount++;
        }
    }

    /**
     * Checks if the game is won or lost, displaying appropriate messages.
     */
    private void checkWin() {
        System.out.println();
        if (mistakeCount == MAX_MISTAKES) {
            System.out.println(messageManager.getLossMessage());
        } else if (word.checkIfHiddenWordIsRevealed()) {
            System.out.println(messageManager.getWinMessage());
            mistakeCount = MAX_MISTAKES;
        }
    }

    /**
     * Checks if the letter has already been entered.
     */
    private boolean isAlreadyEntered(char letter){
        return checkIfLetterIsAlreadyWrong(letter) || word.checkIfLetterIsAlreadyRevealed(letter);
    }

    /**
     * Checks if the letter is present among already entered wrong letters.
     */
    private boolean checkIfLetterIsAlreadyWrong(char letter) {
        for (char wrongLetter : wrongLetters) {
            if (wrongLetter == letter) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the list of wrong letters that have already been entered.
     */
    private void printWrongLetters() {
        for (int i = 0; i < mistakeCount; i++) {
            System.out.print(wrongLetters[i]);
            if (i < mistakeCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Prints the gallows based on the current mistake count.
     */
    private void printGallows() {
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

    /**
     * Initializes the game dictionary based on the selected language.
     */
    private void initDictionary() {
        dictionary = new Dictionary();
        String fileName;

        if (messageManager.getLanguage() == Language.ENGLISH) {
            fileName = "english_nouns.txt";
        } else {
            fileName = "russian_nouns.txt";
        }

        dictionary.loadDictionary(fileName);
    }
}

