import java.util.function.Function;

public class Binary {
    private int decimal;

    public Binary(String binary) {
        Function<String, String> reverseString = s -> new StringBuffer(s).reverse().toString();

        String reversedBinary = reverseString.apply(binary);
        int order = 0;

        for (int i = 0; i < reversedBinary.length(); i++) {
            char digitCharacter = reversedBinary.charAt(i);
            if (digitCharacter != '1' && digitCharacter != '0') {
                decimal = 0;
                break;
            }

            int digit = Integer.parseInt(String.valueOf(digitCharacter));
            decimal += digit * Math.pow(2, order);
            order++;
        }
    }

    public int getDecimal() {
        return decimal;
    }
}
