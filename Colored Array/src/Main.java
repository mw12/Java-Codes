import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public int maxpossiblepoints(int paints[],int gain[][],int cost[][],int repaintsallowed)
	{
		boolean morepossible = true;
		ArrayList<Integer> bestrepanints = bestrepaint(paints, cost, gain);
//		Iterator<Integer> rep = bestrepanints.iterator();
//		while(rep.hasNext())
//		{
//			System.out.print(rep.next() + " ");
//		}
		int increment = 0;
		while(repaintsallowed >0 && morepossible)
		{
			//System.out.println("repaits allowed are "+repaintsallowed);
			int max = 0;
			Iterator<Integer> iter = bestrepanints.iterator();
			int i = 0;
			int index =0;
			while(iter.hasNext())
			{
				int temp =iter.next(); 
				if( temp > max)
				{
					max = temp;
					index = i;
				}
				i++;
			}
			if(max ==0)
			{
				morepossible = false;
			}
			else
			{
				//System.out.println("max is "+ max);
				repaintsallowed --;
				//System.out.println("subtracting " + gain[index][paints[index]-1]);
				increment += max - gain[index][paints[index]-1];
				bestrepanints.remove(index);
			}
		}
		
		return increment + getcurrentvalue(paints, gain);
	}
	public int getcurrentvalue(int paints[],int gain[][])
	{
		int value =0;
		for (int i = 0; i < paints.length; i++) 
		{
			value += gain[i][paints[i]-1];
		}
		//System.out.println("returnng current as " + value);
		return value;
	}
	public ArrayList<Integer> bestrepaint(int paints[],int cost[][],int gain[][])
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < paints.length; i++) 
		{
			temp.add(getbestdeal(gain[i], cost[i],gain[i][paints[i]-1]));
		}
		return temp;
	}
	public int getbestdeal(int gain[],int cost[],int current)
	{
		int max = 0;
		for (int i = 0; i < cost.length; i++) 
		{
			if(cost[i]!=0)
			{
				if(gain[i]-current > cost[i] && gain[i]-current>max)
				{
					max = gain[i]-cost[i];
				}
			}
		}
		return max;
	}
	public static void main(String[] args) 
	{
		Main mn = new Main();
		Scanner scan = new Scanner(System.in);
		int nooftestcases = scan.nextInt();
		while(nooftestcases-- >0)
		{
			int noofhouses = scan.nextInt();
			int noofcolors = scan.nextInt();
			int repaintsallowed = scan.nextInt();
			
			int paints[] = new int[noofhouses];
			for(int i=0;i<noofhouses;i++)
			{
				paints[i] = scan.nextInt();
			}
			int gain[][] = new int[noofhouses][noofcolors];
			for (int i = 0; i < gain.length; i++) 
			{
				for (int j = 0; j < gain[i].length; j++) 
				{
					gain[i][j] = scan.nextInt();
				}
			}
			int cost[][] = new int[noofhouses][noofcolors];
			for (int i = 0; i < cost.length; i++) 
			{
				for (int j = 0; j < cost[i].length; j++) 
				{
					cost[i][j] = scan.nextInt();
				}
			}
			System.out.println(mn.maxpossiblepoints(paints, gain, cost, repaintsallowed));
		}
		scan.close();
	}
}
