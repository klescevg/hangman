package com.klescevg.hangman;

public class MessageManager {
    private Language language;

    public MessageManager(Language language) {
        this.language = language;
    }

    public String getStartGameMessage() {
        return switch (language) {
            case ENGLISH -> "Do you want to start a new game? (type 1 for yes or 0 for no)";
            case RUSSIAN -> "Вы хотите начать новую игру? (введите 1 если да или 0 если нет)";
        };
    }

    public String getWrongInputMessage() {
        return switch (language) {
            case ENGLISH -> "Wrong input, try again!";
            case RUSSIAN -> "Неправильный символ, попробуйте ещё раз!";
        };
    }

    public String getWordMessage() {
        return switch (language) {
            case ENGLISH -> "Word: ";
            case RUSSIAN -> "Слово: ";
        };
    }

    public String getMistakesMessage() {
        return switch (language) {
            case ENGLISH -> "Mistakes";
            case RUSSIAN -> "Ошибки";
        };
    }

    public String getLetterMessage() {
        return switch (language) {
            case ENGLISH -> "Letter: ";
            case RUSSIAN -> "Буква: ";
        };
    }

    public String getLetterWarningMessage() {
        return switch (language) {
            case ENGLISH -> "Enter a lowercase letter!";
            case RUSSIAN -> "Введите строчную букву!";
        };
    }

    public String getAlreadyEnteredLetterMessage() {
        return switch (language) {
            case ENGLISH -> "This letter was already entered!";
            case RUSSIAN -> "Вы уже вводили эту букву!";
        };
    }

    public String getLossMessage() {
        return switch (language) {
            case ENGLISH -> "You lose! Do you want to start a new game? (type 1 for yes or 0 for no)";
            case RUSSIAN -> "Вы проиграли! Вы хотите начать новую игру? (введите 1 если да или 0 если нет)";
        };
    }

    public String getWinMessage() {
        return switch (language) {
            case ENGLISH -> "You won! Do you want to start a new game? (type 1 for yes or 0 for no)";
            case RUSSIAN -> "Вы выиграли! Вы хотите начать новую игру? (введите 1 если да или 0 если нет)";
        };
    }

    public String getByeByeMessage() {
        return switch (language) {
            case ENGLISH -> "Goodbye!";
            case RUSSIAN -> "До свидания!";
        };
    }

    public Language getLanguage() {
        return language;
    }
}
