import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RomanNumeral {
    private final static HashMap<Integer, String> romanNumbers = new HashMap<>();

    static {
        romanNumbers.put(1,    "I");
        romanNumbers.put(2,    "II");
        romanNumbers.put(3,    "III");
        romanNumbers.put(4,    "IV");
        romanNumbers.put(5,    "V");
        romanNumbers.put(6,    "VI");
        romanNumbers.put(7,    "VII");
        romanNumbers.put(8,    "VIII");
        romanNumbers.put(9,    "IX");
        romanNumbers.put(10,   "X");
        romanNumbers.put(20,   "XX");
        romanNumbers.put(30,   "XXX");
        romanNumbers.put(40,   "XL");
        romanNumbers.put(50,   "L");
        romanNumbers.put(60,   "LX");
        romanNumbers.put(70,   "LXX");
        romanNumbers.put(80,   "LXXX");
        romanNumbers.put(90,   "XC");
        romanNumbers.put(100,  "C");
        romanNumbers.put(200,  "CC");
        romanNumbers.put(300,  "CCC");
        romanNumbers.put(400,  "CD");
        romanNumbers.put(500,  "D");
        romanNumbers.put(600,  "DC");
        romanNumbers.put(700,  "DCC");
        romanNumbers.put(800,  "DCCC");
        romanNumbers.put(900,  "CM");
        romanNumbers.put(1000, "M");
        romanNumbers.put(2000, "MM");
        romanNumbers.put(3000, "MMM");
    }

    private final String number;

    public RomanNumeral(int number) {
        Function<String, String> reverseNumber = n -> new StringBuffer(n).reverse().toString();

        String numberInStringForm = Integer.toString(number);
        String reversedNumberInStringForm = reverseNumber.apply(numberInStringForm);

        int order = 1;
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < reversedNumberInStringForm.length(); i++) {
            int num = Integer.parseInt(String.valueOf(reversedNumberInStringForm.charAt(i))) * order;
            String romanNumber = romanNumbers.getOrDefault(num, "");
            stack.push(romanNumber);

            order *= 10;
        }

        this.number = stack.stream().collect(Collectors.joining());
    }

    public String getRomanNumeral() {
        return number;
    }
}
