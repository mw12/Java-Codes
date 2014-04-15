public class bulbs {

	public int findmax(char [][]matrix,int rows,int turns)
	{
		if(turns==0)
			return countbulbs(matrix);
		else
		{
			int max = 0;
			for(int i=0;i<rows;i++)
			{
				char [][]comatrix = new char[matrix.length][matrix[0].length];
				//System.out.println("afsa " + comatrix.length);
				for(int k=0;k<matrix.length;k++)
				{
					for(int j=0;j<matrix[k].length;j++)
						comatrix[k][j]=matrix[k][j];
				}
				int temp = findmax(findbulbs(comatrix,i),rows,turns-1);
				if(max<temp)
					max = temp;
			}
			return max;
			
		}
		
	}
	public char[][] findbulbs(char [][]matrix,int row)
	{
			//System.out.println("here");
			for(int j=0;j<matrix[row].length;j++)
				{
				if(matrix[row][j]=='*')
					matrix[row][j]='.';
				
				else
					matrix[row][j]='*';
				}
						
		
		return matrix;
	}
	public int countbulbs(char [][]matrix)
	{
		System.out.println("there");
		int count=0;
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
				if(matrix[i][j]=='*')
					count++;
		}
		return count;
	}
	public static void main(String[] args) {
		
		bulbs bulb = new bulbs();
		
		char matrix[][] = {{'.','.'},{'*','*'}};
		System.out.println(bulb.findmax(matrix,matrix.length,1));
	}

}
