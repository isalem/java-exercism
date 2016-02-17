import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Anagram {
    private final String word;

    public Anagram(String word) {
        this.word = word;
    }

    private Map<Character, Long> getNormalizedFrequency(String word) {
        return word.toLowerCase().chars().mapToObj(i -> (char)i).collect(groupingBy(identity(), counting()));
    }

    public List<String> match(List<String> candidates) {

        Map<Character, Long> wordFrequency = getNormalizedFrequency(word);

        return candidates.stream()
                .filter(anagram -> anagram.length() == word.length())
                .filter(anagram -> !anagram.equalsIgnoreCase(word))
                .filter(anagram -> getNormalizedFrequency(anagram).equals(wordFrequency))
                .collect(toList());
    }

}
