
public class ModBinarySearch 
{

	public int getfirstmatch(int array[],int low,int high,int key)
	{
		System.out.println("low is " + low + " and high is "+ high);
		if(low==high)
			return low;
		else
		{
			int mid = low +(high-low)/2;
			if(key <= array[mid])
				return getfirstmatch(array, low, mid-1, key);
			else
				return getfirstmatch(array, mid+1, high, key);
		}
	}
	public int getlastmatch(int array[],int low,int high,int key)
	{
		System.out.println("low is " + low + " and high is "+ high);
		if(low==high || high<low)
			return low;
		else
		{
			int mid = low +(high-low)/2;
			if(key >= array[mid])
				return getlastmatch(array, mid+1, high, key);
			else
				return getlastmatch(array, low, mid-1, key);
		}
	}
	public static void main(String[] args) 
	{
		int array[] = {1,1,2,2,2,2,3,3};
		ModBinarySearch binarySearch =  new ModBinarySearch();
		System.out.println(binarySearch.getfirstmatch(array, 0, array.length-1, 2)+1);
		System.out.println(binarySearch.getlastmatch(array, 0, array.length-1, 2)-1);
	}

}
