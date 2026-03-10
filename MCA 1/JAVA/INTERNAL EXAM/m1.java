import java.util.Scanner;
public class m1 {

    

        
    public static void main(String args[])
    {
        int i,j;

        int a[][]=new int[3][3];
        int b[][]=new int[3][3];
        int c[][]=new int[3][3];

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a first matrix..");
        for(i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                    a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter a sec matrix..");
        for(i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                    b[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter a multiphication matrix..");
        for(i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                for( int k=0;k<=2;k++)
                {
                     c[i][j]+=a[i][k]*b[k][i];
                }
                   
            }
        }
         System.out.println("Enter a sec matrix..");
        for(i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                 System.out.print(" "+c[i][j]);  
            }
            System.out.println();
        }
    }
    
}
