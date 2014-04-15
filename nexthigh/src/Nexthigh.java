import java.util.ArrayList;
import java.util.Collections;
/*
 * given a number in the form of an array you need to use those digits only and 
 * get the next highest number possible
 */

public class Nexthigh {


	public int[] getnexthigh(int array[],int index)
	{
		if(array.length-1==index)
			return array;
		if(array.length-2==index)
		{
			System.out.println("in index ==2");
			if(array[index]<array[index+1])
			{
				//swapping numbers in place
				array[index] = array[index] + array[index+1];
				array[index+1] = array[index] - array[index+1];
				array[index] = array[index] - array[index+1];
				
				return array;
			}
			else
				return (new int[0]);
		}
		else
		{
			int temp[] = getnexthigh(array, index+1); 
		
			if(temp.length==0)
			{
				int temp1[] = checkhigh(array,index);
					return temp1;
			}
			else
			{
				return array;
			}
		}
	}
	public int[] checkhigh(int array[],int index)
	{
		int count = 0;
		int found=0;
		int max = 1000;
		for(int i=index;i<array.length;i++)
		{
			if(array[i]>array[index] && array[i]<max)
			{
				max = array[i];
				found  = i;
			}
		}
		if(max==1000)
			return (new int[0]);
		else
			return modarray(array, index,found);
		
		
	}
	public int[] modarray(int array[],int index,int indexfound)
	{
		System.out.println("here");
		ArrayList<Integer> so = new ArrayList<Integer>();
		for(int i=index;i<array.length;i++)
		{
			if(i==indexfound)
				continue;
			so.add(array[i]);
		}
		Collections.sort(so);
		int j=0;
		array[index] = array[indexfound];
		for(int i=index+1;i<array.length;i++,j++)
			array[i]=so.get(j);
		
		return array;
	}
	public static void main(String[] args) {

		Nexthigh nexthigh = new Nexthigh();
		int array[] = {4,9,8,7,6,5,4,3,2,1};
		int result[] = nexthigh.getnexthigh(array,0);
		if(result.length==0)
			System.out.println("empty array");
		else
			for(int i=0;i<result.length;i++)
			System.out.print(" " + array[i]);
		

	}

}
