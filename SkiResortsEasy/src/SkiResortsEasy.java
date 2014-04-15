
public class SkiResortsEasy {

	public int minCost(int[] altitude)
	{
		int sum=0;
		for(int i=1;i<altitude.length;i++)
		{
			if(altitude[i]>altitude[i-1])
			{
				sum += altitude[i] - altitude[i-1];
				altitude[i] = altitude[i-1];
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		SkiResortsEasy easy = new SkiResortsEasy();
		int altitude[] = {712, 745, 230, 200, 648, 440, 115, 913, 627, 621, 186, 222, 741, 954, 581, 193, 266, 320, 798, 745};
		System.out.println(easy.minCost(altitude));
		
		

	}

}
