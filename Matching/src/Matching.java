import java.util.ArrayList;
import java.util.Arrays;


public class Matching {

	public 	String[] findMatch(String[] first, String[] second)
	{
		String[] shapea = {"DIAMOND","SQUIGGLE",  "CIRCLE"};
		String[] colora = {"BLUE","RED",  "GREEN"};
		String[] patterna = {"SOLID","STRIPED",  "EMPTY"};
		String[] counta = {"ONE","TWO",  "THREE"};
	
		String result[] = new String[first.length]; 
		for (int i = 0; i < first.length; i++) 
		{
			ArrayList<String> shape = new ArrayList<String>(Arrays.asList(shapea));
			ArrayList<String> color = new ArrayList<String>(Arrays.asList(colora));
			ArrayList<String> pattern = new ArrayList<String>(Arrays.asList(patterna));
			ArrayList<String> count = new ArrayList<String>(Arrays.asList(counta));
			if (checksame(first[i], second[i]))
			{
				result[i] = first[i];
			}
			else
			{
				if (i==0)
				{
					shape.remove(first[i]);
					shape.remove(second[i]);
					result[i] = shape.get(0);
				}
				else if (i==1)
				{
					color.remove(first[i]);
					color.remove(second[i]);
					result[i] = color.get(0);
				}
				else if (i==2)
				{
					pattern.remove(first[i]);
					pattern.remove(second[i]);
					result[i] = pattern.get(0);
				}
				else if (i==3)
				{
					count.remove(first[i]);
					count.remove(second[i]);
					result[i] = count.get(0);
				}
				
				
			}
			System.out.println(result[i] + " ");
		}
		
		return result;
		
	}
	public boolean checksame(String first,String second)
	{
		if (first.equals(second)) {
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		Matching matching = new Matching();
		String first[] ={"CIRCLE","GREEN","EMPTY","TWO"};
		String second[] = {"DIAMOND","BLUE","STRIPED","ONE"};
		matching.findMatch(first, second);

	}

}
