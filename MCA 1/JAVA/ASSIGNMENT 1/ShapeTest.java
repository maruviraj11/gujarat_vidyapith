abstract class Shape {
    int dim1;
    int dim2;

    public Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract public double area();
    abstract public double perimeter();
}

class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        super(length, width);
    }

    public double area() {
        return dim1 * dim2;
    }

    public double perimeter() {
        return 2 * (dim1 + dim2);
    }
}

class Triangle extends Shape {
    int side3;

    public Triangle(int side1, int side2, int side3) {
        super(side1, side2);
        this.side3 = side3;
    }

    public double area() {
        double s = (dim1 + dim2 + side3) / 2.0;
        return Math.sqrt(s * (s - dim1) * (s - dim2) * (s - side3));
    }

    public double perimeter() {
        return dim1 + dim2 + side3;
    }
}

class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0);
    }

    public double area() {
        return Math.PI * dim1 * dim1;
    }

    public double perimeter() {
        return 2 * Math.PI * dim1;
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        Shape triangle = new Triangle(3, 4, 5);
        Shape circle = new Circle(7);

        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());

        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());
    }
}
