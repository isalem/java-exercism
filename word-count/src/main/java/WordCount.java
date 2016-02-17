import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class WordCount {
    public Map<String, Integer> phrase(String phrase) {
        String[] lowercaseWords = phrase.toLowerCase().split("\\W+");
        return Arrays.stream(lowercaseWords)
                .collect(groupingBy(Function.identity(), summingInt(s -> 1)));
    }
}
