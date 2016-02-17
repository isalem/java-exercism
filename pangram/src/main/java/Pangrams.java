public class Pangrams {
    public static boolean isPangram(String sentence) {
        boolean result = false;

        String normalizedSentence = sentence.replaceAll("\\P{L}+", "").toLowerCase();
        long countUniqueLetters = normalizedSentence.chars()
                .distinct()
                .count();

        switch ((int) countUniqueLetters) {
            case 26: // English
                result = true;
                break;
            case 30: // German
                result = true;
                break;
            default:
                break;
        }

        return result;
    }
}