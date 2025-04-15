# Shape Calculator

## Overview
This program is a simple Shape Calculator that allows users to compute the area, perimeter, and volume (if applicable) of various geometric shapes. The user selects a shape from a menu and provides the necessary dimensions. The program then calculates and displays the required values.

## Features
- Supports multiple shapes: Circle, Rectangle, Triangle, Square, Sphere, and Cylinder.
- Computes:
  - Area for all shapes
  - Perimeter for Rectangle and Square
  - Circumference for Circle
  - Surface Area and Volume for Sphere and Cylinder
- Interactive menu-based selection.

## How to Run the Program
### Prerequisites
- Java Development Kit (JDK) installed.
- A Java-compatible IDE or terminal to execute the program.

### Steps to Run
1. Save the code in a file named `ShapeCalculator.java`.
2. Open a terminal or command prompt and navigate to the folder containing the file.
3. Compile the program using:
   ```sh
   javac ShapeCalculator.java
   ```
4. Run the program using:
   ```sh
   java ShapeCalculator
   ```
5. Follow the on-screen instructions to choose a shape and provide input values.

## Example Usage
```
Choose a shape to compute area, perimeter, or volume:
1 : Circle
2 : Rectangle
3 : Triangle
4 : Square
5 : Sphere
6 : Cylinder
0 : Exit
Enter your choice: 1
Enter the radius: 5
Area: 78.54
Circumference: 31.42
```

## Classes and Their Functions
### `CircleShape`
- `calculateArea()`: Computes the area of a circle.
- `calculateCircumference()`: Computes the circumference of a circle.

### `RectangleShape`
- `calculateArea()`: Computes the area of a rectangle.
- `calculatePerimeter()`: Computes the perimeter of a rectangle.

### `TriangleShape`
- `calculateArea()`: Computes the area of a triangle.

### `SquareShape`
- `calculateArea()`: Computes the area of a square.
- `calculatePerimeter()`: Computes the perimeter of a square.

### `SphereShape`
- `calculateSurfaceArea()`: Computes the surface area of a sphere.
- `calculateVolume()`: Computes the volume of a sphere.

### `CylinderShape`
- `calculateSurfaceArea()`: Computes the surface area of a cylinder.
- `calculateVolume()`: Computes the volume of a cylinder.

## Author
- Created by [Your Name]

## License
This project is open-source and available for use and modification.