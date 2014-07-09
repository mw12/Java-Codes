import java.util.Scanner;


public class EncodeString 
{
	public String encodedString(String input)
	{
		if(input.length()==0)
			return new String();
		StringBuffer buffer =  new StringBuffer();
		char lastchar = input.charAt(0);
		int count=0;
		for (int i = 0; i < input.length(); i++) 
		{
			if(input.charAt(i)==lastchar)
			{
				count++;
			}
			else
			{
				buffer.append(lastchar + "" + count);
				lastchar = input.charAt(i);
				count=1;
			}
			
		}
		buffer.append(lastchar + "" + count);
		return buffer.toString();
	}

	public static void main(String[] args) 
	{
		System.out.println("input string");
		Scanner scan = new Scanner(System.in);
		
		
		EncodeString encodeString =  new EncodeString();
		System.out.println(encodeString.encodedString(scan.next()));
		scan.close();

	}

}
