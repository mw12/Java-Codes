
public class Longpalseq 
{
	int maxlength(String string)
	{
		if(string.length() <= 1 )
			return string.length();
		else
		{
			if(string.charAt(0)==string.charAt(string.length()-1))
				return maxlength(string.substring(1, string.length()-1)) + 2;
			else
				return Math.max(maxlength(string.substring(1)), maxlength(string.substring(0, string.length()-1)));
		}
	}
	public static void main(String[] args) 
	{
		Longpalseq longpalseq  = new Longpalseq();
		System.out.println("the longest pal seq is  " + longpalseq.maxlength("geeks for geeks"));

	}

}
