import java.util.Scanner;

public class remove_duplicates 
{
//	public String deduplicate(String input)//using hashset to reduce time complexity O(n) 
	//but increases the space complexity
//	{
//		HashSet<Character> unique = new HashSet<Character>();
//		for(int i=0;i<input.length();i++)
//		{
//			if(unique.contains(input.charAt(i))==false)
//			{
//				unique.add(input.charAt(i));
//			}
//			
//		}
//		Iterator<Character> iter = unique.iterator();
//		ArrayList<Character> list = new ArrayList<Character>();
//		while(iter.hasNext())
//		{
//			list.add(iter.next());
//		}
//		
//		return list.toString();
//		
//	}
	
	public String deduplicate(String input)//time complexity O(n^2) space complexity O(space of the string)
	{
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<input.length();i++)
		{	
			int j=0;
			for(j=i+1;j<input.length();j++)
			{
				if(input.charAt(j)==input.charAt(i))
				{
					break;
				}
			}
			if(j==input.length())
				buffer.append(input.charAt(i));
		}
		return buffer.toString();
	}

	public static void main(String[] args) 
	{
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		long starttime = System.nanoTime();
		System.out.println(new remove_duplicates().deduplicate(input));
		long endtime = System.nanoTime();
		System.out.println("took " + (endtime-starttime)/1 +"ns" );
		
		
	}
}
