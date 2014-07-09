import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class binarySearch 
{
	public boolean search(int array[],int key)
	{
		int low = 0;
		int high = array.length -1;
		int mid;
		while(true)
		{
			
			mid = low + (high-low) / 2;
			System.out.println("mid is "+ mid);
			if(key==array[mid])
			{
				System.out.println("found at position " + mid);
				return true;
			}
			else if(key>array[mid])//right
			{
				low = mid+1;
			}
			else
				high = mid-1;
			
			if((high-low )<0)
				return false;
		}
		
	}

	public static void main(String[] args) 
	{
		System.out.println("enter the numbers to sorts");
		Scanner scan;
		int length;
		try 
		{
			scan = new Scanner(new File("D:\\Documents\\Study win\\Java-Codes\\binarySearch\\input.txt"));
			int key = scan.nextInt();
			length = scan.nextInt();
			System.out.println("the key is " + key);
			int array[] = new int[length];
			int index = 0;
			
			while(scan.hasNextInt())
			{
				array[index] = scan.nextInt();
				index++;
			}
			for (int i = 0; i < array.length; i++) 
			{
				System.out.println(array[i] + " ");
			}
			binarySearch binary = new binarySearch();
			System.out.println(binary.search(array, key));
			
			scan.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}


	}

}
