import java.util.ArrayList;
import java.util.Collections;


public class GroceryBagger {

	public int minimumBags(int strength, String[] itemType)
	{
		if (itemType.length==0) 
			return 0;
		
		int count=0;
		int bags=0;
		
		ArrayList<String> arrayList =  new ArrayList<String>();
		for (int i = 0; i < itemType.length; i++) 
			arrayList.add(itemType[i]);
		Collections.sort(arrayList);
	
		
		for (int i = 0; i < arrayList.size(); i++) 
		{
			System.out.println("index is " + i);
			String current = arrayList.get(i);
			count=0;
			int j=i;
			for (; j < arrayList.size(); j++) 
			{
				if (arrayList.get(j).equals(current)) {
					count++;
				}
				else
					break;
			}
			i=j-1;
			if (count%strength==0)
				bags += count/strength;
			else
				bags += (count/strength) + 1;
		}
		return bags;
	}
	public static void main(String[] args) {
		GroceryBagger bagger =  new GroceryBagger();
		int strength = 10; 	
		String [] itemType ={};
		System.out.println(bagger.minimumBags(strength, itemType));
	}
}
