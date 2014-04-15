
public class SuperRot {

	public String decoder(String message)
	{
		StringBuilder builder  = new  StringBuilder();
		for (int i = 0; i < message.length(); i++) 
		{
			int ascii = (int)message.charAt(i); 
			if (ascii >=65 && ascii<=77 )
			{
				builder.append((char)(ascii + 13));
			}
			else if (ascii >=78 && ascii<=90 )
			{
				builder.append((char)(ascii - 13));
			}
			else if (ascii >=97 && ascii<=109 )
			{
				builder.append((char)(ascii + 13));
			}
			else if (ascii >=110 && ascii<=122 )
			{
				builder.append((char)(ascii - 13));
			}
			else if (ascii >=48 && ascii<=52 )
			{
				builder.append((char)(ascii+5));
			}
			else if (ascii >=53 && ascii<=57 )
			{
				builder.append((char)(ascii-5));
			}
			else
				builder.append((char)ascii);
				
		}
		
		return builder.toString();
		
	}
	public static void main(String[] args) {
		SuperRot rot = new SuperRot();
		String  message = "Gur dhvpx oebja sbk whzcf bire n ynml qbt";
		System.out.println(rot.decoder(message));
		
	}

}
