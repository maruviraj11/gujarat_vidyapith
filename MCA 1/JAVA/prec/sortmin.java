import java.util.*;
public class sortmin
{
	public static void main(String args[])
	{
		int arr[]=new int[args.length];
		int last=arr.length-1;
		
		System.out.println("before sorting:");
		
		for(int i=0;i<args.length;i++)
		{
			arr[i]=Integer.parseInt(args[i]);
			System.out.print(arr[i]+" ");
		}
		
		Arrays.sort(arr);
		
		System.out.println("After sorting:");
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}	
			System.out.println("min value:"+arr[0]+"max value:"+arr[args.length-1]);
		
	}
}