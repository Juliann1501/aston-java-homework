public class Circle implements Shape {
    public double radius;
    public String borderColor;
    public String fillColor;

    public Circle(double radius, String borderColor, String fillColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getArea() { return Math.PI * radius * radius; }
    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}

class Rectangle implements Shape {
    public double width;
    public double height;
    public String borderColor;
    public String fillColor;

    public Rectangle(double width, double height, String borderColor, String fillColor) {
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getArea() { return width * height; }
    @Override
    public double getPerimeter() { return 2 * (width + height); }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}

class Triangle implements Shape {
    public double a, b, c;
    public String borderColor;
    public String fillColor;

    public Triangle(double a, double b, double c, String borderColor, String fillColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    @Override
    public double getPerimeter() { return a + b + c; }
    @Override
    public String getBorderColor() { return borderColor; }
    @Override
    public String getFillColor() { return fillColor; }
}