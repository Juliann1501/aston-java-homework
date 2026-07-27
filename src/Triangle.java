public class Triangle implements Shape {
    private final double a, b, c;
    private final String borderColor;
    private final String fillColor;

    public Triangle(double a, double b, double c, String borderColor, String fillColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double[] getSides() {
        return new double[]{ a, b, c };
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}