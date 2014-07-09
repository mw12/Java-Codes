
public class PalindromePartitioning 
{

	public int mincuts(String string)
	{
		if(string.length()<=1 || isPalindrome(string))
			return 0;
		else
		{
			int mincut = Integer.MAX_VALUE-1;
			for (int i = 1; i < string.length(); i++) 
			{
				int temp = mincuts(string.substring(0, i)) + mincuts(string.substring(i+1));
				if((temp+1)<mincut)
					mincut = temp+1;
			}
			return mincut;
		}
	}
	boolean isPalindrome(String string)
	{
		for (int i = 0; i <= string.length()/2; i++) 
		{
			if(string.charAt(i)!=string.charAt(string.length()-1-i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) 
	{
		PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
		System.out.println(palindromePartitioning.mincuts("ababbbabbababa"));

	}

}
