package com.klescevg.hangman;

/**
 * The Language enum represents the supported languages for the Hangman game.
 */
public enum Language {
    ENGLISH("english"),
    RUSSIAN("russian");

    private String language;

    Language(String language){
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
