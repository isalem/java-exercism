import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DNA {
    private final String dna;

    public DNA(String dna) {
        this.dna = dna;
    }

    public int count(char nucleotide) {
        if (nucleotide != 'A' && nucleotide != 'C' && nucleotide != 'G' && nucleotide != 'T') {
            throw new IllegalArgumentException();
        }
        return (int) dna.chars()
                .mapToObj(i -> (char)i)
                .filter(c -> c.equals(nucleotide))
                .count();
    }

    public Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> result = new HashMap<>();
        result.put('A', count('A'));
        result.put('C', count('C'));
        result.put('G', count('G'));
        result.put('T', count('T'));
        return result;
    }
}
