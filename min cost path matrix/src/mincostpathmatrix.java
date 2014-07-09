public class mincostpathmatrix 
{
	int destrow = 1;
	int destcol = 1;
	public int mincostpath(int matrix[][],int row,int column)
	{
		if(row>destrow || column>destcol)
			return Integer.MAX_VALUE;
		if(row==destrow && column==destcol)
			return matrix[row][column];
		else
		{
			return matrix[row][column] + 
			(
					Math.min
					(
							mincostpath(matrix, row+1, column),
							Math.min
							(
									mincostpath(matrix, row, column+1),
									mincostpath(matrix, row+1, column+1)
							)
					)
			);
		}
	}
	public static void main(String[] args) 
	{
		mincostpathmatrix mincost = new mincostpathmatrix();
		int matrix[][] = {{1,2,3},{4,8,2},{1,5,3}};
		System.out.println(mincost.mincostpath(matrix, 0, 0));

	}

}
