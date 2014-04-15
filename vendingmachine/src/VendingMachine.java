import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
/*
 * 
 */
public class VendingMachine 
{
	public int motorUse(String[] prices, String[] purchases)	{
		int [] columns = new int[purchases.length];//fjor getting columns in it
		int shelf[] = new int[purchases.length];
		int time[] = new int[purchases.length];
		int tokens =0 ;//for matrix no of columns
		StringTokenizer tk = new StringTokenizer(prices[0]," ");//for tokens
		while(tk.hasMoreTokens())
		{
			tk.nextToken();
			tokens++;
		}
		int[][]  abc= new int[prices.length][tokens];//matrix to store
		for(int i=0;i<prices.length;i++)//store values
		{
			StringTokenizer tk1 = new StringTokenizer(prices[i]," ");
			for(int j =0;j<tokens;j++)
					abc[i][j] = Integer.parseInt(tk1.nextToken());
		}
		calculate(purchases,shelf,columns,time);
		//System.out.println(countrotations(abc, shelf,columns,time,prices.length,tokens));
		return countrotations(abc, shelf,columns,time,prices.length,tokens);
	}
	public int countrotations(int[][] abc,int shelf[],int column[],int time[],int rows,int columns)
{
		int seconds = 0;
		int currentcol;
		int near = 0;
		currentcol = findmaxcol(abc,rows,columns);
		seconds += timetoreach(0,currentcol,columns);//to add the initial rotations for starting with expensive
		
		for(int i=0;i<time.length;i++)
		{
			
			if(i==0)
					seconds+= timetoreach(currentcol,column[i], columns);
			else
			{
					if(time[i]-time[i-1]>=5)
					{
						near = findmaxcol(abc, rows, columns);
						seconds += timetoreach(column[i-1],near, columns) + timetoreach(near,column[i],columns);
					}
					else
						seconds += timetoreach(column[i-1],column[i], columns);
					if(i==time.length-1)//special case for the last index as return to most expensive
					{
						if(abc[shelf[i]][column[i]]==0)
							return -1;
						else
							abc[shelf[i]][column[i]] = 0;
						seconds+= timetoreach(column[i],findmaxcol(abc, rows, columns), columns);
						break;//so that -1 is not returned everytime
					}	
				
			}
			if(abc[shelf[i]][column[i]]==0)
				return -1;
			else
				abc[shelf[i]][column[i]] = 0;
		}
		return seconds;
	}
	public int timetoreach(int current,int to,int columns)
	{
		if(current>to)
			return Math.min(current-to,columns-current+to);
		else
			return Math.min(to-current,columns-to+current); 
	}
	public void calculate(String purchase[],int shelf[],int columns[],int time[])//calculates the time shelf and columns array
	{
		for(int i=0;i<purchase.length;i++)
		{
			StringTokenizer st =new StringTokenizer(purchase[i],",");
			while(st.hasMoreTokens())
			{
				shelf[i] = Integer.parseInt(st.nextToken());
				StringTokenizer tk = new StringTokenizer(st.nextToken(),":");
				columns[i] = Integer.parseInt(tk.nextToken());
				time[i] = Integer.parseInt(tk.nextToken());
				
			}
		}
	}
	public int findmaxcol(int abc[][],int rows,int columns)
	{
		int previous = 0;
		int flag = 0;
		for(int i=0;i<columns;i++)
		{
			int sum=0;
			for(int j=0;j<rows;j++)
					sum += abc[j][i];
			if(sum>previous)
				flag = i;
			previous = Math.max(sum,previous);
		}
		return flag;
	}
	public static void main(String[] args) {
		String prices[] ={"100 200 300",
		 "600 500 400"};
		String purchases[] ={"0,0:0", "1,1:10", "1,2:20",
				 "0,1:21", "1,0:22", "0,2:35"};
		VendingMachine vm = new VendingMachine();
		vm.motorUse(prices, purchases);
	}
}
