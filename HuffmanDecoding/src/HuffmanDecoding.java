import java.util.ArrayList;
import java.util.Arrays;

public class HuffmanDecoding {
	
	public String decode(String archive, String[] dictionary)
	{
		ArrayList<String>  arrayList  =new ArrayList<String>(Arrays.asList(dictionary));
		StringBuilder builder1 = new StringBuilder();
		
		StringBuilder builder  = new StringBuilder(archive);
		int index = 0;
		while(index<archive.length())
		{
		//	System.out.println("index is " + index);
			int length = 1;
			int value = 0;
			while((index+length)<=archive.length())
				{
				value  = getindex(arrayList,builder.substring(index,index+length));
				if(value == -1)
					length++;
				else
					{
					index = index+length;	
					break;
					}
					
				}
			//System.out.print(Character.toChars(value+65));
			builder1.append(Character.toChars(value+65));
		}
				//BBBABBAABBABBAAABBA
		return builder1.toString();
		
	}
	public int getindex(ArrayList<String> arrayList,String search)
	{
		int  position= -1;
		for (int i = 0; i < arrayList.size(); i++) 
		{
			if (arrayList.get(i).matches(search))
			{
				position = i;
				break;
			}
		}	
		//System.out.println("returned " + position);
		return position;
	}
	public static void main(String[] args) {
		HuffmanDecoding decoding = new HuffmanDecoding();
		String archive = "001101100101100110111101011001011001010";
		String[] dictionary ={"110","011","10","0011","00011","111","00010","0010","010","0000"};
		decoding.decode(archive, dictionary);

	}

}
