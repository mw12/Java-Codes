
public class SubsetSum 
{
	int targetsum = 9;
	boolean subsetexists(int array[],int index,int sum)
	{
		if(index==array.length)
			return false;
		else
		{
			if(sum+array[index]==targetsum)
				return true;
			else if(sum+array[index]>targetsum)
				return subsetexists(array, index+1, sum);
			else
				return subsetexists(array, index+1, sum) || subsetexists(array, index+1, sum+array[index]);
		}
	}
	int howmanysubsets(int array[],int index,int sum)
	{
		if(index==array.length)
			return 0;
		else
		{
			if(sum+array[index]==targetsum)
				return 1+ howmanysubsets(array, index+1, sum);
			else if((sum+array[index])> targetsum)
				return howmanysubsets(array, index+1, sum);
			else
				return howmanysubsets(array, index+1, sum) + howmanysubsets(array, index+1, sum+array[index]);
		}
	}
	void printmatrix(int matrix[][])
	{
		for (int i = 0; i < matrix.length; i++) 
		{
			for (int j = 0; j < matrix[0].length; j++) 
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	int iterativenoofsets(int array[])
	{
		int matrix[][] = new int [array.length+1][targetsum+1];
		for (int i = 0; i <=array.length; i++) 
		{
			matrix[i][0] = 1;
		}
		for (int i = 1; i <= targetsum; i++) 
		{
			matrix[array.length][i] = 0;
		}
		for (int index = array.length-1; index >= 0 ; index--) 
		{
			for (int sum = 1; sum <= targetsum; sum++) 
			{
				matrix[index][sum ] = matrix[index+1][sum];
				if((sum-array[index] )>= 0)
					matrix[index][sum] += matrix[index+1][sum-array[index]];
					
			}
		}
		return matrix[0][targetsum];
	}
	public static void main(String[] args) 
	{
		SubsetSum subsetSum = new SubsetSum();
		int array[] = { 7,2,5};
		//System.out.println(subsetSum.subsetexists(array, 0, 0));
		//System.out.println(subsetSum.howmanysubsets(array, 0, 0));
		System.out.println(subsetSum.iterativenoofsets(array));

	}

}
