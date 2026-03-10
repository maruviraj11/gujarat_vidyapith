import java.util.*;
class p3
{
	public static void main(String args[])
	{
		int i;
		int arr[]=new int[args.length];
		int last=args.length-1;
		
		System.out.println("before sorting...");
		
		for(i=0;i<args.length;i++)
		{
			arr[i]=Integer.parseInt(args[i]);
			System.out.println(arr[i]+" ");
		}
		Arrays.sort(arr);
		System.out.println("after sorting...");
		for(i=0;i<args.length;i++)
		{
			System.out.println(arr[i]+" ");
			
			
		}
		System.out.println("MIN VALUE:"+arr[0]+"MAX VALUE:"+arr[1]);
	}
}