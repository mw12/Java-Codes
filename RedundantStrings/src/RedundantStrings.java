import java.util.Scanner;


public class RedundantStrings {

	public int howMany(int length)
	{
		StringBuffer buffer = new StringBuffer();
		
		return getnum(length, -1, buffer);
	}
	
	public int checkredundant(String str)
	{
		int count=0;
		int notthere =0;
		for(int j=0;j<str.length()/2;j++)
		{
			for(int i=j;i<str.length();i++)
			{
				notthere=0;
				int first = 0;
				int second = i+1;
				int len = second-first;
				
				while(second<str.length())						
				{
					if(str.charAt(first)==str.charAt(second))
					{
						
						second++;
						first++;
					}
					else
						{
						
						notthere=1;
						break;
						}
				}
				if(notthere==1)
					break;
				if(second==str.length() && str.length()%(len)==0)
					{
					count=1;
					break;
					}
			}
			if(count==1)
				break;
		}
		return count;
		
	}
	
	public int getnum(int length,int index,StringBuffer str)
	{
		
		if(index==length-1)
		{
		
			 int temp = checkredundant(str.toString());
//			 if(temp==1)
//				 System.out.println(str.toString());
			 return temp;
		}
		else
		{
			StringBuffer buffer  = new StringBuffer();
			StringBuffer buffer1  = new StringBuffer();
			for(int i=0;i<str.length();i++)
			{
				buffer.append(str.charAt(i));
				buffer1.append(str.charAt(i));
			}
					
			buffer.append('a');
			buffer1.append('b');
					
			return getnum(length, index+1, buffer) + getnum(length, index+1, buffer1); 
		}
			
	}
	public static void main(String[] args) {
		RedundantStrings redundantStrings = new RedundantStrings();
		System.out.println("enter the length of the string");
		Scanner  scan  = new Scanner(System.in);
		int length = scan.nextInt();
		System.out.println(redundantStrings.howMany(length));
		//System.out.println(redundantStrings.checkredundant("aaabaaaaba"));

	}

}
