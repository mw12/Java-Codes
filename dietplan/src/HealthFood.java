import java.util.ArrayList;
import java.util.Arrays;

public class HealthFood {

	public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans)
	{
		int []calories = new int[fat.length];
		getcalories(protein, carbs, fat, calories);
		int result[] = new int[dietPlans.length];
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < dietPlans.length; i++) 
		{
			for (int j = 0; j < protein.length; j++) 
			{
				arrayList.add(j);
			}
			//System.out.println("calling with " + dietPlans[i]);
			result[i] = getindex(protein,carbs,fat,calories,dietPlans[i],0,arrayList);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		return result;
		
	}
	public int getindex(int[] protein, int[] carbs, int[] fat, int []calories,String dietPlans,int index,ArrayList<Integer> eligible)
	{
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		
		if (index==dietPlans.length()) {
			
			return eligible.get(0);
		}
		getselect(indexes, protein, carbs, fat, calories,dietPlans.charAt(index), eligible);
		
		if (indexes.size()==1) {
			
			return indexes.get(0);
		}
		else
		{
			 eligible.clear();
			 
			 for (int i = 0; i < indexes.size(); i++) {
				eligible.add(indexes.get(i));
			}
		
			return getindex(protein, carbs, fat, calories, dietPlans, index+1, eligible); 
		}
		
		
		
	}
	public ArrayList<Integer> getselect (ArrayList<Integer> indexes,int[] protein, int[] carbs, int[] fat, int []calories,char criteria,ArrayList<Integer> eligible)
	{
		switch(criteria)
		{
		case 'P':
			getselected(protein,1,indexes,eligible);
			break;
		case 'p':
			getselected(protein,0,indexes,eligible);
			break;
		case 'F':
			getselected(fat,1,indexes,eligible);
			break;
		case 'f':
			getselected(fat,0,indexes,eligible);
			break;
		case 'C':
			getselected(carbs,1,indexes,eligible);
			break;
		case 'c':
			getselected(carbs,0,indexes,eligible);
			break;
		case 'T':
			getselected(calories,1,indexes,eligible);
			break;
		case 't':
			getselected(calories,0,indexes,eligible);
			break;
		default:
			indexes.add(0);
		}
		return indexes;
		
	}
	public void getselected(int[] array,int maxormin,ArrayList<Integer> arrayList,ArrayList<Integer> eligible)
	{
		int compare;
		if (maxormin==1)
			compare = findmax(array,eligible);
		else
			compare = findmin(array,eligible);
		
		for (int i = 0; i < array.length ; i++) {
			
			if( eligible.contains(i)==true)
			{
		
				if (array[i]==compare)
				{
					arrayList.add(i);
					
				}
			}
			
		}
	}
	public int findmin(int []array,ArrayList<Integer> eligible)
	{
		
		int min=java.lang.Integer.MAX_VALUE;
		for (int i = 0; i < array.length ; i++) {
			if(eligible.contains(i)==true)
			{
				if(array[i]<min)
				{
					min=array[i];
				}
			}
				
		}
		return min;
	}
	public int findmax(int []array,ArrayList<Integer> eligible)
	{
		int max=0;
		
		
//		for (int i = 0; (i < array.length && eligible.contains(i)); i++) {
//			System.out.println("in max with satiaf");
//			if(array[i]>max)
//			{
//				max=array[i];
//			}
//		}
		for (int i = 0; i < array.length ; i++) {
			if(eligible.contains(i))
			{
				//System.out.println("in max with satiaf");
				if(array[i]>max)
					{
						max=array[i];
					}
				}
			}
			
		return max;
	}
	public void getcalories(int[] protein, int[] carbs, int[] fat,int []calories)
	{
		for (int i = 0; i < protein.length; i++) 
		{
			calories[i] = (protein[i]+carbs[i])*5 + fat[i]*9;
		}
	}
	public static void main(String[] args) {
		
		HealthFood food = new HealthFood();
		int []protein = {3, 4, 1, 5};
		int []carbs = {2, 8, 5, 1};
		
		int []fat = {5, 2, 4, 4};
		String []dietPlans = {"tFc", "tF", "Ftc"};
		food.selectMeals(protein, carbs, fat, dietPlans);
		

	}

}
