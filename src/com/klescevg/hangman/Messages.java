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
            return "Вы хотите начать новую игру? (введите 1 если да или 0 если нет)";
        }
    }

    public String getWrongInputMessage(){
        if(language.equals("english")){
            return "Wrong input, try again!";
        } else{
            return "Неправильный символ, попробуйте ещё раз!";
        }
    }

    public String getWordMessage(){
        if(language.equals("english")){
            return "Word: ";
        } else{
            return "Слово: ";
        }
    }

    public String getMistakesMessage(){
        if(language.equals("english")){
            return "Mistakes";
        } else{
            return "Ошибки";
        }
    }

    public String getLetterMessage(){
        if(language.equals("english")){
            return "Letter: ";
        } else{
            return "Буква: ";
        }
    }

    public String getLetterWarningMessage(){
        if(language.equals("english")){
            return "Enter a lowercase letter!";
        } else{
            return "Введите строчную букву!";
        }
    }

    public String getAlreadyEnteredLetterMessage(){
        if(language.equals("english")){
            return "This letter was already entered!";
        } else{
            return "Вы уже вводили эту букву!";
        }
    }

    public String getLossMessage(){
        if(language.equals("english")){
            return "You lose!";
        } else{
            return "Вы проиграли!";
        }
    }

    public String getWinMessage(){
        if(language.equals("english")){
            return "You won!";
        } else{
            return "Вы выиграли!";
        }
    }

    public String getByeByeMessage(){
        if(language.equals("english")){
            return "Goodbye!";
        } else{
            return "До свидания!";
        }
    }

    public String getLanguage() {
        return language;
    }
}
