
public class StandInLine {
	public int[] reconstruct(int[] left)
	{
	
		int result[] = new int[left.length];
		for(int i=left.length-1;i>=0;i--)
		{
			setinposition(i+1,left[i],result);
		}
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]);
		return result;
	}
	public void setinposition(int height,int taller,int []result)
	{
		int i=0;
		while(taller>0)
		{
			if(result[i]>height)
			{
				taller--;
				i++;
			}
		}
		shift(result,i,height);
			
	}
	public void shift(int result[],int location,int height)
	{
		for(int i=result.length-1;i>location;i--)
		{
			result[i] = result[i-1];
		}
		result[location] = height;
	}
	public static void main(String[] args) {
		StandInLine inLine = new StandInLine();
		int left[] = 	{4,1,0,0,2,0,0,2,1,0};
		inLine.reconstruct(left);

	}

}
