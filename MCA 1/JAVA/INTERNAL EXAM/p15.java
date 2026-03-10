import java.util.Scanner;

class p15
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter a any string");
		String inputstr=sc.nextLine();
		
		System.out.println("Enter a any find char...");
		String charstr=sc.nextLine();
		
		if(inputstr.length()=0)
		{
			System.out.println("Pleace enter atlist one char ...enter...!");
		}
		
		int count=0;
		boolean b1=false;
		//int i;
		 char target=charstr.charAt(0);
		
		System.out.println("Target the charecter is.."+target+"find out...!");
		for(int i=0;i<inputstr.length();i++)
		{
			if(inputstr.length()==target)
			{
				if(b1==false)
				{
					 System.out.print("Character '" + target+ "' found at indices: ");
					b1=true;
					
				}
				count++;
					System.out.println(i);
			}
		}
		if(count>0)
		{
			System.out.println("find the character is"+target+"index in"+count);
		}
		else
		{
			System.out.println("NOT FOUND...!");
		}
	}
}