import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SumToKey 
{

	public static void main(String[] args) 
	{
		
		int array[] = {1,3,5,2,4};
		int sum = 1;
		Set hashSet = new HashSet();
		for (int i = 0; i < array.length; i++) 
		{
			hashSet.add(new Integer(array[i]));
		}
		Iterator iterator =  hashSet.iterator();
		while(iterator.hasNext())
		{
			Integer a = (Integer) iterator.next();
			if(hashSet.contains(new Integer(sum -a.intValue())))
				{
				System.out.println("true , it contains "+ a + " and " + (sum - a.intValue()));
				break;
				}
		}
		System.out.println("False");
		

	}
}
