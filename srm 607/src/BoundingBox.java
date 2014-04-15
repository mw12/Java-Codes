public class BoundingBox {

	int smallestArea(int[] X, int[] Y)
	{
		int xmin = min(X);
		int xmax = max(X);
		int ymin = min(Y);
		int ymax = max(Y);
		return (ymax-ymin) * (xmax-xmin);
		
	}
	int min(int array[])
	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i]<min)
			{
				min = array[i];
			}
		}
		return min;
	}
	int max(int array[])
	{
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i]>max)
			{
				max = array[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoundingBox boundingBox = new BoundingBox();
		int X[] = {0,1};
		int Y[] = {1,0};
		
		System.out.println(boundingBox.smallestArea(X, Y));

	}

}
