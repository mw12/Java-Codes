
public class LongdecSeq 
{

	int maxglobal  = 1;
	public int LDS(int array[],int index)//sequence that starts at the index 
	{
		if(index == (array.length-1))
			return 1;
		else
		{
			int length = 1;
			for (int i = index+1; i < array.length; i++) 
			{
				int temp = 1 + LDS(array,i);
				if(array[i]<array[index])
				{
					if(temp > length)
						length = temp;
				}
			}
			
			if(length > maxglobal)
				maxglobal = length;
			return length;
		}
	
	}
	
	public static void main(String[] args) 
	{
		LongdecSeq longdecSeq = new LongdecSeq();
		int array[] = {3,10,7,6};
		longdecSeq.LDS(array, 0);
		System.out.println("the longest decreasing sequence is  of length " + longdecSeq.maxglobal);

	}

}
