
public class TrafficCongestionDivTwo {

	public long theMinCars(int treeHeight)
	{
		long cars[] = new long[treeHeight+1];
		if (treeHeight==0) {
			return 1;
		}
		cars[0] = 1;
		cars[1] = 1;
		
		for (int i = 2; i <= treeHeight; i++) 
		{
			cars[i] = 1;
			for (int j = 0; j <= i-2; j++) 
			{
				cars[i] += 2*cars[j];   
			}
		}
		return cars[treeHeight];
	}
	public static void main(String[] args) {
		TrafficCongestionDivTwo congestionDivTwo =  new TrafficCongestionDivTwo();
		System.out.println(congestionDivTwo.theMinCars(60));

	}

}
