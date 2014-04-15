import java.util.Arrays;
import java.util.Scanner;


public class anagram 
{

	//can implement the naive method or the one in which count the occurences of each unique letter of the strings
	public Boolean checkanagram(String first,String second)//sort method
	{
		char temp[] = first.toCharArray();
		Arrays.sort(temp);
		String one = new String(temp);
		temp = second.toCharArray();
		Arrays.sort(temp);
		String two = new String(temp);
		return one.equals(two);
		
	}
	public static void main(String[] args) 
	{
		
		Scanner scan =  new Scanner(System.in);
		System.out.println("enter your first string");
		String first = scan.nextLine();
		System.out.println("enter your second string");
		String second = scan.nextLine();
		
		System.out.println("when checked for anagram ,the system returned " + new anagram().checkanagram(first,second));
	}

}
