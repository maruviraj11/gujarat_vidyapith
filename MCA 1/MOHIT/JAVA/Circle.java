/* Practical : [7]
Create a class named Circle with the following:
1. Private Variables:
- x (int) — x-coordinate of the center of the circle
- y (int) — y-coordinate of the center of the circle
- r (double) — radius of the circle
2. Constructors:
- Define all possible constructors to initialize the circle’s properties (e.g., default
constructor, parameterized constructor).

3. Methods:
- public double area ()
* Calculates and returns the area of the circle.
- public double circumference ()

*/


public class Circle {
    private int x;
    private int y;
    private double r;

    Circle() {
        x = 0;
        y = 0;
        r = 1.0;
    }

    Circle(double radius) {
        x = 0;
        y = 0;
        r = radius;
    }

    Circle(int xCoord, int yCoord, double radius) {
        x = xCoord;
        y = yCoord;
        r = radius;
    }

    public double area() {
        return 3.14 * r * r;
    }

    public double circumference() {
        return 2 * 3.14 * r;
    }

    public void displayCircle() {
        System.out.println("Center: (" + x + ", " + y + "), Radius: " + r);
    }

    public static void main(String[] args) {
        try {
            Circle c1 = new Circle();
            c1.displayCircle();
            System.out.println("Area: " + c1.area());
            System.out.println("Circumference: " + c1.circumference());

            Circle c2 = new Circle(5);
            c2.displayCircle();
            System.out.println("Area: " + c2.area());
            System.out.println("Circumference: " + c2.circumference());

            Circle c3 = new Circle(2, 3, 7.5);
            c3.displayCircle();
            System.out.println("Area: " + c3.area());
            System.out.println("Circumference: " + c3.circumference());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
