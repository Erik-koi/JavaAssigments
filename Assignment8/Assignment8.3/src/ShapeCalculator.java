class Shape {
    double calculateArea() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) { this.radius = radius; }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle with width " + width + " and height " + height;
    }
}

class Triangle extends Shape {
    private double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle with base " + base + " and height " + height;
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(3.0, 8.0)
        };

        System.out.println("Shape Calculator");
        System.out.println();
        for (Shape s : shapes) {
            System.out.println("Area of " + s + ": " + s.calculateArea());
        }
    }
}