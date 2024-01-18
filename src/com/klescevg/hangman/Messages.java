package com.klescevg.hangman;

public class Messages {
    private String language;

    public Messages(String language) {
        this.language = language;
    }

    public String getStartGameMessage() {
        if (language.equals("english")) {
            return "Do you want to start a new game? (type 1 for yes or 0 for no)";
        } else {
            return "Хочешь начать новую игру? (введи 1 если да или 0 если нет)";
        }
    }

    public String getWrongInputMessage(){
        if(language.equals("english")){
            return "Wrong input, try again!";
        } else{
            return "Неправильный символ, попробуй ещё раз!";
        }
    }

    public String getByeByeMessage(){
        if(language.equals("english")){
            return "Goodbye!";
        } else{
            return "Пока!";
        }
    }

    public String getLanguage() {
        return language;
    }
}
