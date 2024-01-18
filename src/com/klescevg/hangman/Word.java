package com.klescevg.hangman;

public class Word {
    private String hiddenWord;
    private char[] revealedLetters;

    public Word(){}

    public void setWord(String hiddenWord){
        this.hiddenWord = hiddenWord;
        revealedLetters = new char[hiddenWord.length()];
    }
}
