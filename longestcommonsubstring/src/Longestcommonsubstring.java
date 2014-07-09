public class Longestcommonsubstring 
{
	static String string1 = "geeksforgeeks";
	static String string2 = "ageeksquiz";
	static int maxindex = 0;
	static int length = 0;
	static int minindex = 0;
	public int isSubstring(int index1,int index2)
	{
		if(index1 == -1 || index2 == -1)
		{
			return 0;
		}
		else
		{
			if(string1.charAt(index1) == string2.charAt(index2))
			{
				int temp  = isSubstring(index1-1, index2-1); 
				if( (temp + 1) > length)
				{
					length = temp+1;
					maxindex = index1;
				}
				return temp + 1;
				
			}
			else
			{
				isSubstring(index1-1, index2);
				isSubstring(index1, index2-1);
				return 0;
			}
		}
	}
	public static void main(String[] args) 
	{
		Longestcommonsubstring longestcommonsubstring = new Longestcommonsubstring();
		longestcommonsubstring.isSubstring(string1.length()-1, string2.length()-1);
		System.out.println("the length is " + Longestcommonsubstring.length);
		minindex = maxindex  + 1 - length; 
		System.out.println(string1.substring(minindex,maxindex+1));
	}

}
