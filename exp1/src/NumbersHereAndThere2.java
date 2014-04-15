
public class NumbersHereAndThere2 extends ConstructorForSale1{

	public NumbersHereAndThere2() {
		
		//super();
		System.out.println("sub class");

	}
	public void mt()
	{
		System.out.println("in method sub class");
	}
	
public static void main(String... args)
{

	NumbersHereAndThere2 obsuper;
	obsuper =  new NumbersHereAndThere2();
	obsuper.mt();
	
}

}


