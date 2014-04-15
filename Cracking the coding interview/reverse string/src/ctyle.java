//a string is cstyle when it has a null character at last
import java.util.ArrayList;
import java.util.Scanner;

public class ctyle 
{

	public String reversectyle(String input)
	{
		Character temp;
		ArrayList<Character> arr = new ArrayList<Character>();
		for(int i=0;i<input.length();i++)
			arr.add(input.charAt(i));
		
		for(int index=0;index<arr.size()/2;index++)
		{
			temp = arr.get(index);
			arr.set(index,arr.get(arr.size()-index-1));
			arr.set((arr.size()-index-1),temp);
		}
		return arr.toString();
			
		
	}
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(new ctyle().reversectyle(input));

	}
}
