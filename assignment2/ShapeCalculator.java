package assignment2;

import java.util.*;

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose a shape to compute area, perimeter, or volume:");
            System.out.println("1 : Circle");
            System.out.println("2 : Rectangle");
            System.out.println("3 : Triangle");
            System.out.println("4 : Square");
            System.out.println("5 : Sphere");
            System.out.println("6 : Cylinder");
            System.out.println("0 : Exit");

            int option = scanner.nextInt();

            if (option == 0) {
                System.out.println("Exiting the program.");
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("Enter the radius:");
                    double radius = scanner.nextDouble();
                    CircleShape circle = new CircleShape(radius);
                    System.out.println("Area: " + circle.calculateArea());
                    System.out.println("Circumference: " + circle.calculateCircumference());
                    break;
                case 2:
                    System.out.println("Enter the length:");
                    int length = scanner.nextInt();
                    System.out.println("Enter the width:");
                    int width = scanner.nextInt();
                    RectangleShape rectangle = new RectangleShape(length, width);
                    System.out.println("Area: " + rectangle.calculateArea());
                    System.out.println("Perimeter: " + rectangle.calculatePerimeter());
                    break;
                case 3:
                    System.out.println("Enter the base:");
                    int base = scanner.nextInt();
                    System.out.println("Enter the height:");
                    int height = scanner.nextInt();
                    TriangleShape triangle = new TriangleShape(base, height);
                    System.out.println("Area: " + triangle.calculateArea());
                    break;
                case 4:
                    System.out.println("Enter the side length:");
                    int side = scanner.nextInt();
                    SquareShape square = new SquareShape(side);
                    System.out.println("Area: " + square.calculateArea());
                    System.out.println("Perimeter: " + square.calculatePerimeter());
                    break;
                case 5:
                    System.out.println("Enter the radius of the sphere:");
                    double sphereRadius = scanner.nextDouble();
                    SphereShape sphere = new SphereShape(sphereRadius);
                    System.out.println("Surface Area: " + sphere.calculateSurfaceArea());
                    System.out.println("Volume: " + sphere.calculateVolume());
                    break;
                case 6:
                    System.out.println("Enter the radius of the cylinder:");
                    double cylinderRadius = scanner.nextDouble();
                    System.out.println("Enter the height of the cylinder:");
                    double cylinderHeight = scanner.nextDouble();
                    CylinderShape cylinder = new CylinderShape(cylinderRadius, cylinderHeight);
                    System.out.println("Surface Area: " + cylinder.calculateSurfaceArea());
                    System.out.println("Volume: " + cylinder.calculateVolume());
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}

// Circle Class
class CircleShape {
    private double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle Class
class RectangleShape {
    private int length, width;

    public RectangleShape(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int calculateArea() {
        return length * width;
    }

    public int calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Triangle Class
class TriangleShape {
    private int base, height;

    public TriangleShape(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Square Class
class SquareShape {
    private int side;

    public SquareShape(int side) {
        this.side = side;
    }

    public int calculateArea() {
        return side * side;
    }

    public int calculatePerimeter() {
        return 4 * side;
    }
}

// Sphere Class
class SphereShape {
    private double radius;

    public SphereShape(double radius) {
        this.radius = radius;
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double calculateVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}

// Cylinder Class
class CylinderShape {
    private double radius, height;

    public CylinderShape(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}