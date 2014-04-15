public class UnderscoreJustification {

	public String justifyLine(String[] words, int width)
	{
		int spaces[] = new int[words.length-1];
		int cases[] = new int[words.length-1];
		int marked[] = new int[words.length-1];
		int length =0;

		for(int i=0;i<words.length;i++)
			length += words[i].length();
		for(int i=1;i<words.length;i++)
			if(words[i].charAt(0)>=97)//lower case then make it 2
				cases[i-1] = 2;

		int minimum = (width - length)/(words.length-1);
		for(int i=0;i<spaces.length;i++)
			spaces[i] = minimum;
		int left = (width-length) - (minimum*(words.length-1));
			
		for(int i=0;i<cases.length;i++)
		{
			if(left<=0)
				break;
			if(cases[i]==2)
				{
				left--;
				marked[i] = -1;
				spaces[i]++;
				}
		}
		int i=cases.length-1;
		while(left>0)
		{
		
			if(marked[i]!=-1)
				{
				spaces[i]++;
				left--;
				}
			
			i--;
		}
		for(int i1=0;i1<cases.length;i1++)
			System.out.print( spaces[i1] + " ");
		StringBuffer buffer = new StringBuffer();
		for(int i1=0;i1<cases.length;i1++)
		{
			buffer.append(words[i1]);
			for(int j=0;j<spaces[i1];j++)
				buffer.append('_');
		}
		buffer.append(words[words.length-1]);
		System.out.println(buffer);
		return buffer.toString();
	}

	public static void main(String[] args) {
		
		UnderscoreJustification justification = new UnderscoreJustification();
		String words[] = {"Hello", "world", "John", "said"};
		int width = 29;
		justification.justifyLine(words, width);

	}

}
