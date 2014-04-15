public class College extends Event{
    static String var="Subclass";
   
    public static void met()
    {
        System.out.println("In subclass");
    }

public static void main(String args[])
{
College e = new College();
e.met();
System.out.print(e.var); //prints superclass
}
}