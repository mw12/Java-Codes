public class PalindromeDecoding {

	public String decode(String code, int[] position, int[] length)
	{
		StringBuilder builder = new StringBuilder(code);
		
		for (int i = 0; i < position.length; i++) 
		{
			StringBuilder builder2 = new StringBuilder(builder.substring(position[i],position[i]+length[i]));
			builder2.reverse();
			builder.insert(position[i]+length[i],builder2.toString());
			
			
		}
		
		return builder.toString();
		
	}
	
	public static void main(String[] args) {
	PalindromeDecoding decoding =  new PalindromeDecoding();
	String code = "Misip";
	int []position = {2,3,1,7};
	int length[]  ={1,1,2,2};
	
	decoding.decode(code, position, length);

	}

}
