import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class matrix {

    
    public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);
        int a[][]=new int[3][3];
        int b[][]=new int[3][3];
        int c[][]=new int[3][3];
        int d[][]=new int[3][3];

        int i,j;

        System.out.println("Enter a first matrix..");
        for( i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter a secound matrix..");
        for( i=0;i<=2;i++)
        {
            for( j=0;j<=2;j++)
            {
                b[i][j]=sc.nextInt();
            }
        }
        System.out.println("Multiphication of matrix is.");
        for( i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                for(int k=0;k<=2;k++)
                {
                    c[i][j]+=a[i][k]*b[k][j];
                }
               
            }
        }
        System.out.println("Enter a secound matrix..");
        for(i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                d[i][j]+=a[i][j]+b[i][j];
            }
        }
        System.out.println("Print matrix..");
        for(i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                System.out.print(" "+c[i][j]);
            }
            System.out.println();
        }
        System.out.println("addition ");
         for(i=0;i<=2;i++)
        {
            for(j=0;j<=2;j++)
            {
                System.out.print(" "+d[i][j]);
            }
            System.out.println();
        }

    }
    
}
