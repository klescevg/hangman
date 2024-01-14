package com.klescevg.hangman;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private List<String> dictionary;

    public Dictionary() {
        dictionary = new ArrayList<>();
    }

    public void loadDictionary(String dictionaryName) {
        try {
            Files.lines(Paths.get(dictionaryName)).
                    filter(word -> word.length() > 4).
                    forEach(word -> dictionary.add(word));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

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
