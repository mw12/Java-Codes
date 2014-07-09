import java.util.Comparator;
import java.util.Map;


public class valuecomparator implements Comparator<Character> 
{
	public Map<Character, Integer> map;
	public valuecomparator(Map<Character,Integer> map) 
	{
		this.map = map;
	}
	public int compare(Character arg0, Character arg1) 
	{
		if(map.get(arg0) >= map.get(arg1))
			return 1;
		else
			return -1;
	}
	
}
