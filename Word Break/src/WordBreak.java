import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak 
{
	Set<String> dict = new HashSet<String>();
	
	public boolean canbeformed(String word)
	{
		if(word.length()==0)
			return false;
		else
		{
			if(dict.contains(word))
				return true;
			for (int i = 1; i <= word.length()-1; i++) 
			{
				if(canbeformed(word.substring(0, i)) && canbeformed(word.substring(i)))
					return true;
			}
			return false;
		}
					
	}
	public static void main(String[] args) 
	{
		WordBreak wbreak = new WordBreak();
		String words[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
				  "cream", "icecream", "man", "go", "mango"};
		wbreak.dict.addAll(Arrays.asList(words));
		System.out.println(wbreak.canbeformed("ilikesamsung"));
		
		
	}

}
