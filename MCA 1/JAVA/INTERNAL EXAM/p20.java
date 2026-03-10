import java.util.Scanner;

class p20
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int count=0;
        String name;
        char ch;

        System.out.println("Enter the name : ");
        name = sc.nextLine();

        System.out.println("Enter the character to find : ");
        ch = sc.next().charAt(0);

        for(int i=0;i<=name.length()-1;i++)
        {
            if(name.charAt(i) == ch)
            {
                count++;
                System.out.println(i);
            }
            
        }
        
        if(count == 0)
        {
            System.out.println("Character not found");
        }
        else
        {
            System.out.println("The numbre of occurences:"+count);
        }
    sc.close();
    }
}