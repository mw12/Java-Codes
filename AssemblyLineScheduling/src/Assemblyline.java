
public class Assemblyline 
{
	int cost[][] = {{4, 5, 3, 2},
            		{2, 10, 1, 4}};
	int trans[][] = {{ 7, 4, 5},
        			 { 9, 2, 8}};
	int start[] = {10,12};
	int exit[] = {18,7};
	
	
	public int mincost(int currentline,int currentstation,boolean atStart)
	{
		if(atStart)
		{
			return Math.min(start[0] + mincost(0, 0, false), start[1] + mincost(1, 0, false));
		}
		else
		{
			if(currentstation==cost[0].length-1)
			{
				return cost[currentline][currentstation] + exit[currentline];
			}
			else
			{
				return Math.min(cost[currentline][currentstation] + mincost(currentline, currentstation+1, atStart),
						cost[currentline][currentstation] + trans[currentline][currentstation] + mincost((currentline +1) % 2, currentstation+1, atStart));
			}
		}
	}
	public static void main(String[] args) 
	{
		Assemblyline assemblyline  = new Assemblyline();
		System.out.println("the cost is " + assemblyline.mincost(0, 0, true));
		
	}

}
