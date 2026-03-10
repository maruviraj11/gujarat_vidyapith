package pack;
public class student {

    String name,course;
    int roll;

    public void setdata(String name,int roll,String course)
    {
        this.name=name;
        this.roll=roll;
        this.course=course;
        
        
    }
    public void display()
    {
        System.out.println("----student information  is---");
        System.out.println("-------------------------------");
        System.out.println("\nSTUDENT NAME IS.."+name);
        System.out.println("\nSTUDENT ROLLNO IS.."+roll);
        System.out.println("\nSTUDENT COURSE IS.."+course);
            
    }
    
}
