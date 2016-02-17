import org.joda.time.DateTime;

public class Meetup {

    private final DateTime meetupDate;

    public Meetup(int monthOfYear, int year) {
        this.meetupDate = new DateTime(year, monthOfYear, 1, 0, 0);
    }

    public DateTime day(int dayOfWeek, MeetupSchedule schedule) {

        DateTime withTheCorrectDayOfWeek;

        if (meetupDate.getDayOfWeek() <= dayOfWeek) {
            withTheCorrectDayOfWeek = meetupDate.withDayOfWeek(dayOfWeek);
        } else {
            withTheCorrectDayOfWeek = meetupDate.plusDays(7 - meetupDate.getDayOfWeek() + 1).withDayOfWeek(dayOfWeek);
        }

        switch (schedule) {
            case FIRST:
                return withTheCorrectDayOfWeek;
            case SECOND:
                return withTheCorrectDayOfWeek.plusWeeks(1);
            case THIRD:
                return withTheCorrectDayOfWeek.plusWeeks(2);
            case FOURTH:
                return withTheCorrectDayOfWeek.plusWeeks(3);
            case LAST:
                if (withTheCorrectDayOfWeek.plusWeeks(4).getMonthOfYear() == withTheCorrectDayOfWeek.getMonthOfYear()) {
                    return withTheCorrectDayOfWeek.plusWeeks(4);
                } else {
                    return withTheCorrectDayOfWeek.plusWeeks(3);
                }
            case TEENTH:
                while (true) {
                    if (withTheCorrectDayOfWeek.plusWeeks(1).getDayOfMonth() < 20) {
                        withTheCorrectDayOfWeek = withTheCorrectDayOfWeek.plusWeeks(1);
                    } else {
                        return withTheCorrectDayOfWeek;
                    }
                }
        }

        return null;
    }
}
