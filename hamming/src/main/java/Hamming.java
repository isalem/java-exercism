import com.codepoetics.protonpack.StreamUtils; // https://github.com/poetix/protonpack

import java.util.stream.Stream;

public class Hamming {
    public static int compute(String seq1, String seq2) {
        if (seq1.length() != seq2.length()) throw new IllegalArgumentException("Sequences must have the same lengths");

        Stream<Character> seq1Stream = seq1.chars().mapToObj(i -> (char) i);
        Stream<Character> seq2Stream = seq2.chars().mapToObj(i -> (char) i);

        return StreamUtils
                .zip(seq1Stream, seq2Stream, (a, b) -> a.equals(b)? 0 : 1)
                .reduce(0, Integer::sum);
    }
}
