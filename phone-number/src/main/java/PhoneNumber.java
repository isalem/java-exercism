public class PhoneNumber {
    private final String number;

    public PhoneNumber(String number) {
        this.number = normalizeNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public String getAreaCode() {
        return number.substring(0, 3);
    }

    public String pretty() {
        return "(" + getAreaCode() + ") " + number.substring(3, 6) + "-" + number.substring(6, 10);
    }

    private String normalizeNumber(String number) {
        String numberWithoutGarbage = number.replaceAll("[^\\d]+", "");
        if (numberWithoutGarbage.length() == 10) {
            return numberWithoutGarbage;
        }
        if (numberWithoutGarbage.length() == 11 && numberWithoutGarbage.startsWith("1")) {
            return numberWithoutGarbage.replaceFirst("1", "");
        }
        return "0000000000";
    }
}
