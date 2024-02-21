package com.klescevg.hangman;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Dictionary class manages the word dictionary used in the Hangman game
 */
public class Dictionary {
    private List<String> dictionary;

    public Dictionary() {
        dictionary = new ArrayList<>();
    }

    /**
     * Loads a dictionary from the specified file, filtering words based on a minimum length of 5 characters.
     */
    public void loadDictionary(String dictionaryName) {
        if (dictionary.isEmpty()) {
            try {
                Files.lines(Paths.get(dictionaryName)).
                        filter(word -> word.length() > 4).
                        forEach(word -> dictionary.add(word));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Retrieves a random word from the loaded dictionary.
     */
    public String getRandomWord(){
        if(!dictionary.isEmpty()){
            Random random = new Random();

            int randomIndex = random.nextInt(dictionary.size());

            return dictionary.get(randomIndex);
        } else {
            return null;
        }
    }
}
