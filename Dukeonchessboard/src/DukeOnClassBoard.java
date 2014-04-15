import java.util.ArrayList;


public class DukeOnClassBoard {


	public String dukePath(int n, String initPosition)
	{
		char mapping[] = new char[n];
		int matrix[][] = new int[n][n];
				
		for (int i = 0; i < mapping.length; i++) 
		{
			mapping[i] = (char)(i+97);
		}
		ArrayList<String> arrayList  = new ArrayList<String>();
		arrayList.add(initPosition);
		boolean possible = true;
		int x = 4;
		String currposition = initPosition;
		while(possible)
		{
			x--;
			String nextposition = null;
			int currcol = (int)currposition.charAt(0)-97;
			int currrow = (int)currposition.charAt(1)-49;
			//System.out.println("currrow is "  + currrow + "currcol is " + currcol );
			//System.out.println(matrix.length);
			if(currcol<(matrix.length-1) && matrix[currrow][currcol+1]!=-1)//go right
			{
				
				//System.out.println("here in case 1");
				StringBuilder builder = new StringBuilder();
				builder.append(mapping[currcol +1]);
				builder.append(currrow+1);
				nextposition = builder.toString();
				currposition = nextposition;
				matrix[currrow][currcol] = -1;
				arrayList.add(nextposition);
				
			}
			else if(currrow<matrix.length-1 && matrix[currrow+1][currcol]!=-1)//go down
			{
				//System.out.println("here in case 2");
				StringBuilder builder = new StringBuilder();
				builder.append(mapping[currcol]);
				builder.append(currrow+2);
				nextposition = builder.toString();
				currposition = nextposition;
				matrix[currrow][currcol] = -1;
				arrayList.add(nextposition);
				
			}
			else if(currrow>0 && matrix[currrow-1][currcol]!=-1)//go up
			{
				//System.out.println("here in case 3");
				StringBuilder builder = new StringBuilder();
				builder.append(mapping[currcol]);
				builder.append(currrow);
				nextposition = builder.toString();
				currposition = nextposition;
				matrix[currrow][currcol] = -1;
				arrayList.add(nextposition);
			}
			else if(currcol>0 && matrix[currrow][currcol-1]!=-1)//go left
			{
				//System.out.println("here in case 4");
				StringBuilder builder = new StringBuilder();
				builder.append(mapping[currcol -1]);
				builder.append(currrow+1);
				nextposition = builder.toString();
				currposition = nextposition;
				matrix[currrow][currcol] = -1;
				arrayList.add(nextposition);
			}
			else
				possible = false;
			
		}
		
		if ((arrayList.size()*2 + arrayList.size()-1)<40) 
		{
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < arrayList.size(); i++) 
			{
				builder.append(arrayList.get(i));
				if (i!=arrayList.size()-1) {
					builder.append('-');
					
				}
			}
			return builder.toString();
		}
		else
		{
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 7; i++) 
			{
				builder.append(arrayList.get(i));
				if (i!=6) {
					builder.append('-');
					
				}
			}
			builder.append("...");
			for (int i = arrayList.size()-7; i<arrayList.size(); i++) 
			{
				builder.append(arrayList.get(i));
				if (i!=arrayList.size()-1) {
					builder.append('-');
					
				}
			}
			return builder.toString();	
		}
		
		
	}
	public static void main(String[] args) {
		DukeOnClassBoard board =  new DukeOnClassBoard();
		System.out.println(board.dukePath(3, "b2"));

	}

}
