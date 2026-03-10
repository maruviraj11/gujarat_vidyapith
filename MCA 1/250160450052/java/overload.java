import java.util.*;
class overload{
     int a;
     int b;
    void dis_info(int roll,String name,String depart)
    {
        System.out.println("This is method overloading\n");
        System.out.println("------stduent marks sheet...");
        System.out.println("Student rollno is:"+roll);
        System.out.println("Student name is:"+name);
        System.out.println("Student marks is:"+depart);
    }
    void dis_marks(String s1,int m1,String s2,int m2)
    {
        System.out.println("\n---Student subject details-----");
        System.out.println("first Subject is:"+s1);
        System.out.println("Marks of this subject:"+m1);
        System.out.println("first Subject is:"+s2);
        System.out.println("Marks of this subject:"+m2);
    }
    overload()
    {
       // System.out.println("This is constructor overloading \n");
       System.out.println("------ default constructor..-----");
       System.out.println("this is my code");
       this.a=10;
       this.b=20;
       System.out.println("A="+a);
       System.out.println("B="+b);
    }
    overload(int a,int b)
    {
        System.out.println("---This is my Parameterised constructor---");
         this.a=a;
         this.b=b;
        
    }
     int  sum()
    {
        return a+b;
    }
    public void display()
    {
        System.out.println("-----This is parent class method...");
        System.out.println("This is method overriding");
        
    }
   public static  class child extends overload
    {
        
        public void display_c()
        {
            System.out.println("----this is child class method---");
              System.out.println("This is method overriding");
           
        }
    }
    public static void main(String args[])
    {
        //Scanner s1=new Scanner(System.in);
       // int sum;
       overload obj1=new overload();

       
       obj1.dis_info(52,"viraj","MCA");
       obj1.dis_marks("python",99,"java",98);

       overload o1=new overload();
       overload o2=new overload(10,20);
        System.out.println("sum is:"+o2.sum());
        
        child obj2=new child();
      //  overload obj3=new child();
        obj2.display();
      //  obj3.display();
    }
}