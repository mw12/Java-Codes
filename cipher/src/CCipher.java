
public class CCipher 
{
	
	
	public String decode(String cipherText, int shift)
	{
		StringBuffer str = new StringBuffer();
		for(int i=0;i<cipherText.length();i++)
			str.append((char)(getvalue((int)cipherText.charAt(i),shift)));
		return "str";
	}
	
	public int getvalue(int ascii,int shift)
	{
		if((ascii-shift)>=65)
			return ascii-shift;
		else
			return (90 -(65 - (ascii-shift)-1));
		
	}
		
	public static void main(String[] args)
	{
		CCipher ob = new CCipher();
		ob.decode("LIPPSASVPH",4);
	}
}
