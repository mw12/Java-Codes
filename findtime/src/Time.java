public class Time {
	
	public String whatTime(int seconds) 
	{
		int divider = 3600;
		int i =0;
		int quantity[] = new int[3];
		StringBuffer str = new StringBuffer();
		while(divider>0)
		{
			quantity[i] = seconds/divider;
			seconds %= divider;
			divider /=60;
			str.append(String.valueOf(quantity[i]));
			if(divider>0)
				str.append(":");
			i++;
		}
		for (int j=0;j<str.length();j++)
			System.out.print(str.charAt(j));
		return str.toString();
	}
	
	public static void main(String args[])
	{
		
		Time t = new Time();
		t.whatTime(86339);
	}
	

}
