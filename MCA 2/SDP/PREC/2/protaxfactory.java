public  class protaxfactory
{
    public static propertytax gettax(String city)
    {
        propertytax rs;

        if(city.equalsIgnoreCase("ahemdabad"))
        {
            rs = new amdtax(); 
        }
        else if(city.equalsIgnoreCase("surat"))
        {
            rs = new surattax();
        }
        else if(city.equalsIgnoreCase("rajkot"))
        {
            rs = new rajkottax();
        }
        else
        {
            return null;
        }
        return rs;


    }
}