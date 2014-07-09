import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class runlengthencoding 
{

	public void encode(char array[])
	{
		Map<Character, Integer> encoding = new TreeMap<Character	, Integer>();
		for (int i = 0; i < array.length; i++) 
		{
				if(encoding.containsKey(array[i]))
				{
					encoding.put(array[i], encoding.get(array[i])+1);
				}
				else
				{
					encoding.put(array[i], 1);
				}
			
		}
		StringBuffer buff = new StringBuffer();
		for (Character c : encoding.keySet()) 
		{
			buff.append(c);
			buff.append(encoding.get(c));
		}
		System.out.println(buff);
	
	}
	public static void main(String[] args) 
	{
		String string = "AaBb";
		char array[] = string.toCharArray();
		Arrays.sort(array);
		new runlengthencoding().encode(array);
		
		
	}

}
