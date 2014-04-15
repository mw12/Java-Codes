package undirected;

import java.util.Hashtable;
import java.util.Iterator;

public class Graph 
{
	public static void main(String[] args) 
	{
		
		Adjacency_list graph = new Adjacency_list();
		
		//peterson graph
		
		graph.add(1,2);
		graph.add(1,3);
		graph.add(1,6);
		graph.add(2,4);
		graph.add(2,7);
		graph.add(3,10);
		
		graph.add(3,5);
		graph.add(4,8);
		graph.add(4,5);
		graph.add(5,9);
		graph.add(6,8);
		graph.add(6,9);
		
		graph.add(7,9);
		graph.add(7,10);
		graph.add(8,10);
		
		//
		
		graph.display();
		Hashtable<vertices, String > a = new Hashtable<vertices,String>();
		Boolean result = graph.greedykchromatic(graph.getRandomVertex(),3,a);
		
		System.out.println("the result is "+ result);
		Iterator<vertices> iter = a.keySet().iterator();
		while(iter.hasNext())
		{
			vertices buffer = iter.next();
			System.out.print("vertex " + buffer.getData());
			System.out.println(" color " + a.get(buffer));
		}
//		System.out.println("breadth first search yields ");
//		graph.breadthfirstsearch();
//		System.out.println("depth first search yields ");
//		graph.depthfirstsearch(graph.getHead());
//		
//		try 
//		{
//			Iterator<Edge> iter = graph.getconnections(1).iterator();
//			System.out.println();
//			while(iter.hasNext())
//			{
//				System.out.print(iter.next().getData() + " ");
//			}
//		} 
//		catch (java.lang.NullPointerException e) 
//		{
//			
//			System.out.println("\nno key found for list display");
//		}
//		
		
		
		

	}
}
