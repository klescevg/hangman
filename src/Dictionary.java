import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<String> dictionary;

    public Dictionary() {
        dictionary = new ArrayList<>();
    }

    public void loadDictionary() {
        try {
            Files.lines(Paths.get("russian_nouns.txt")).
                    filter(word -> word.length() > 4).
                    forEach(word -> dictionary.add(word));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
