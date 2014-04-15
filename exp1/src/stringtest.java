import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class stringtest {

	public static void main(String[] args) throws NoSuchAlgorithmException 
	{

		ArrayList<String > a =  new ArrayList<String>();
		
		a.add("0 $$$ you ### 2.0");
		a.add("1 $$$ you ### 2.0");
		a.add("10 $$$ you ### 2.0");
		a.add("11 $$$ we ### 0.5");	
		a.add("110 $$$ what ### 0.5");	
		a.add("121 $$$ which ### 1.");
		Collections.sort(a, new Comparator<String>() 
		{
			@Override
			public int compare(String o1, String o2) 
			{
				int indexofdollar = o1.indexOf("$$$");
				String index = o1.substring(0, indexofdollar).trim();
				
				int indexofdollar1 = o2.indexOf("$$$");
				String index1 = o2.substring(0, indexofdollar1).trim();
				
				return Integer.valueOf(index).compareTo(Integer.valueOf(index1));//(Integer.valueOf(index1));
				
			}
			
		});
		for (int i = 0; i < a.size(); i++) 
		{
			System.out.println(a.get(i));
		}
	}

}
