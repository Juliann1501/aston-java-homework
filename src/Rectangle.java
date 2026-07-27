public class Rectangle implements Shape {
    private final double width;
    private final double height;
    private final String borderColor;
    private final String fillColor;

    public Rectangle(double width, double height, String borderColor, String fillColor) {
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double[] getSides() {
        return new double[]{ width, width, height, height };
    }

    @Override
    public double getArea() { return width * height; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}


