package com.klescevg.hangman;

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
