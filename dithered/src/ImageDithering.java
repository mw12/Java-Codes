public class ImageDithering {
	public int count(String dithered, String[] screen)
	{
		int count=0;
		for(int i=0;i<dithered.length();i++)
		{
			for(int j =0;j<screen.length;j++)
			{
				String str = screen[j];
				for(int k=0;k<str.length();k++)
					if(str.charAt(k)==dithered.charAt(i))
						count++;
			}
		}
		//System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		
		ImageDithering im = new ImageDithering();
		String str[] ={"BBBBBBB",
				 "BBBBBBB",
		 "BBBBBBB"};
		im.count("CA",str);

	}

}
