import java.util.Scanner;
class exception{
    int a,b,c;
    
        public static void main(String args[])
        {
            try{
                    int a,b,c;
             Scanner sc=new Scanner(System.in);
            System.out.println("Enter a any number");
            a=sc.nextInt();

             System.out.println("Enter a any number");
             b=sc.nextInt();

            c=a+b;

            System.out.println(c);
            }
            catch(Exception e)
            {

            }
             

        }
}