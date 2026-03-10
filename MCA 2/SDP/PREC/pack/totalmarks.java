package pack;
public class totalmarks {
    int m1,m2,m3;
    int total;
    double per;

    public void setdata(int m1,int m2,int m3)
    {

        this.m1=m1;
        this.m2=m2;
        this.m3=m3;

    }
    public double sum()
    {

        total=m1+m2+m3;

        per=total/3;

         return per;
    }
}
