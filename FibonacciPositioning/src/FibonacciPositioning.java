
public class FibonacciPositioning {

	
	
	public double getFPosition(int n)
	{
		if (n==1) {
			return 2;
		}
		int a=0;
		
		int b=1;
		int count =1;
		int c = 1;
		while(c<n)
		{
			count++;
			c= a+b;
			if (c==n)
			{
				return count;
			}
			a=b;
			b=c;
			System.out.println("count is "  + count);
			
		}
		System.out.println("count  " + count);
		int fibi = a;
		int fibipus1 = c;
		System.out.println("here fibi is " + fibi + " and fib(i+1) is " + fibipus1  );
		double ret = (double)(n-fibi)/(fibipus1-fibi);
		
		return ((count-1)+ret);
		
		//
		
		
	}
	public static void main(String[] args) {
		FibonacciPositioning fibonacciPositioning = new FibonacciPositioning();
		System.out.println(fibonacciPositioning.getFPosition(2));

	}

}
