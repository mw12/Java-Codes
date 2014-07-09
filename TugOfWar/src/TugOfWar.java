
public class TugOfWar 
{

	int arraysum = 0;
	int minimumdiff(int array[],int index,int sum,int elements)
	{
		if((elements > Math.ceil(array.length/2)))//backtracking step..
		{
			return Integer.MAX_VALUE;
		}
		if(index==array.length )
		{
			if(elements == array.length/2 || (array.length-elements==(array.length/2)))
				return Math.abs(arraysum - (2*sum));
			else
			{
				return Integer.MAX_VALUE;
			}
		}
		else
		{
			return Math.min
					(
						minimumdiff(array, index+1, sum, elements),
						minimumdiff(array, index+1, sum + array[index], elements+1)
					);
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
		TugOfWar ofWar = new TugOfWar();
		int array[] =  {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		ofWar.arraysum = ofWar.sum(array);
		System.out.println("the min with constraint is " + ofWar.minimumdiff(array, 0, 0, 0));
	}
}
