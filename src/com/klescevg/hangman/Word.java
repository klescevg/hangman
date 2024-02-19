package com.klescevg.hangman;

public class Word {
    private String hiddenWord;
    private char[] revealedLetters;

    public void setWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
        revealedLetters = new char[hiddenWord.length()];
        for (int i = 0; i < hiddenWord.length(); i++) {
            revealedLetters[i] = '_';
        }
    }

    public void printRevealedLetters() {
        for (char c : revealedLetters) {
            System.out.print(c);
        }
        System.out.println();
    }

    public boolean checkIfLetterIsAlreadyRevealed(char letter){
        for (char revealedLetter : revealedLetters) {
            if (revealedLetter == letter && letter != '_') {
                return true;
            }
        }
        return false;
    }

    public boolean checkPresence(char letter) {
        return hiddenWord.contains(String.valueOf(letter));
    }

    public void addRevealedLetter(char letter){
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                revealedLetters[i] = letter;
            }
        }
    }

    public boolean checkIfHiddenWordIsRevealed(){
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (revealedLetters[i] == '_'){
                return false;
            }
        }
        return true;
    }
}

