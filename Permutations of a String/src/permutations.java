import java.util.Arrays;


public class permutations 
{
	public void swap(char array[],int index1,int index2)
	{
		char temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	public void permuteString(int index,char array[])
	{
		if (index==array.length -1 ) 
		{
			System.out.println(array);
		}
		else
		{

			for (int i = index; i < array.length; i++) 
			{
				swap(array, i, index);
				permuteString(index+1, array);
				swap(array, i, index);//backtracking here so no copy of the array is required
			}
		}
	}
	public static void main(String[] args) 
	{
		char array[] = {'A','B','C'};
		permutations permute = new permutations();
		permute.permuteString(0, array);

	}

}
