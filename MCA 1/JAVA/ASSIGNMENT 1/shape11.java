import java.util.Scanner;
interface shape
{
    public double area();
    public double perimeter();
}
class Ractangle implements shape
{
    private double length;
    private double width;

    public Ractangle(double length,double width)
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
class Triangle implements shape
{
    private double side1,side2,side3;
    private double height,base;

    public Triangle(double side1,double side2,double side3)
    {
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
        
    }
    public Triangle(double height,double base,boolean useBaseHeight)
    {
        this.base=base;
        this.height=height;
    }
    public double area()
    {
        if(height>0 && base>0)
        {
            return 0.5*base*height;
        }
        else
        {
            double s=perimeter()/2;
            return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        }
       
    }
    @Override
    public double perimeter() 
    {
        if(side1>0 && side2>0 && side3>0)
        {
            return side1+side2+side3;
        }
        else
        {
            return 0;
        }
        
    }
}
class Circle implements shape
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
    @Override
    public double perimeter() {
        
        return 2*Math.PI*redius;
    }

}
class shape11
{
    public static void main(String[] args)
    {
        shape ract = new Ractangle(10, 20);
        shape tria  = new Triangle(2, 3, 4);
        shape cir   = new Circle(10);

        System.out.println("AREA OF RACTANGLE:" +ract.area());
        System.out.println("AREA OF TRIANGLE"+tria.area());
        System.out.println("AREA OF CIRCLE IS"+cir.area());

        System.out.println("PERIMETER OF RACTABGLE"+ract.perimeter());
        System.out.println("PERIMETER OF TRIANGLE"+tria.perimeter());
        System.out.println("PERIMETER OF CIRCLE"+cir.perimeter());


    }
}