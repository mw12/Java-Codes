import java.util.ArrayList;


public class FibonacciSequence {

	public int numFibs(int a, int b)
	{
		//ArrayList<Integer> arrayList =  new
		ArrayList<Integer> array = getfib(b);
		int index = 0;
		for (int i = 0; i < array.size(); i++) 
		{
			if (array.get(i)>=a) {
				index = i;
				break;
			}
			
		}
		
		if (array.get(array.size()-1)==b) {
			return (array.size()-index);
		}
		else
			return (array.size()-index-1);
		
		
	}
	public ArrayList<Integer> getfib(int n)
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(0,0);
		arrayList.add(1, 1);
		int a=0;
		int b= 1;
		
		int greatest = 1;
		while(greatest<n)
		{
			greatest = a+b;
			a=b;
			b=greatest;
			arrayList.add(greatest);
			
		}
		
		return arrayList;
	}
	
	public static void main(String[] args) {
		FibonacciSequence fibonacciSequence = new FibonacciSequence();
		System.out.println("the number of fibonnaci numbers between a and b are " + fibonacciSequence.numFibs(2,144));

	}

}
