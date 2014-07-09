import java.util.ArrayList;


public class subsetSum 
{
	int targetsum;
	public void sumsubset(int array[],int index,int sumtillnow,ArrayList<Integer> subset)
	{
		if(index < array.length)//sumitllnow < target
		{
			
			sumsubset(array, index +1, sumtillnow, subset);//not choosing the given index variable
			
			int tobesum = sumtillnow + array[index];//if chosen this path
			if(tobesum < targetsum)
			{
				ArrayList<Integer> copyindices = new ArrayList<Integer>();
				for (Integer integer : subset) 
				{
					copyindices.add(integer);
				}
				copyindices.add(array[index]);
				sumsubset(array, index+1, tobesum,copyindices);
			}
			if(tobesum == targetsum)
			{
				subset.add(array[index]);
				System.out.println(subset);
			}
		}
	}
	public static void main(String[] args) 
	{
		subsetSum subsetsum = new subsetSum();
		subsetsum.targetsum = 0;
		int array[] = {-7,-2,-3,5,8};
		subsetsum.sumsubset(array, 0, 0, new ArrayList<Integer>());

	}

}
