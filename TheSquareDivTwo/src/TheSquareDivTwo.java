import java.util.Arrays;

public class TheSquareDivTwo 
{
	public String[] solve(String[] board)
	{
		String result[] = new String[board.length];
		for (int i = 0; i < board.length; i++) 
		{
			board[i] = sortrow(board[i]);
		}
		for (int i = 0; i < board.length; i++) 
		{
			StringBuffer buffer =  new StringBuffer();
			for (int j = 0; j < board.length; j++)
			{
				buffer.append(board[j].charAt(i));
			}
			result[i] = buffer.toString();
		}
		return result;
	}
	public String sortrow(String row)
	{
		char temp[] = row.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}
	public static void main(String[] args) 
	{
		TheSquareDivTwo divTwo = new TheSquareDivTwo();
		String board[] = {"C.C..C.C..C..C.",
				 "CCC...C..CCC.C.",
				 "......CC...CCCC",
				 ".C..CC.C.C.C.C.",
				 "C....C.C......C",
				 ".....C..CCCCC.C",
				 "CCC.......CCCCC",
				 "..C.C..C.C...C.",
				 "CCC....CCC.CC..",
				 "CC.CCCC.CCCC...",
				 ".C..C.CC.C.CC.C",
				 "C.CCCC..CC..C.C",
				 ".CCCC.CCCCCC...",
				 "..C...C.CCC.CC.",
				 "CCCC..CCC.C...."};
		String result[] = divTwo.solve(board);
		for (int i = 0; i < result.length; i++) 
		{
			System.out.println(result[i]);
		}
		
		
	}

}
