
public class EggDropping 
{

	public int moves(int eggsleft,int floorsleft)
	{
		if(floorsleft==0)
			return 0;
		if(eggsleft == 0)
			return Integer.MAX_VALUE-1;
		else
		{
			int minhere = Integer.MAX_VALUE-1;
			for (int i = 1; i <= floorsleft; i++) 
			{
				int temp = Math.max(moves(eggsleft-1, i-1),moves(eggsleft, floorsleft - i));
				if((temp +1)<minhere)
					minhere = temp+1;
			}
			return minhere;
		}
	}
	public static void main(String[] args) 
	{
		EggDropping dropping =  new EggDropping();
		System.out.println("moves required are " + dropping.moves(2, 5));

	}

}
