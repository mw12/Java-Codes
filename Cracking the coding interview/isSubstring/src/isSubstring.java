import java.util.Scanner;


public class isSubstring 
{
	
	public boolean issubstring(String parent,String permutation)
	{
		StringBuffer appended = new StringBuffer(parent);
		appended.append(parent);
		for (int i = 0; i < appended.length()/2; i++) 
		{
			if (appended.substring(i, i+permutation.length()).equals(permutation)) 
			{
				return true;
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter the parent string");
		String parent = scan.nextLine();
		
		System.out.println("enter the permutation string");
		String permutation = scan.nextLine();
		
		System.out.println(new isSubstring().issubstring(parent, permutation));

	}

}
