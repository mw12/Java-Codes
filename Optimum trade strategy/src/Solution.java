import java.util.Scanner;

public class Solution {

	public void optimumtrade(int rates[])
	{
		int low = 0;
		int high = rates.length;
		long profit = 0;
		while(true)
		{
			int index = findmaxindex(rates, low, high);
			profit += addprofit(rates,low,index);
			if(index==rates.length-1)
			{
				System.out.println("the profit is "+ profit);
				break;
			}
			low  = index+1;
		}
	}
	public long addprofit(int rates[],int low,int high)
	{
		long sum = 0;
		for (int i = low; i < high; i++) 
		{
			sum += rates[high] - rates[i];
		}
		return sum;
	}
	public int findmaxindex(int[] rates,int low,int high)
	{
		long max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = low; i < high; i++) 
		{
			if(rates[i]>max)
			{
				max = rates[i];
				index = i;
			}
		}
		return index;
	}
	public static void main(String[] args) 
	{
		Solution ob = new Solution();
		Scanner scan =  new Scanner(System.in);
		int testcases = scan.nextInt();
		while(testcases-- > 0)
		{
			int N = scan.nextInt();
			int rates[] = new int[N];
			int index = 0;
			while(index < N )
			{
				rates[index] = scan.nextInt(); 
				index++;
			}
			ob.optimumtrade(rates);
		}
	}

}
