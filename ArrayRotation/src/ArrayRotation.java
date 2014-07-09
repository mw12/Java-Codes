public class ArrayRotation 
{
	public void rotatearray(int array[])
	{
		int index = array.length-2;
		while(index >= 0)
		{
			array[index] = array[array.length -1] + array[index];
			array[array.length -1] =  array[index] - array[array.length -1];
			array[index] = array[index] - array[array.length -1];
			index--;
		}
	}
	public static void main(String[] args) 
	{
		int array[] = {1,2,3,4,5};
		ArrayRotation arrayRotation =  new ArrayRotation();
		arrayRotation.rotatearray(array);
		for (int i = 0; i < array.length; i++) 
		{
			System.out.println(array[i ] + " ");
		}

	}

}
