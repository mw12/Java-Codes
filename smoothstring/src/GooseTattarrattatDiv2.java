
public class GooseTattarrattatDiv2 {
	
	public int getmin(String S)
	{
		int count=0;
		Integer counts[] = new Integer[26];
		for(int i=0;i<26;i++)
			counts[i] = 0;
		for(int j=0;j<S.length();j++)
		{
			counts[(int)(S.charAt(j))-97]++;
		}
		
		int max =0;
		int index = 0;
		for(int i=0;i<26;i++)
			{
			if(counts[i]>=max)
			{
				max = counts[i];
				index = i;
			}
			}
		char cha = (char)(index + 97);
		for(int i=0;i<S.length();i++)
			if(S.charAt(i)!=cha)
				count++;
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		GooseTattarrattatDiv2 ob = new GooseTattarrattatDiv2();
		ob.getmin("xrepayuyubctwtykrauccnquqfuqvccuaakylwlcjuyhyammag");

	}

}
