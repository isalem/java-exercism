import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Robot {

    private static HashSet<String> allNames = new HashSet<String>();

    private String name;

    public Robot() {
        this.name = generateUniqueName();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        this.name = generateUniqueName();
    }

    private String generateUniqueName() {

        ThreadLocalRandom randomize = ThreadLocalRandom.current();
        String name;
        do {
            name = String.valueOf((char) (65 + randomize.nextInt(26))) +
                    (char) (65 + randomize.nextInt(26)) +
                    randomize.nextInt(10) +
                    randomize.nextInt(10) +
                    randomize.nextInt(10);

        } while (allNames.contains(name));
        allNames.add(name);
        return name;
    }
}
