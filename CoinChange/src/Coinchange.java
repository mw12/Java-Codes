public class Coinchange 
{
	
	int mincoins(int amount,int coins[])
	{
		if(amount==0)
			return 0;
		else if(amount < 0)
			return Integer.MAX_VALUE-1;
		else
		{
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < coins.length; i++) 
			{
				int temp = mincoins(amount- coins[i],coins);
				if((temp + 1) < min)
					min = temp +1;
			}
			return min;
		}
			
	}
	public static void main(String[] args) 
	{
		Coinchange coinchange = new Coinchange();
		int coins[] = {1,10,20,25};
		System.out.println("the number of coins required are " + coinchange.mincoins(30, coins));

	}
}
