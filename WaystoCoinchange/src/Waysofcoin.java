import java.util.ArrayList;
import java.util.Set;

public class Waysofcoin 
{

	static int calls = 0;
	public int noofways(int target,Set<Integer> coins,int lastchoosen)//brute force
	{
		calls++;
		if(target==0)
			return 1;
		else if(target < 0)
			return 0;
		else
		{
			int ways = 0;
			for (Integer integer : coins) 
			{
				if(integer>=lastchoosen)
					ways += noofways(target-integer, coins,integer);
			}
			return ways;
		}
	}
	public int bottomupways(int target,ArrayList<Integer> coinstouse)
	{
		int ways[][] = new int[target+1][coinstouse.size()+1];
		for (int i = 0; i < ways.length; i++) 
		{
			ways[i][0] = 0;
			
		}
		for (int i = 0; i < ways[0].length; i++) 
		{
			ways[0][i] = 1;
		}
		for (int row = 1; row < ways.length; row++) 
		{
			for (int col = 1; col < ways[0].length; col++) 
			{
				int excluding = ways[row][col-1];
				int newtarget = row - coinstouse.get(col-1);
				if(newtarget < 0)
					ways[row][col] = excluding;
				else
					ways[row][col] = excluding + ways[newtarget][col];
			}
		}
		return ways[target][coinstouse.size()];
	}
	public int recursivenoofways(int target,ArrayList<Integer> coinstouse)
	{
		calls++;
		if(target==0)
			return 1;
		if(target < 0)
			return 0;
		if(coinstouse.size() ==0 )
			return 0;
			
		else
			{
				ArrayList<Integer> changed= new ArrayList<Integer>(coinstouse);
				changed.remove(0);
				return recursivenoofways(target-coinstouse.get(0),coinstouse ) 
						+
						recursivenoofways(target,changed );
				
			}
	}
	public static void main(String[] args) 
	{
		
		Waysofcoin ways = new Waysofcoin();
//		Set<Integer> coins = new HashSet<Integer>();
//		coins.add(2);
//		coins.add(3);
//		coins.add(5);
//		coins.add(6);
//		System.out.println("ways are " + ways.noofways(10, coins,0));
//		System.out.println("calls are " + calls);
		
		ArrayList<Integer> coinstouse = new ArrayList<Integer>();
		coinstouse.add(5);
		coinstouse.add(2);
		coinstouse.add(3);
		coinstouse.add(6);
		System.out.println("iterative ways are " + ways.bottomupways(10, coinstouse));
//		System.out.println("ways are " + ways.recursivenoofways(10, coins));
//		System.out.println("calls are " + calls);
		
		
	}

}
