package com.klescevg.hangman;

public class Word {
    private String hiddenWord;
    private char[] revealedLetters;

    public Word() {
    }

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

/*    public boolean checkPresence(char c) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == c) {
                revealedLetters[i] = c;
            }
        }
    }*/
}

