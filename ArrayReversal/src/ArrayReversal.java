
public class ArrayReversal 
{
	public void reverse(int array[],int index,int value)
	{
		if(index==array.length-1)
		{
			array[array.length-1-index] = array[index];
		}
		else
		{
			reverse(array, index + 1,array[index+1]);
			array[array.length-1-index] = value;
		}
	}
	public static void main(String[] args) 
	{
		int array[] = {1,2,3,4,5};
		ArrayReversal arrayReversal = new ArrayReversal();
		arrayReversal.reverse(array, 0,array[0]);
		for (int i = 0; i < array.length; i++) 
		{
			System.out.println(array[i] + " ");	
		}

	}

}
