
public class PalindromicSubstringsDiv2 {

	public int count(String[] S1, String[] S2)
	{
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<S1.length;i++)
		{
			buffer.append(S1[i]);
		}
		for(int i=0;i<S2.length;i++)
		{
			buffer.append(S2[i]);
		}
		return getsubpalindromes(buffer);
		
		
	}
	int getsubpalindromes(StringBuffer str)
	{
		int pals = 0;
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<=str.length();j++)
			{
				if(checkpalindrome(str.substring(i, j)))
						{
							pals++;
						}
			}
		}
		return pals;
	}
	boolean checkpalindrome(String st)
	{
		for(int i=0;i<st.length()/2;i++)
		{
			
			if(st.charAt(i)!= st.charAt(st.length()-1-i))
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1[] = {"a"};
		String S2[] = {"c"};
		PalindromicSubstringsDiv2 div2 = new PalindromicSubstringsDiv2();
		System.out.println(div2.count(S1, S2));
	}

}
