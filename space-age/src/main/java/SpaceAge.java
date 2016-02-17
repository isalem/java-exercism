public class SpaceAge {
    private enum Period {
        EARTH(31557600.0),
        MERCURY(EARTH.period * 0.2408467),
        VENUS(EARTH.period * 0.61519726),
        MARS(EARTH.period * 1.8808158),
        JUPITER(EARTH.period * 11.862615),
        SATURN(EARTH.period * 29.447498),
        URANUS(EARTH.period * 84.016846),
        NEPTUNE(EARTH.period * 164.79132);

        private final double period;
        Period(double period) {
            this.period = period;
        }

        public double getValue() { return period; }
    }

    private final long seconds;

    public SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }

    public double onEarth() {
        return seconds / Period.EARTH.getValue();
    }

    public double onMercury() {
        return seconds / Period.MERCURY.getValue();
    }

    public double onVenus() {
        return seconds / Period.VENUS.getValue();
    }

    public double onMars() {
        return seconds / Period.MARS.getValue();
    }

    public double onJupiter() {
        return seconds / Period.JUPITER.getValue();
    }

    public double onUranus() {
        return seconds / Period.URANUS.getValue();
    }

    public double onNeptune() {
        return seconds / Period.NEPTUNE.getValue();
    }

    public double onSaturn() {
        return seconds / Period.SATURN.getValue();
    }
}
