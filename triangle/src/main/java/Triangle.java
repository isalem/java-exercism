public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) throws TriangleException {
        if (a == 0 || b == 0 || c == 0 || a + b <= c || a + c <= b || b + c <= a) throw new TriangleException();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TriangleKind getKind() {
        if (a == b && b == c) return TriangleKind.EQUILATERAL;
        if (a == b || a == c || b == c) return TriangleKind.ISOSCELES;
        return TriangleKind.SCALENE;
    }
}
