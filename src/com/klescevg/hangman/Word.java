package com.klescevg.hangman;

/**
 * The Word class represents the word to be guessed in the Hangman game.
 */
public class Word {
    private String hiddenWord;
    private char[] revealedLetters;

    /**
     * Sets the hidden word for the game and initializes the array of revealed letters with underscores.
     */
    public void setWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
        revealedLetters = new char[hiddenWord.length()];
        for (int i = 0; i < hiddenWord.length(); i++) {
            revealedLetters[i] = '_';
        }
    }

    /**
     * Prints the currently revealed letters, replacing unrevealed letters with underscores.
     */
    public void printRevealedLetters() {
        for (char c : revealedLetters) {
            System.out.print(c);
        }
        System.out.println();
    }

    /**
     * Checks if a given letter is already revealed in the word.
     */
    public boolean isLetterAlreadyRevealed(char letter){
        for (char revealedLetter : revealedLetters) {
            if (revealedLetter == letter && letter != '_') {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given letter is present in the hidden word.
     */
    public boolean isLetterPresent(char letter) {
        return hiddenWord.contains(String.valueOf(letter));
    }

    /**
     * Reveals occurrences of a given letter in the word.
     */
    public void addRevealedLetter(char letter){
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                revealedLetters[i] = letter;
            }
        }
    }

    /**
     * Checks if the entire hidden word has been revealed.
     */
    public boolean isHiddenWordRevealed(){
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (revealedLetters[i] == '_'){
                return false;
            }
        }
        return true;
    }
}

