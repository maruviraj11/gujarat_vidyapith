import java.util.Arrays;
import java.util.Scanner;
 public class p12
{
    public static void main(String args[])
    {
        int arr[] = new  int [args.length];

        System.out.println("Before Sorting ...!");

        for(int i=0;i<args.length;i++)
        {
            arr[i]=Integer.parseInt(args[i]);
            System.out.println(arr[i]);
        }

        Arrays.sort(arr);

        System.out.println("After sorting this....!");

        for(int i=0;i<args.length;i++)
        {
            System.out.println(arr[i]);
        }
        System.out.println("Minimum value is...."+arr[0]+"Maximum value is...."+arr[args.length-1]);

    }
}