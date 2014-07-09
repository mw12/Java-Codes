public class MinJumps 
{
	int minjumps(int array[],int low,int high)
	{
		if(low==high)
			return 0;
		if(low>high || array[low]==0)
			return Integer.MAX_VALUE;
		else
		{
			int minmovesfromhere = Integer.MAX_VALUE;
			for (int jump = 1; jump <= array[low] && (low+jump)<=high; jump++) 
			{
				int jumpsreq = minjumps(array, low+jump, high);
				if((jumpsreq + 1)<minmovesfromhere)
					minmovesfromhere = jumpsreq +1;
			}
			return minmovesfromhere;
		}
	}
	
	public static void main(String[] args) 
	{
		int array[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		MinJumps jumps = new MinJumps();
		System.out.println(jumps.minjumps(array, 0, array.length-1));

	}

}
