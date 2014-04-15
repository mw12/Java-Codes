
public class BinaryCode {

	public String[] decode(String message)
	{
		String str[] = new String[2];
		str[0] = getstring(message,0);
		str[1] = getstring(message,1);
			
		return str;
	}
	
	public String getstring(String message,int assumed)
	{
		StringBuffer temp = new StringBuffer(message.length());
		temp.append(message);
		temp.setCharAt(0,Character.forDigit(assumed,10));
		
		int prev = 0,original=0,current=0;
		
		if(message.length()==1)
		{
			if(Character.forDigit(assumed, 10)==message.charAt(0))
				return message.toString();
			else 
				return "NONE";
		}
		for(int i=0;i<message.length()-1;i++)
		{
			current = Character.getNumericValue(message.charAt(i));
						
			if(i==0)
				prev = 0;
			else 
				prev = Character.getNumericValue(temp.charAt(i-1));
			
			if(i==message.length()-1)
				original=0;
			else
				original = Character.getNumericValue(temp.charAt(i));
			
			if((current - prev - original)!=1 && (current - prev - original)!=0)
				return "NONE";
			else
			temp.setCharAt(i+1,Character.forDigit(current - prev - original,10));
			
		}
		if( Character.getNumericValue(message.charAt(message.length()-1))!=(Character.getNumericValue(temp.charAt(message.length()-1)) + Character.getNumericValue(temp.charAt(message.length()-2))) )
			return  "NONE";
		return temp.toString();
	}
	
	public static void main(String[] args) 
	{
	
		BinaryCode ob = new BinaryCode();
		String result[] = ob.decode("2221");
		for(String x:result)
		{
			System.out.println(x);
		}
		

	}

}
