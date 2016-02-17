import java.time.LocalDate;
import java.time.LocalDateTime;


public class Gigasecond {
    private final LocalDateTime from;

    public Gigasecond(LocalDate from) {
        this.from = from.atTime(0, 0, 0);
    }

    public Gigasecond(LocalDateTime from) {
        this.from = from;
    }


    public LocalDateTime getDate() {
        return from.plusSeconds((long) Math.pow(10, 9));
    }
}
