import java.util.TreeSet;
public class UglyNumbers 
{
	public int nthugly(int n)
	{
		if(n==1)
			return 1;
		TreeSet<Integer> uglynums = new TreeSet<Integer>();
		uglynums.add(1);
		int temp = 0;
		for (int i = 0; i < n; i++) 
		{
			temp = uglynums.first();
			uglynums.add(temp*2);
			uglynums.add(temp*3);
			uglynums.add(temp*5);
			uglynums.remove(temp);
		} 
		return temp;
		
	}
	public static void main(String[] args) 
	{
		UglyNumbers numbers = new UglyNumbers();
		System.out.println("nth ugly is " + numbers.nthugly(15));

	}

}
