
public class CombinationLockDiv2 
{

	public int minimumMoves(String S, String T)
	{
		int present[] = new int[S.length()];
		int unlock[] = new int[S.length()];
		for(int i=0;i<S.length();i++)
		{
			present[i] = Character.getNumericValue(S.charAt(i));
			unlock[i] = Character.getNumericValue(T.charAt(i));
		}
		int moves[] = new int[S.length()];
		char direction[] = new char[S.length()];
		int moves = 0;
		while(true)
		{
			
		}
	}
	void statechart(int present[],int unlock[],int moves[],char direction[])
	{
		for (int i = 0; i < direction.length; i++) 
		{
			if(present[i]==unlock[i])
			{
				moves[i]=0;
				direction[i] = 'c';
			}
			else
			{
				int up = (present[i]-0) + (9-unlock[i]) +1;
				int down = unlock[i] - present[i];
				if(up>down)
				{
					direction[i] = 'u';
					moves[i] = up;
				}
				else
				{
					direction[i] = 'd';
					moves[i] = down;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
	

	}

}
