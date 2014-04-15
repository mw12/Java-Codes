
public class LargestSubsequence {

	public String getLargest(String s)
	{
		StringBuilder builder =  new StringBuilder();
		
		int index = 0;
		int value = 0;
		while(index<s.length())
		{
		value = getindex(s, index);
		builder.append(s.charAt(value));
		index = value+1;
		}
		return builder.toString();
		
	}
	public int getindex(String s,int index)
	{
		int value = index;
		
		int max =97;
		for (int i=index; i < s.length();i++) 
		{
			if((int)(s.charAt(i))>max)
			{
						max   = (int)(s.charAt(i));
				value = i;
			}
				
		}
		
		return value;
	}
	public static void main(String[] args) {
		LargestSubsequence largestSubsequence  = new LargestSubsequence();
		String s = "aa"; 
		System.out.println(largestSubsequence.getLargest(s));

	}

}
