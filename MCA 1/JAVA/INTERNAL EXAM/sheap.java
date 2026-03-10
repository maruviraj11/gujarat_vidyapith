import java.util.Scanner;
public interface sheap {

     public double area();
     public double perimeter();
     
}
class Rectangle implements sheap
{
     private double length;
     private double width;

    public Rectangle(double length,double width)
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
class Circle implements sheap
{
     private double redius;

     public Circle(double redius)
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
class shape11{
     public static void main(String[] args)
     {
          sheap re =new Rectangle(10,20 );
          sheap cir =new Circle(10);

          System.out.println("AREA OF RECTANGLE"+re.area());
          System.out.println("AREA OF CIRCLE"+cir.area());

           System.out.println("PERMITER OF RECTANGLE"+re.perimeter());
           System.out.println("PERMITER OF RECTANGLE"+cir.perimeter());

     }
}