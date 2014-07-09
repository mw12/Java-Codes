import java.util.ArrayList;
public class PartitionProblem 
{
	int arraysum  = 0;
	ArrayList<Integer> numberlist = null;
	boolean ispossible(int array[],int index,int sum,ArrayList<Integer> numbers)
	{
		if(sum == 0)
		{
			numberlist = numbers;
			return true;
		}
		if(index == array.length)
			return false;
		else
		{
			ArrayList<Integer> temp = new ArrayList<Integer>(numbers);
			temp.add(array[index]);
			
			return ispossible(array, index+1, sum,numbers) || ispossible(array, index+1, sum - array[index],temp);
		}
	}
	int minimumdifference(int array[],int index,int sum)
	{
		if(index==array.length)
			return Math.abs(arraysum - (2*sum));
		else
		{
			return Math.min(minimumdifference(array, index+1, sum), minimumdifference(array, index+1, sum+array[index]));
		}
	}
	int sum(int array[])
	{
		int sum = 0;
		for (int i = 0; i < array.length; i++) 
		{
			sum += array[i];
		}
		return sum;
	}
	public static void main(String[] args) 
	{
		int array[] = {11,1,5,5};
		PartitionProblem partitionProblem = new PartitionProblem();
		int sum = partitionProblem.sum(array);
		partitionProblem.arraysum = sum;
		System.out.println("the mindiff is  " + partitionProblem.minimumdifference(array, 0, 0));
		if((sum % 2)==0)//even
		{
			System.out.println(partitionProblem.ispossible(array, 0, sum/2,new ArrayList<Integer>()));
			System.out.println(partitionProblem.numberlist);
		}
		else
		{
			System.out.println("not possible");
		}

	}

}
