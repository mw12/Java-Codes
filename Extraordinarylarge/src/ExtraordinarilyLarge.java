
public class ExtraordinarilyLarge {

	public String compare(String x, String y)
	{
		int breakx = getfacts(x);
		int breaky = getfacts(y);
		int factx = x.length()- breakx;
		int facty = y.length()- breaky;
		System.out.println("fact x is " + factx + " facty is" + facty);
		int numx = Integer.parseInt(x.substring(0, breakx));
		int numy = Integer.parseInt(y.substring(0, breaky));
		
		System.out.println("numx is " + numx + " numy is " + numy);
		while (numx<13 && factx>0)
		{
			numx = getfact(numx);
			factx--;
		}
		while (numy<13 && facty>0)
		{
			numy = getfact(numy);
			facty--;
		}
		if (factx>facty)
		{
			return "x>y";
		}
		else if (factx<facty) 
		{
			return "x<y";
					
		}
		else
		{
			System.out.println("numx is " + numx + "numy is "+ numy);
			if (numx>numy)
			{
				System.out.println("here");
				return "x>y";
			}
			else if (numx<numy)
			{
				return "x<y";
			}
			else
				return "x=y";
		}
		
		
	}
	public int getfact(int num)

	{
		int i=1;
		int result = 1;
		while(i<num)
		{
			result *= i+1;
			i++;
		}
		return result;
				
	}
	public int getfacts(String str)
	{
		int index = str.length();
		for (int i = 0; i < str.length(); i++) 
		{
			if (str.charAt(i)=='!')
			{	
				index = i;
				break;
			}
		}
		return index;
	}
	public static void main(String[] args) {

		ExtraordinarilyLarge extraordinarilyLarge = new ExtraordinarilyLarge();
		String x = "14!";
		String y = "13!";
		System.out.println(extraordinarilyLarge.compare(x, y));
		


	}

}
