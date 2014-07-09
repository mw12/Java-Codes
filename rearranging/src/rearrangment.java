import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;



public class rearrangment 
{

	public String rearrange(String string , int k)
	{
		char array[] = new char[string.length()	];
		array  = string.toCharArray();
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < array.length; i++) 
		{
			if(map.containsKey(array[i]))
			{
				map.put(array[i], map.get(array[i])+1);
			}
			else
			{
				map.put(array[i], 1);
			}
		}
		Iterator<Character> iter = map.keySet().iterator();
		while(iter.hasNext())
		{
			char temp = iter.next();
			//System.out.println(temp  + " - " + map.get(temp));
		}
		valuecomparator com =  new valuecomparator(map);
		TreeMap<Character, Integer> sortedmap = new TreeMap<Character, Integer>(com);
		sortedmap.putAll(map);
		Iterator<Character> iter1 = sortedmap.keySet().iterator();
		while(iter1.hasNext())
		{
			char temp = iter1.next();
			System.out.println(temp  + " - " + map.get(temp));
		}
		return  array.toString();
	}
	public static void main(String[] args) 
	{
	
		String string  =  new String("geeksforgeeks");
		rearrangment rearrange = new rearrangment();
		System.out.println(rearrange.rearrange(string, 2));
		

	}

}
