package aggregation;

public class college {
    
    teacher teach;

   public college(teacher teach)
    {
        this.teach=teach;
    }
   public void show()
    {
        System.out.println("Teacher name:"+teach);
    }
   
}
