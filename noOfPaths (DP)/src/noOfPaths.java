
public class noOfPaths {

	static int calls=0;
	void initialize(int matrix[][])
	{
		for (int i = 0; i < matrix.length; i++) 
		{
			for (int j = 0; j < matrix[0].length; j++) 
			{
				matrix[i][j] = -1;
			}
		}
		matrix[matrix.length-1][matrix[0].length-1] = 1;
	}
	int countpaths(int matrix[][],int row,int column)
	{
		calls++;
		if(row == matrix.length || column==matrix[0].length)
			return 0;
		if(matrix[row][column]!=-1)
			return matrix[row][column];
		else
			matrix[row][column] = countpaths(matrix, row+1, column) + countpaths(matrix, row, column+1);
			return matrix[row][column];
	}
	public static void main(String[] args) 
	
	{
		noOfPaths paths = new noOfPaths();
		int matrix[][] = new int[3][3];
		paths.initialize(matrix);			
		System.out.println(paths.countpaths(matrix, 0, 0));
		System.out.println("calls are " + calls);
	}

}
