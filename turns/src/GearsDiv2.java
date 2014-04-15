
public class GearsDiv2 {

	public int getmin(String Directions) 
	{
		int count = 0;
		int sequence[] = new int[Directions.length()];
		for(int i=0;i<Directions.length();i++)
		{
			if(Directions.charAt(i)=='L')
				sequence[i] = 1;
			else
				sequence[i] = 2;
		}
//		for(int i=0;i<sequence.length;i++)
//			System.out.println(sequence[i]);
		System.out.println(findmin(sequence, sequence.length,0,0));
		return count;
	}
	public int findmin(int sequence[],int length,int index,int last)
	{
		//System.out.println("index is " + index);
		if(index==sequence.length-1)
			{
				if(sequence[index]==sequence[0])			
					{
					//System.out.println("first and last are same and  returning " + length);
					return 1;
					}
				else
					{
					//System.out.println("sequenve af");
						if(last==0)
							return 0;
						else if(last==sequence[index])
							return 1;
						else return 0;
					}
			}
		else
		{
		
			if(sequence[index]==last)
			{
				//System.out.println("here");
				return 1+findmin(sequence, length, index+1, 0);
			}
			int []altered = new int[sequence.length];
			for(int i=0;i<sequence.length;i++)
				altered[i] = sequence[i];
			
				altered[index] = sequence[index];	
			//System.out.println("There");
				return Math.min(findmin(altered, length, index+1, sequence[index]),1+findmin(sequence, length, index+1, 0));
			
		}
	
	}
				

	
	public static void main(String[] args) {
	GearsDiv2 ob = new GearsDiv2();
	ob.getmin("RRRRRRRLRRRRRRRLRLRLLRLRLRLRRLRLRLLLRLRLLRLLRRLRRR");

	}

}
