import java.util.Scanner;

public class Inna {
	
	public void takeinput(int coordinates[][],int x,int y)
	{
		coordinates[x][y] = 1;
	}
	public int minmoves(int coordinates[][])
	{
		int verticalmoves = 0;
		int horizontalmoves = 0;
		for (int i = 0; i < coordinates.length; i++) 
		{
			int horiup = 0;
			int vertiup = 0;
			for (int j = 0; j < coordinates.length; j++) 
			{
				if(coordinates[i][j]==1 && horiup==0)
				{
					horizontalmoves ++;
					horiup = 1;
					//break;
				}
				if(coordinates[j][i]==1 && vertiup==0)
				{
					verticalmoves++;
					vertiup=1;
				}
				if(horiup==1 && vertiup==1)
				{
					break;
				}
					
			}
		}
		return Math.min(verticalmoves, horizontalmoves);
	}
	public static void main(String[] args) 
	{
		Inna inna =  new Inna();
		int coordinates[][] =  new int[100][100];
		for (int i = 0; i < coordinates.length; i++) 
		{
			for (int j = 0; j < coordinates.length; j++) 
			{
				coordinates[i][j] = 0;
			}
		}
		Scanner scan =  new Scanner(System.in);
		int noofclocks = scan.nextInt();
		for (int i = 0; i < noofclocks; i++) 
		{
			inna.takeinput(coordinates, scan.nextInt(), scan.nextInt());
			
		}
		System.out.println("the minimum no of moves are "+ inna.minmoves(coordinates) );
		scan.close();
	}

}
