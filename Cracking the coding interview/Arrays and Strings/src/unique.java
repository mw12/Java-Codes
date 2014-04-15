import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class unique
{
//	public Boolean uniqueornot(String input)//O(N^2) complexity
//	{
//		Boolean flag = true;
//		for(int i=0;i<input.length();i++)
//		{
//			for(int j=i+1;j<input.length();j++)
//				if(input.charAt(j)==input.charAt(i))
//					{
//					flag = false;
//					i=input.length();
//	break;
//					}
//		}
//		return flag;
//	}
	
	public Boolean uniqueornot(String input)//using hashset to save memory 
	{
	
			HashSet<Character> hashset = new HashSet<Character>();
			boolean flag = true;
			for(int i=0;i<input.length();i++)
			{
				if(hashset.contains(input.charAt(i)))
					{
					flag= false;
					break;
					}
				else
					hashset.add(input.charAt(i));
				
			}
			return flag;
	}
//	public Boolean uniqueornot(String input)//using array set 
//	{
//		Boolean flag = true;
//		Boolean charset[] = new Boolean[256];
//		Arrays.fill(charset,false);
//		for(int i=0;i<input.length();i++)
//		{
//			if(charset[(int )input.charAt(i)])
//				{
//				flag=false;
//				break;
//				}
//			charset[(int)input.charAt(i)]=true; 
//		}
//		return flag;
//	}
	public static void main(String args[])
	{
		String input;
		Scanner scan  = new Scanner(System.in);
		input = scan.nextLine();
		System.out.println(new unique().uniqueornot(input));
		//System.out.println(input);
	}
}