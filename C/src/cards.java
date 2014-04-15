import java.util.ArrayList;
import java.util.Arrays;


public class cards {

	int calls = 0;
	public int findways(int []array,int index)
	{
		calls++;
		//for(int i=0;i<array.length;i++)
		//	System.out.print(" " + array[i]);
		//System.out.println();
		//System.out.println("entered with index " + index);
		if(index==array.length)
		{
			return 1;
		}
		int count=0;
		int sum =0;
		for(int i=0;i<array.length;i++)
		{
			//System.out.println("iteration is " + i);
			if(array[i]==-1)
				continue;
			else if(array[i]!=index+1)
			{
				int []copy = new int[array.length];
				for(int j=0;j<copy.length;j++)
					copy[j] = array[j];
				count++;
				//System.out.println(" " + array[i] + " is taken ");
				copy[i] = -1;
				sum += findways(copy, index+1);
			}
			//System.out.println("count is " + count + " and sum is " + sum);
		}
		if(count==0)
			return 0;
		else
			return sum;
		
	}
	
	public static void main(String[] args) {
		int []array = {1,2,3,4,5};
		cards card = new cards();
		System.out.println(card.findways(array,0));
		System.out.println("calls is " + card.calls);
	}

}
