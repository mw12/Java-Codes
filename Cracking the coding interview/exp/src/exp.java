
public class exp 
{
	public static void main(String args[])
	{
		String sentences[] = new String[3];
		sentences[0] = "sahil";
		sentences[1] = "mittal";
		sentences[2] = "third";
		StringBuffer buffer =  new StringBuffer();
		for(String str:sentences)
		{
			
			buffer.append(str);
			System.out.println(buffer);
		}
		System.out.println(buffer);
	}

}
