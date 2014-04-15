/*
 * given buildings of different heights ..
 * you need to find out the amount of water that will be collected
 * between the buildings given the width of each building is 1
 */
public class Water {

	public int getwater(int []array,int low,int high)
	{
		System.out.println("entered with low as " + low  + " and high as " + high);
		if(low==high)
			return 0;
		else
		{
			int sum = 0;
			int highest = getmax(array,low,high);
			System.out.println("highest is " + highest);
			int left = getmax(array,low,highest-1);
			System.out.println("left is " + left);
			int right = getmax(array,highest+1,high);
			
			
			System.out.println("right is " + right);
			if(left==low)
			{
				sum += computerwater(array,left, highest);
			}
			else
				sum+= getwater(array, low, left) + computerwater(array, left, highest);
			
			System.out.println("sum is " + sum);
			if(right==high)
				sum += computerwater(array,highest,right);
			else
				sum += getmax(array, right, highest) + computerwater(array, highest,right);
			
			return sum;
		}
	}
	public int getmax(int []array,int low,int high)
	{
		if(low>high)
			return high;
		int max = array[low];
		int index = high;
		for(int i=low;i<=high;i++)
		{
			//System.out.println("comparing "+array[i] + " with " + max );
			if(array[i]>=max)
				{
				max = array[i];
				index = i;
				}
		}
		return index;
	}
	
	public int computerwater(int []array,int low,int high)
	{
		int water = 0;
		int min = Math.min(array[low],array[high]);
		while(low<(high-1))
		{
			System.out.println("here with low as " + min);
			if(array[low+1]<min)
				water += min -array[low+1];
			//System.out.println("water is " + water);
			low++;
			
		}
		return water;
	}
	
		
	public static void main(String[] args) {
		
		Water water = new Water();
		int array[] = {8,1,5,3,7,2,1,4,10};
		System.out.println(water.getwater(array,0,array.length-1));
		

	}

}
