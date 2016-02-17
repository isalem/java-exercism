import java.util.HashMap;
import java.util.stream.Stream;

public class Scrabble {
    private final static HashMap<Character, Integer> score = new HashMap<>();

    static {
        Stream.of('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T').forEach(c -> score.put(c, 1));
        Stream.of('D', 'G').forEach(c -> score.put(c, 2));
        Stream.of('B', 'C', 'M', 'P').forEach(c -> score.put(c, 3));
        Stream.of('F', 'H', 'V', 'W', 'Y').forEach(c -> score.put(c, 4));
        Stream.of('K').forEach(c -> score.put(c, 5));
        Stream.of('J', 'X').forEach(c -> score.put(c, 8));
        Stream.of('Q', 'Z').forEach(c -> score.put(c, 10));
    }

    private final String word;

    public Scrabble(String word) {
        if (word == null) {
            this.word = "";
        } else {
            this.word = word.trim().toUpperCase();
        }
    }

    public int getScore() {
        return word.chars().mapToObj(i -> (char)i).map(score::get).reduce(0, Integer::sum);
    }
}
