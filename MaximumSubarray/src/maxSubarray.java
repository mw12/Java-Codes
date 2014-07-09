import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class maxSubarray 
{
	public int bruteforce(int array[]) //O(n^2)
	{
		
		int globalmaxsum = Integer.MIN_VALUE;
		
		for (int i = 0; i < array.length; i++) 
		{
			int maxsumstarting = Integer.MIN_VALUE;
			int sum = 0;
			for (int j = i; j < array.length; j++) 
			{
				sum += array[j];
				if(sum > maxsumstarting)
					maxsumstarting = sum;
			}
			globalmaxsum =  Math.max(maxsumstarting, globalmaxsum);
			
		}
		return globalmaxsum;
	}
	public int kadanesalgo(int array[])//O(n)
	{
		int maxsofar = 0;
		int maxendhere = 0;
		for (int i = 0; i < array.length; i++) 
		{
			maxendhere = Math.max(0, maxendhere+array[i]);
			maxsofar = Math.max(maxsofar, maxendhere);
		}
		return maxsofar;
	}
	public int divideandconquer(int array[],int low,int high)
	{
		if(low==high)
			return array[low];
		else
		{
			int mid = low+(high-low)/2;
			int leftmaxsubarray = divideandconquer(array, low, mid);
			int rightmaxsubarray = divideandconquer(array, mid+1, high);
			int crossingmaxsubarray = crossingsubarray(array, low, mid,high);
			System.out.println("left is " + leftmaxsubarray + " right is "+ rightmaxsubarray + " crossed is "+ crossingmaxsubarray);
			return Math.max(leftmaxsubarray, Math.max(rightmaxsubarray, crossingmaxsubarray));
		}
	}
	public int crossingsubarray(int array[],int low,int mid,int high)
	{
//		System.out.println("mid is "+mid);
		int leftsum = 0;
		int sumsofar = Integer.MIN_VALUE; 
		int sum = 0;
		for (int i = mid; i >= low; i--) 
		{
			sum += array[i];
			if((sum)> sumsofar)
				sumsofar = sum; 
		}
		leftsum = sumsofar;
		
		sumsofar = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid+1; i <= high; i++) 
		{
			sum += array[i];
			if((sum)> sumsofar)
				sumsofar = sum; 
		}
		//System.out.println("returning sum of "+ leftsum + " and "+ sum);
		return leftsum + sumsofar;
	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scan = new Scanner(new File("D:\\Documents\\Study win\\Java-Codes\\MaximumSubarray\\input.txt"));
		int size = scan.nextInt();
		int array[] = new int[size];
		for (int i = 0; i < array.length; i++) 
		{
			array[i] = scan.nextInt();
			//System.out.print(array[i] + " ");
		}
		
		maxSubarray subarray = new maxSubarray();
		System.out.println(subarray.divideandconquer(array, 0, array.length-1));
		scan.close();

	}

}
