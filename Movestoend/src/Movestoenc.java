
public class Movestoenc 
{
	public int DParray[] = new int[11];
	int calls = 0;
	Movestoenc()
	{
		for (int i = 0; i < DParray.length; i++) 
		{
			DParray[i] = -1;
		}
	}
	public int getminimummoves(int array[],int index)
	{
		calls++;
//		if(DParray[index]!=-1)
//			return DParray[index];
		
		if(index==array.length -1)
			return 0;
		else
		{
			int minmoves = Integer.MAX_VALUE;
			for (int i = 1; i <= array[index] && (index+i)<array.length; i++) 
			{
				int moves = 1 + getminimummoves(array, index+i);
				if(moves < minmoves)
					minmoves = moves;
			}
			DParray[index] = minmoves;
			return minmoves;
		}
	}
	public static void main(String[] args) 
	{
		int array[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		Movestoenc movestoenc = new Movestoenc();
		System.out.println("moves are " + movestoenc.getminimummoves(array, 0));
		System.out.println("calls are " + movestoenc.calls);

	}

}
