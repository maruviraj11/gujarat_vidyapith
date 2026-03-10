import java.util.Arrays;

public class p2 {

    public static void main(String args[])
    {
        int arr[]=new int[args.length];

        // if(args.length == 0) return;
    
        System.out.println("BEFORE SORTING");

        for(int i=0;i<args.length;i++)
        {
            arr[i]=Integer.parseInt(args[i]);
            System.out.println(arr[i]);
        }
        Arrays.sort(arr);

        System.out.println("After shorting...");
        for(int i=0;i<args.length;i++)
        {
            System.out.println(arr[i]);
              
        }
       System.out.println("minimum number is...!"+arr[0]+"maximum number is....!"+arr[args.length-1]);
       

    }
    
}
