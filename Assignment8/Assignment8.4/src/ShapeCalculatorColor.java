class Shape {
    protected String color;

    Shape(String color) { this.color = color; }

    double calculateArea() { return 0; }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius + ", color " + color;
    }
}

class Rectangle extends Shape {
    private double width, height;

    Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle with width " + width + " and height " + height
                + ", color " + color;
    }
}

class Triangle extends Shape {
    private double base, height;

    Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle with base " + base + " and height " + height
                + ", color " + color;
    }
}

public class ShapeCalculatorColor {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5.0, "red"),
                new Rectangle(4.0, 6.0, "green"),
                new Triangle(3.0, 8.0, "blue")
        };

        System.out.println("Shape Calculator");
        System.out.println();
        for (Shape s : shapes) {
            System.out.println("Area of " + s + ": " + s.calculateArea());
        }
    }
}