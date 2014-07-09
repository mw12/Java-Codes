
public class OptimalGame 
{
	public int maxvalue(int low,int high,int array[])
	{
		if((high-low)==1)
			return Math.max(array[low],array[high]);
		if((high==low) )
			return 0;
		else
		{
			int afterchoosinglow = Math.min(maxvalue(low+1, high-1, array), maxvalue(low+2, high, array));
			int afterchoosinghigh = Math.min(maxvalue(low, high-2, array), maxvalue(low+1, high-1, array));
			return Math.max(array[low] + afterchoosinglow, array[high] + afterchoosinghigh);
		}
	}

	public static void main(String[] args) 
	{
		int array[] = {5,3,7,10};
		OptimalGame game = new OptimalGame();
		System.out.println("the max earnings are " + game.maxvalue(0, array.length-1, array));

	}

}
