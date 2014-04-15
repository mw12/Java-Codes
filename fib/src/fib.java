import java.util.ArrayList;
import java.util.Scanner;


public class fib {

	public int getn(int P,int C)
	{
		int i=1;
		while(true)
		{
			if ((getfib(i)%P) ==C)
			{
				break;
			}
			i++;
		}
		return i-1;
		
		
	}
	public int getfib(int n)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0,0);
		list.add(1,1);
		if(n==1)
			return list.get(0);
		else if (n==2) {
			return list.get(1);
		}
		else
		{
			int a = 0;
			int b=1;
			int c;
			while(list.size()<n)
			{
				c = a+b;
				a=b;
				b=c;
				list.add(c);
			}
			System.out.println("the n is " + n);
			return list.get(n-1);
		}
			
	}
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("enter the input");
	int C = scan.nextInt();
	System.out.println("enter the input");
	int P = scan.nextInt();
	fib fi = new fib();
	System.out.println(fi.getn(P,C));
	
	
	

	}

}
