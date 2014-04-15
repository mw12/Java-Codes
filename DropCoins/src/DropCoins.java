
public class DropCoins {

	public int getMinimum(String[] board, int K)
	{
		int result = java.lang.Integer.MAX_VALUE;
		int rows = board.length;
		int columns = board[0].length();
		for (int i = 0; i < board.length; i++) 
		{
			for (int j = i; j < board.length; j++) 
			{
				for (int j2 = 0; j2 < board[0].length(); j2++) 
				{
					for (int l = j2; l < board[0].length(); l++) 
					{
						int count=0;
						for (int l2 =i; l2 <=j; l2++) 
						{
							for (int m = j2; m <=l; m++) 
							{
								if (board[l2].charAt(m)=='o') {
									count++;
								}
							}
						}
						if (count==K)
						{
							int top = i;
							int bottom = rows-j-1;
							int left = j2;
							int right = columns-l-1;
							
							result = Math.min(result, top+bottom+left+right + Math.min(top, bottom) + Math.min(left, right));
						}
						
					}
					
					
				}
			}
		}
		if (result==java.lang.Integer.MAX_VALUE) {
			return -1;
		}
		else
			return result;
		
		
	}
	public static void main(String[] args) {

		DropCoins coins =  new DropCoins();
		int K = 58;
		String [] board = {"................."
				,".ooooooo...oooo.."
				,".ooooooo..oooooo."
				,".oo.......oo..oo."
				,".oo.......oo..oo."
				,".ooooo.....oooo.."
				,".ooooooo...oooo.."
				,".....ooo..oo..oo."
				,"......oo..oo..oo."
				,".ooooooo..oooooo."
				,".oooooo....oooo.."
				,"................."};
		System.out.println(coins.getMinimum(board, K));
	}

}
