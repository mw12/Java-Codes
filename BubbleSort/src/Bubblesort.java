import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bubblesort 
{
	public void sort(int array[])
	{
		boolean sorted;
		for (int i = 0; i < array.length-1; i++) 
		{
			sorted  = true;
			for (int j = 0; j < array.length-1-i; j++) 
			{
				if(array[j] > array[j+1])
				{
					sorted = false;
					
					array[j]= array[j]+array[j+1];
					array[j+1]= array[j]-array[j+1];
					array[j] = array[j]-array[j+1];
				}
			}
			if(sorted)
				break;
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("enter the numbers to sorts");
		Scanner scan;
		int length;
		try 
		{
			scan = new Scanner(new File("D:\\Documents\\Study win\\Java-Codes\\BubbleSort\\input"));
			length = scan.nextInt();
			System.out.println("the length is " + length);
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
			Bubblesort bubblesort = new Bubblesort();
			bubblesort.sort(array);
			for (int i = 0; i < array.length; i++) 
			{
				System.out.print(array[i] + " ");
			}
			
			scan.close();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
