
public class Bellmanford 
{
	//Simple Relaxation wala
	/**
	 * initialize currdis(source) as 0 and all others as infinity
	 * for each in edge in the graph
	 * 		for i=1;i<|V| - 1;i++
	 * 		{
	 * 			if(weight(edge) + currentdistance(source of edge) 
	 * 				< 
	 * 			currentdistance(destination of edge)
	 * 			then update the values;
	 * 		} 
	 * 
	 */
	
	
	/**
	 * Iteratively DP wala
	 * int table[][] = new table[vertices][vertices];
	 * 
	 * row is the no of edges being used
	 * column is the destination vertex index
	 * initialize table :
	 * 	for each row
	 * 		if(column index == source vertex)
	 * 			place zero there table[row][0] = 0;
	 * 		else 
	 * 			place infinity there : table[row][0] = Integer.MaxValue;
	 * 
	 * for each row = 1 to max
	 *		for each vertex(column)
	 *		{
	 *			now each cell has to be updated such that it is the min of
	 *			one lesser edge already computed and
	 *			the min of all the weight of incident edges on the vertex +
	 *			the already computed distance of the source vertex of the incident edge
	 * 
	 *			table[row][column] =
	 *			Math.min
	 *			(
	 *				table[row-1][column],
	 *				Math.min
	 *				(
	 *					for all edge u-> currentvertex :
	 *						table[row-1][u] + wt(u->currvertex)
	 *				)
	 *			) 
	 *		}
	 *
	 *		now we have the table in which table[lastrow][any column] will 
	 *		have the shortest path from the given source		
	 *
	 *
	 */		
	
		
	/**
	 * Recursive wala DP // O(V * E) // table iteration only 
	 * 
	 * initialize table as before in iterative one 
	 * for all vertices:
	 * 	int shorestpath(vertex destination,int maxedgestobeused)
	 * {
	 * 		if(destination == source)
	 * 			return 0;
	 * 		if ( table[maxedgestobeused][destination] ! = -1)
	 * 			return that value;
	 * 		else
	 * 		{
	 * 			int dist = Math.min
	 * 			(
	 * 				shorestpath(destination,maxedgestobeused-1),
	 * 				Math.min
	 * 				(
	 * 					for all incident edges (u->destination)on the destination 
	 * 						shortestpath(u,maxedgestobeused-1) + wt(u->destination);
	 * 				)
	 * 			)
	 * 			table[maxedgestobeused][destination] = dist;
	 * 			return dist;
	 * 		}  
	 * }
	 */
	
	public static void main(String[] args) 
	{
	

	}
}
