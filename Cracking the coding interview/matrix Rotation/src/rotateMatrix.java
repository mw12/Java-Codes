public class rotateMatrix 
{
	
	public void rotate(int matrix[][])//square matrix
	{
		int end = matrix.length-1;
		int start = 0;
		for (int i = 0; i < matrix.length/2; i++) 
		{
			int saved;
			for(int offset=0;offset<end-start;offset++)
			{
				saved = matrix[start+offset][start];//left saved here
				System.out.println(saved);
				
				matrix[start+offset][start] = matrix[end][start+offset];//bottom->left
				
				matrix[end][start+offset] = matrix[end-offset][end];//right->bottom
				
				matrix[end-offset][end] = matrix[start][end-offset];//top->right
				
				matrix[start][end-offset] = saved;//saved->top
				
				
			}
			printmatrix(matrix);
			start++;
			end--;
		}
	}

	public static void printmatrix(int [][]matrix)
	{
		for (int i = 0; i < matrix.length; i++) 
		{
			for (int j = 0; j < matrix[0].length; j++) 
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		int matrix[][] = new int[5][5];
		matrix[0] = new int[]{1,2,3,4,5};
		matrix[1] = new int[]{6,7,8,9,10};
		matrix[2] = new int[]{11,12,13,14,15};
		matrix[3] = new int[]{16,17,18,19,20};
		matrix[4] = new int[]{21,22,23,24,25};
		printmatrix(matrix);
		new rotateMatrix().rotate(matrix);
		System.out.println("\nthe rotated matrix is");
		printmatrix(matrix);
		

	}

}
