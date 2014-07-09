import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class selectionsort 
{
	public void sort(int array[])
	{
		for (int i = 0; i < array.length-1; i++) 
		{
			int minindex = i;
			for (int j = i; j < array.length; j++) 
			{
				if(array[j]<array[minindex])
				{
					minindex = j;
				}
			}
			if(minindex!=i)
			{
				array[minindex]= array[minindex]+array[i];
				array[i]= array[minindex]-array[i];
				array[minindex] = array[minindex]-array[i];
			}
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("enter the numbers to sorts");
		Scanner scan;
		int length;
		try 
		{
			scan = new Scanner(new File("D:\\Documents\\Study win\\Java-Codes\\SelectionSort\\input.txt"));
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
			selectionsort selectionsort = new selectionsort();
			selectionsort.sort(array);
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
