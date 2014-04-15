
public class MagicalStringDiv2 {

	public int minimalMoves(String S)
	{
		int count =0;
		for (int i = 0; i < S.length(); i++) 
		{
			if(i<S.length()/2 && S.charAt(i)=='<')
			{
				count ++;
			}
			if(i>= S.length()/2 && S.charAt(i)=='>')
			{
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
