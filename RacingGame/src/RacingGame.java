import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RacingGame 
{
	
	public int mindistance(vertices source,vertices destination,Adjacency_list list,ArrayList<Integer> pathnodes,int flags[],boolean checked)
	{
		if(source==destination)
		{
			if (checked) 
			{
				//System.out.println("reached destination and checked .... !!");
				return 0;
			}
			else
			{
				//System.out.println("reached destination not checked");
				return Integer.MAX_VALUE;
			}
		}
		else
		{
			//System.out.println("looking for distance between " + source.getData() + " and  " + destination.getData());
			ArrayList<Edge> edges = (ArrayList<Edge>) list.getconnections(source.getData());
			Iterator<Edge> iter = edges.iterator();
			int min = Integer.MAX_VALUE;
			while(iter.hasNext())
			{
				
				Edge temp = iter.next();
				if (!pathnodes.contains(temp.getData())) 
				{ 
				
					ArrayList<Integer> pathtravelled = (ArrayList<Integer>) pathnodes.clone();
					pathtravelled.add(source.getData());
					int returned;
					if (checked)
					{
						returned = mindistance(list.search(temp.getData()), destination, list, pathtravelled,flags,true);
					}
					else if(flagscontain(flags,temp.getData()))
					{
						returned = mindistance(list.search(temp.getData()), destination, list, pathtravelled,flags,true);
					}
					else
						returned = mindistance(list.search(temp.getData()), destination, list, pathtravelled,flags,false);
					
					int distance;
					if(returned==Integer.MAX_VALUE)
						distance = returned; 
					else
						distance = temp.getCost() + returned; 
					//System.out.println("distance calculated is " + distance);
					if(distance < min)
					{
						min = distance; 
					}
				}
				else
				{
					//System.out.println("already travelled " + temp.getData());
				}
			}
			return min;
			
		}
	}
	public boolean flagscontain(int flags[],int key)
	{
		for (int i = 0; i < flags.length; i++) 
		{
			if(flags[i]==key)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		RacingGame game =  new RacingGame();
		Adjacency_list adjacency_list =  new Adjacency_list();
		File file = new File("input.txt");
		try 
		{
			Scanner scan = new Scanner(file);
			int noofplaces = scan.nextInt();
			int noofroads = scan.nextInt();
			int noofflags= scan.nextInt();
			int source = scan.nextInt();
			
			//describing roads
			int sources[]  = new int[noofroads];
			int destinations[]  = new int[noofroads];
			int costs[]  = new int[noofroads];
			for (int i = 0; i < destinations.length; i++) 
			{
				sources[i] = scan.nextInt();
				destinations[i] = scan.nextInt();
				costs[i] = scan.nextInt();
				adjacency_list.add(sources[i], destinations[i], costs[i]);
			}
			//check points in the race
			int flags[] = new int[noofflags]; 
			for (int i = 0; i < noofflags; i++) 
			{
				flags[i] = scan.nextInt();
			}
			
			//targets in race
			int nooftargets = scan.nextInt();
			int targets[] = new int[nooftargets];
			for (int i = 0; i < targets.length; i++) 
			{
				targets[i] = scan.nextInt();
			}
			adjacency_list.display();
			System.out.println(game.mindistance(adjacency_list.search(source), adjacency_list.search(3), adjacency_list, new ArrayList<Integer>(),flags,false));
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
