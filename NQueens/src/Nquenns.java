import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Nquenns 
{
	private int noofqueens = 0;
	private int noOfSolutions = 0;
	private boolean solutionfound;
	
	public int getNoOfSolutions() {
		return noOfSolutions;
	}
	public void setNoOfSolutions(int noOfSolutions) {
		this.noOfSolutions = noOfSolutions;
	}
	public int getNoofqueens() {
		return noofqueens;
	}
	public void setNoofqueens(int noofqueens) {
		this.noofqueens = noofqueens;
	}
	public boolean isSolutionfound() {
		return solutionfound;
	}
	public void setSolutionfound(boolean solutionfound) {
		this.solutionfound = solutionfound;
	}
	public Boolean isSafePosition(int row,int column,List<Integer> positions)
	{
		//System.out.println("called for column no " + column);
		Iterator<Integer> iter  = positions.iterator();
		int index=0;
		while(iter.hasNext())
		{
			int temp = iter.next();
			if(temp== column || Math.abs(row-index)==Math.abs(column-temp))
			{
				return false;
			}
			index++;
		}
		//System.out.println("returning true");
		return true;
	}
	public boolean isthreecoinciding(int row,int column,List<Integer> positions)
	{
		if(positions.size()<2)
		{
			return false;
		}
		else
		{
			for(int i=0;i<positions.size()-1;i++)
			{
				List<Float> equation = getlineequation(positions.get(i),i,column,row);
				for(int j=i+1;j<positions.size();j++)
				{
					
					if(j == (equation.get(0)*positions.get(j))+equation.get(1))// linear points
					{
						//System.out.println("mx is "+ (equation.get(0)*positions.get(j))+ " fasf " +equation.get(1));
//						Iterator<Integer> iter = positions.iterator();
//						while(iter.hasNext())
//						{
//							System.out.print(iter.next() + " ");
//						}
//						System.out.print(column + " ");
//						System.out.println("<- coinciding");
						return true;
					}
				}
			}
			return false;
		}
	}
	public List<Float> getlineequation(int x1,int y1,int x2,int y2)
	{
		//System.out.println(x1 + "," + y1 +" and " + x2 + ","+ y2 );
//		System.out.println("y2 - y1 is " + (y2-y1) + " and x2-x1 is " + (x2-x1));
		List<Float> parameters = new ArrayList<Float>();
		float m = (float)(y2-y1)/(x2-x1);
		float c = y1 -m*x1;
		//System.out.println("slope is " + m + " and c is " + c);
		parameters.add(m);
		parameters.add(c);
		return parameters;
	}
	public Boolean ismodifiedSafePosition(int row,int column,List<Integer> positions)
	{
		//System.out.println( "called for column no " + column + " row " + row );
		Iterator<Integer> iter  = positions.iterator();
		int index=0;
		while(iter.hasNext())
		{
			int temp = iter.next();
			if(temp== column)
			{
				//System.out.println("same column");
				return false;
			}	
			if(Math.abs(row-index)==Math.abs(column-temp))
			{
				//System.out.println("same diagonal");
				return false;
			}	
			
			index++;
		}
		//System.out.println("checking line");
		if(isthreecoinciding(row,column,positions))
		{
			
			return false;
		}
		//System.out.println("returning true");
		return true;
	}
	public void printpostions(int row,ArrayList<Integer> positions)
	{
		if(row < getNoofqueens())
		{
			//System.out.println("row is " + row);
			Boolean anysafeposition = false;
			for(int column=0;column<getNoofqueens();column++)
			{
				if(isSafePosition(row, column, positions))
				{
					anysafeposition = true;
					if(row==getNoofqueens()-1)
					{
						setNoOfSolutions(getNoOfSolutions()+1);
						Iterator<Integer> iter = positions.iterator();
						while(iter.hasNext())
						{
							System.out.print(iter.next() + " ");
						}
						System.out.print(column + "\n");
						return;
					}
					ArrayList<Integer> deepcopy = new ArrayList<Integer>(positions);
					deepcopy.add(column);
					//System.out.println("column is " + column);
					printpostions(row+1, deepcopy);
				}
			}
			if(anysafeposition==false)
			{
				//System.out.println("backtracking");
				return;
			}
		}
	}
	
	public void getfirstvalidposition(int row,ArrayList<Integer> positions)
	{
		if(row < getNoofqueens())
		{
			for(int column=0;column<getNoofqueens();column++)
			{
				//System.out.println("row is " + row + " column is "+ column);
				if(ismodifiedSafePosition(row, column, positions))
				{
					if(row==getNoofqueens()-1)
					{
						Iterator<Integer> iter = positions.iterator();
						while(iter.hasNext())
						{
							System.out.print(iter.next() + " ");
						}
						System.out.print(column + "\n");
						setSolutionfound(true);
						//System.out.println("returning from row as "+ row + " and column as "+ column);
						return;
					}
					ArrayList<Integer> deepcopy = new ArrayList<Integer>(positions);
					deepcopy.add(column);
					getfirstvalidposition(row+1, deepcopy);
					if(solutionfound)
					{
						//System.out.println("returning from row as "+ row + " and column as "+ column);
						return;
					}
						
				}
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		Nquenns q = new Nquenns();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(N);
		q.setNoofqueens(N);
		q.getfirstvalidposition(0, new ArrayList<Integer>());
		
		

	}

}
