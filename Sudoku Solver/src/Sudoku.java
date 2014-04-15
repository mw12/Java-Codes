import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sudoku 
{
	private int length;
	private boolean solutionfound = false;	
	public boolean isSolutionfound() {
		return solutionfound;
	}
	public void setSolutionfound(boolean solutionfound) {
		this.solutionfound = solutionfound;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void solve(int cells[][],int row,int column)
	{
		
		if(row<cells.length && column<cells.length)
		{
			
			if(cells[row][column]==-1 )//|| cells[row][column]==-1)
			{
				
				for (int j2 = 0; j2 < cells.length; j2++) //number trying to insert
				{
					
					if(issafe(cells,row,column,j2+1))
					{
						int copied[][] = this.copysudoku(cells);
						copied[row][column] = j2+1;
						//System.out.println("here for row " + row + " col " + column);
						//System.out.println("safe for " + (j2+1));
						
						if(column==cells.length-1)
						{
							if(row==cells.length-1)//end of the solution
							{
								System.out.println("printing sudoku as I found solution");
								printsudoku(copied);
								this.setSolutionfound(true);
								
							}
							else//boundary condition
							{
								//System.out.println("boundary condition");
								solve(copied, row+1,0);
							}
								
						}
						else//normal condition
						{
							solve(copied, row, column+1);
						}
							
						
					}
					if(solutionfound)
					{
						break;
					}
				}
			}
			else
			{
				if(column==cells.length-1)
				{
					
					if(row==cells.length-1)
						{
						System.out.println("printing sudoku as I found solution");
						this.setSolutionfound(true);
						printsudoku(cells);
						}
					else
						solve(cells, row+1, 0);
				}
				else
				{
					solve(cells, row, column+1);
				}
			}
		}
		
	}
	public void printsudoku(int cells[][]) 
	{
		for (int i = 0; i < cells.length; i++) 
		{
			for (int j = 0; j < cells.length; j++) 
			{
				System.out.print(cells[i][j] + " ");
			}
			System.out.println();
		}
	}
	public int[][] copysudoku(int cells[][])
	{
		int temp[][] = new int[cells.length][cells.length];
		for (int i = 0; i < cells.length; i++) 
		{
			for (int j = 0; j < cells.length; j++) 
			{
				temp[i][j] = cells[i][j];
			}
		}
		return temp;
	}
	public boolean issafe(int[][] cells,int row,int column,int number)
	{
		for (int i = 0; i < cells.length; i++) 
		{
			if(cells[row][i]==number)
			{
				return false;
			}
		}
		for (int i = 0; i < cells.length; i++) 
		{
			if(cells[i][column]==number)
			{
				return false;
			}
		}
		for (int i = 0; i < cells.length; i++) 
		{
			int sqrtlength = (int)Math.sqrt(cells.length);
			int rowindex = (row /sqrtlength) * sqrtlength;
			int columnindex = (column/sqrtlength)*sqrtlength;
			for (int j = 0; j < sqrtlength; j++) 
			{
				for (int j1 = 0; j1 < sqrtlength; j1++) 
				{
					if(cells[rowindex + j][columnindex + j1] == number)
					{
						return false;
					}
				}
			}
		}	
		return true;
	}
	public static void main(String[] args) throws IOException
	{
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Please enter the no of rows of your soduku");
//		System.out.println("please enter the sudoku entries now row by row");
//		System.out.println("if the cell is empty then please enter -1 in it");
		
		
		File file = new File ("/home/sahil/input.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String newline;
		while ((newline = bufferedReader.readLine()) != null) 
		{
		    stringBuffer.append(newline);  
		}
		fileReader.close();
		String data = stringBuffer.toString();
		//System.out.println(data);
 		
		
		Sudoku sudoku =  new Sudoku();
		System.out.println("Welcome to sudoku solver");
		StringTokenizer scan =  new StringTokenizer(data," ");
		String temp = scan.nextToken();
		//System.out.println("read " + temp);
		sudoku.setLength(Integer.parseInt(temp));
		int cells[][] = new int[sudoku.getLength()][sudoku.getLength()];
		
		for(int i=0;i<sudoku.getLength();i++)
		{
			for(int j=0;j<sudoku.getLength();j++) 
			{
				cells[i][j] = Integer.parseInt(scan.nextToken());
			}
		}
		sudoku.solve(cells, 0, 0);
//		scan.close();
		
		
		
	}

}
