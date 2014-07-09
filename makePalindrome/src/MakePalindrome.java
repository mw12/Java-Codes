
public class MakePalindrome 
{

	String string ;
	int minmoves(int low,int high)
	{
		if(low>=high)
			return 0;
		else
		{
			if(string.charAt(low)== string.charAt(high))
			{
				return minmoves(low+1, high-1);
			}
			else
			{
				return 1 + (Math.min(minmoves(low+1, high), minmoves(low, high-1)));
			}
		}
			
	}
	public static void main(String[] args) 
	{
		MakePalindrome makePalindrome = new MakePalindrome();
		makePalindrome.string = "abca";
		System.out.println("the min moves are " + makePalindrome.minmoves(0, makePalindrome.string.length()-1));
		

	}

}
