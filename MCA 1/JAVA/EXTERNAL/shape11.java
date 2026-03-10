import java.util.Scanner;

public interface shape11 {

    public double area();
    public double perimeter();

}
class ractangle implements shape11
{
    private double length;
    private double width;

    public ractangle( double length, double width)
    {
        this.length=length;
        this.width=width;
    }
    public double area()
    {
        return length*width;

    }
    public double perimeter()
    {
        return 2*(length+width);
    }

}
class Circle implements shape11
{
    private double redius;

    public Circle( double redius)
    {
        this.redius=redius;
    }

    public double area()
    {
        return Math.PI*redius*redius;
    }
    public double perimeter()
    {
        return 2*Math.PI*redius;
    }
}
public class shape11  {

    public static void main(String[] args)
    {
        shape r1=new ractangle(10,20);
        shape c1=new Circle(10);

        System.out.println("AREA OF RECTANGLE.."+r1.area());
        System.out.println("AREA OF CIRLCE.."+c1.area());

        System.out.println("perimeter of rectangle.."+r1.perimeter());
        System.out.println("perimeter of circle.."+c1.perimeter());
    }

    
}