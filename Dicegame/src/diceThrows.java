
public class diceThrows {

	public int noofways(int faces,int sum,int dicesleft)
	{
		if(sum==0 && dicesleft==0)
			return 1;
		if(dicesleft==0 || sum==0)
			return 0;
		else
		{
			int ways = 0;
			for (int i = 1; i <= faces; i++) 
			{
				ways += noofways(faces, sum-i, dicesleft-1);
			}
			return ways;
		}
	}
	public static void main(String[] args) 
	{
		diceThrows dice = new diceThrows();
		System.out.println("the ways are " + dice.noofways(4, 5, 2));

	}

}
