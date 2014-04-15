
public class Best_buy_sell 
{
	public float[] bestdeal(float prices[])
	{
		
		float profit = 0;
		float minsofar = prices[0];
		float buy = prices[0];
		float sell = prices[0];
		for (int i = 1; i < prices.length; i++) 
		{
			if(prices[i]<minsofar)
			{
				minsofar = prices[i];
			}
			if((prices[i]-minsofar)>profit)
			{
				profit = prices[i]- minsofar;
				buy = minsofar;
				sell = prices[i];
			}
		}
		return new float[]{profit,buy,sell};
	}

	public static void main(String[] args) 
	{
		Best_buy_sell buy_sell = new Best_buy_sell();
		float prices[] = {(float) 55.39,(float) 109.23,(float) 48.29,(float) 81.59,(float) 105.53,(float) 94.45,(float) 12.24};
		float result[] = buy_sell.bestdeal(prices);
		
			System.out.println("the max profit that can be attained is "+ result[0]);
			System.out.println("buy at " + result[1] + " sell at "+result[2]);
	}

}
