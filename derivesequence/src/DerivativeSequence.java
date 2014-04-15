import java.util.Scanner;


public class DerivativeSequence {

	public int[] derSeq(int[] a, int n)
	{
		for(int i=0;i<n;i++)
			modify(a,i);
		for(int i=0;i<(a.length-n);i++)
			System.out.print(" ," + a[i]);
		return a;
		
	}
	public void modify(int[] a,int iteration)
	{
		for(int i=1;i<a.length-iteration;i++)
		{
			a[i-1] = a[i] - a[i-1];
		}
	}
	public static void main(String[] args) {
		
		DerivativeSequence derivativeSequence = new DerivativeSequence();
		//derivativeSequence.
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number of elements in the array to derive sequence from");
		int arrlen =  scan.nextInt();
		System.out.println("enter the array elements now:");
		int array[] = new int[arrlen];
		for(int i=0;i<arrlen;i++)
		{
			array[i] = scan.nextInt();
		}
		System.out.println("enter the number of times u want to recurse on");
		int times = scan.nextInt();
		derivativeSequence.derSeq(array, times);
		

	}

}
