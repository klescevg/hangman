package com.klescevg.hangman;

import java.util.Scanner;

public class HangmanGame {
    Messages messages;

    public HangmanGame(Messages messages) {
        this.messages = messages;
    }

    public void startGame(){
        System.out.println(messages.getStartGameMessage());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                //start game function
            } else if (answer.equals("0")) {
                System.out.println(messages.getByeByeMessage());
                break;
            }else{
                System.out.println(messages.getWrongInputMessage());
            }
        }
    }
}
