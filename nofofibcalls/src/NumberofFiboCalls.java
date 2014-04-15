
public class NumberofFiboCalls {

	int call0=0;
	int call1 =0;
	public int[] fiboCallsMade(int n)
	{
		count(n);
		int array[] = {call0,call1};
		System.out.println(call0 + " " +  call1);
		return array;
	}
	public void count(int n)
	{

		if(n==1)
		{
			call1++;
		}
		else if(n==0)
		{
			call0++;
		}
		else 
		{
			count(n-1);
			count(n-2);
		}
	}
	
	public static void main(String[] args) {

		NumberofFiboCalls calls = new NumberofFiboCalls();
		calls.fiboCallsMade(22);

	}

}
