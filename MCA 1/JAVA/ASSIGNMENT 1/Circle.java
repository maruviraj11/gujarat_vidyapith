public class Circle {
    
    private int x;       
    private int y;      
    private double r;    

    
    public Circle() {
        this(0, 0, 1); 
    }

  
    public Circle(double r) {
        this(0, 0, r);
    }

   
    public Circle(int x, int y, double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.x = x;
        this.y = y;
        this.r = r;
    }

    
    public double area() {
        return Math.PI * r * r;
    }

    public double circumference() {
        return 2 * Math.PI * r;
    }

    
    public static void main(String[] args) {
        try {
            Circle c1 = new Circle();
            System.out.println("Default Circle Area: " + c1.area());
            System.out.println("Default Circle Circumference: " + c1.circumference());

            Circle c2 = new Circle(5);
            System.out.println("Radius 5 Area: " + c2.area());
            System.out.println("Radius 5 Circumference: " + c2.circumference());

            Circle c3 = new Circle(2, 3, -4); 
            System.out.println(c3.area()); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
