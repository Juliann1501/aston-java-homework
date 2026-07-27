public class Circle implements Shape {
    private final double radius;
    private final String borderColor;
    private final String fillColor;

    public Circle(double radius, String borderColor, String fillColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double[] getSides() {
        return new double[]{ 2 * Math.PI * radius };
    }

    @Override
    public double getArea() { return Math.PI * radius * radius; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}

