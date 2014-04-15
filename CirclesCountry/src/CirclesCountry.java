
public class CirclesCountry {

	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2)
	{
		int crossings =0;
		
		for (int i = 0; i < X.length; i++) 
		{
			boolean  point1inside = true;
			boolean point2inside = true;
			if ((Math.pow(x1-X[i],2)+Math.pow(y1-Y[i], 2)) > Math.pow(R[i],2))
			{
				System.out.println("p1 is outside");
				point1inside = false;
				
			}
			if ((Math.pow(x2-X[i],2)+Math.pow(y2-Y[i], 2)) > Math.pow(R[i],2))
			{
				System.out.println("p2 is outside");
				point2inside = false;
				
			}
			if (point2inside!=point1inside)
				crossings++;
			System.out.println();
		}
		return crossings;
		
	}
	public static void main(String[] args) {

		CirclesCountry circlesCountry = new CirclesCountry();
		int X[] = {0,-6,6};
		int Y[] = {0,1,2};
		int R[] = {2,2,2};
		int x1 = -5, y1 = 1,x2 = 5,y2 = 1;
		System.out.println(circlesCountry.leastBorders(X, Y, R, x1, y1, x2, y2));

	}

}
