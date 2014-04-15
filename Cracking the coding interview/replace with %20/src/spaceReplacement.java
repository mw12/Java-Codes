import java.util.Scanner;


public class spaceReplacement 
{

	public String replace(String input)
	{
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)==' ')//space
				buffer.append("%20");
			else
				buffer.append(input.charAt(i));
		}
		return buffer.toString();
	}
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(new spaceReplacement().replace(input));

	}

}
