import java.util.Scanner;

public class promain
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER A ANY CITY \n AHEMDABAD\n SURAT \n RAJKOT");
        String city=sc.nextLine();

        System.out.println("ENTER A ANY VALUE");
        double provalue=sc.nextDouble();

        propertytax tax = protaxfactory.gettax(city);

        if(tax!=null)
        {
            double totaltax=tax.cal(provalue);
            System.out.println("TOTAL TAX IS.."+totaltax);
        }
        else
        {
            System.out.println("invalied...");
        }
        
    }
}