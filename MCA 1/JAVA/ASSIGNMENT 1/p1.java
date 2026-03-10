/*1. 	Write a Java program that: 
•	Accepts an integer 
•	Prints whether it is prime  
•	Use for/while/ or do-while loops 
•	Uses if-else  
•	Demonstrate break and continue*/  	 	 	 
	 	 	 
import java.util.Scanner;
public class p1
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("ENTER A ANY NUMBER:");
			int num=sc.nextInt(); 
		
			boolean isPrime = true;
			int i=2;
		 
			if(num<=1)
			{
				isPrime=false;
			}
			else
			{
				while(i<=num/2)
				{
				
					if(num%i==0)
					{
						isPrime=false;
						break;
					}
					i++;
				}
			 }
		
		
			 if(isPrime)
			 {
				 System.out.println(num+"NUMBER IS PRIME");
			 }
			 else
			 {
				 System.out.println(num+"NUMBER IS NOT PRIME");
			 }
		 //sc.close();
		}
catch(Exception e)
{
		System.out.println("Exception : pleace enter vaiid input..");
		
		
	}
	finally
	{
			System.out.println("find the value..");
	}
}
}