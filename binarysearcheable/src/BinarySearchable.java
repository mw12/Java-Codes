
public class BinarySearchable {

	
	public int howMany(int[] sequence)
	{
		
		int count = 0;
		int temp;
		for(int i=0;i<sequence.length;i++)
		{
			temp = 0;
			for(int j=0;j<i;j++)
			{
				
				if(sequence[j]>sequence[i])
					{
						temp = 1;
						break;
					}
			}
			for(int k=i+1;k<sequence.length;k++)
			{
				if(sequence[k]<sequence[i])
				{
					temp = 1;
					break;
				}
			}
			if(temp==0)
			count++;
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
	
		BinarySearchable binarySearchable = new BinarySearchable();
		int sequence[] = { 1, 3, 2, 4, 5, 7, 6, 8 }	;
		binarySearchable.howMany(sequence);

	}

}
