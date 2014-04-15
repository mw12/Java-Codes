
public class DigitsSum {

	public int lastDigit(int n)
	{
		boolean valid = true;
		int sum = 0;
		while (valid)
		{
			sum = 0;
			while (n>0) 
			{
				sum += n%10;
				n/=10;
			}
			if (sum/10 ==0 )
			{
				valid = false;
						
			}
			n = sum;
			
		}
		return sum;
		
	}
	public static void main(String[] args) {
	DigitsSum digitsSum  = new DigitsSum();
	System.out.println(digitsSum.lastDigit(2147483647));

	}

}
