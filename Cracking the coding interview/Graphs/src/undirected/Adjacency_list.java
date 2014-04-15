package undirected;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Adjacency_list 
{
	static String colors[] = {"red","green","blue","yellow","cyan","brown","black"};
	static ArrayList<Hashtable<vertices, String>> list = new ArrayList<Hashtable<vertices,String>>();
	private vertices head;
	Adjacency_list() 
	{
	 this.setHead(null);
	}
	Adjacency_list(int head)
	{
		this.setHead(new vertices(head));
	}
	public vertices getHead() 
	{
		return head;
	}
	public void setHead(vertices head) 
	{
		this.head = head;
	}
	public void display()
	{
		vertices temp = this.getHead();
		while(temp!=null)
		{
			System.out.print(temp.getData() + "->");
			Edge Edge = new Edge();
			Edge = temp.gethead();
			while(Edge!=null)
			{
				if(Edge.getNext()==null)
					System.out.print(Edge.getData());
				else
				System.out.print(Edge.getData() + "->");
				Edge = Edge.getNext();
			}
			if(temp.getLinkdown()==null)
				System.out.println();
			else
				System.out.print("\n|\n");
			temp = temp.getLinkdown();
		}
	}
	public void add(int from,int to)
	{
		vertices first = this.search(from); 
		if(first==null)
			first = this.addvertex(from);
		vertices second = this.search(to);
		if(second==null)
			second = this.addvertex(to);
		if(from==to)
			first.append(to);
		else
		{
			first.append(to);
			second.append(from);
		}
				
	}
	public vertices search(int key)
	{
		vertices temp = this.getHead();
		while(temp!=null)
		{
			if(temp.getData()==key)
			{
				return temp;
			}
			temp=temp.getLinkdown();
		}
		return null;
	}
	public vertices addvertex(int data)
	{
		vertices temp = this.getHead();
		if(temp==null)
		{
			this.setHead(new vertices(data));
			return this.getHead();
			
		}
		while(temp.getLinkdown()!=null)
		{
			temp = temp.getLinkdown();
		}
		temp.setLinkdown(new vertices(data));
		return temp.getLinkdown();
	}
	public List<Edge> getconnections(int key)
	{
		vertices vertex = this.search(key);
		if(vertex!=null)
		{
			List<Edge> li = new ArrayList<Edge>();
			Edge temp = vertex.gethead();
			while(temp!=null)
			{
				li.add(temp);
				temp = temp.getNext();
			}
			return li;
		}
		else
			return null;
	}
	public void breadthfirstsearch()
	{
		if(this.getHead()==null)
			return;
		LinkedList<vertices> q = new LinkedList<vertices>();
		q.add(this.getHead());
		
		while(q.size()!=0)
		{
			vertices current = q.removeFirst();
			current.setColor("gray");
			System.out.print(current.getData() + " ");
			Edge temp = current.gethead();
			while(temp!=null)
			{
				vertices connected = search(temp.getData()); 
				if(connected.getColor()=="white")
					{
					connected.setColor("gray");
					q.add(connected);
					}
				temp = temp.getNext();
			}
			current.setColor("black");
		}
	}
	public void depthfirstsearch(vertices vertex)
	{
		System.out.print(vertex.getData() + " ");
		vertex.setColor("gray");
		Edge temp = vertex.gethead();//head of the edge list
		while(temp!=null)
		{
			vertices connected = search(temp.getData());
			if(connected.getColor()=="white")
			{
				depthfirstsearch(connected);
			}
			temp = temp.getNext();
		}
		vertex.setColor("black");
	}
	public int getNoOfNodes()
	{
		vertices temp = this.getHead();
		int nodes =0;
		while(temp!=null)
		{
			nodes++;
			temp = temp.getLinkdown();
		}
		return nodes;
	}
	public ArrayList<vertices> getNodes()
	{
		ArrayList<vertices> temp = new ArrayList<vertices>();
		vertices tempvertex = this.getHead();
		while(tempvertex!=null)
		{
			temp.add(tempvertex);
			tempvertex = tempvertex.getLinkdown();
		}
		return temp;
	}
	public vertices getRandomVertex()
	{
		ArrayList<vertices> nodes = getNodes();
		return nodes.get((int) (Math.random() % nodes.size()));
	}
	
public Boolean greedykchromatic(vertices vertex,int noofcolors,Hashtable<vertices, String> current)
	{
	/*The problem is whether graph can be colored using k- colors such no two neighbours have the same color.
	 * This is NP - Complete problem
	 * Thus made here is a near optimal algorithm ( greedy )
	 */
		//System.out.println("called for "+ vertex.getData() );
		if(vertex==null)
		{
			System.out.println("empty graph");
			return true;
		}
		else
		{
			
			String safecolor = getSafecolor(vertex, noofcolors);
			//System.out.println("the color is "+ safecolor);
			if(!safecolor.equals("null"))
			{
				vertex.setColor(safecolor);
				current.put(vertex,safecolor);
				Edge edge = vertex.gethead();
				Boolean temp = true;
				while(edge!=null)
				{
					vertices neighbour = search(edge.getData());
					if(neighbour.getColor().equals("white"))
					{
						temp = greedykchromatic(neighbour, noofcolors,current);
						if(temp==false)
							return false;
					}
					edge = edge.getNext();
				}
				return true;
			}
			else
				return false;
		}
	}
	public String getSafecolor(vertices vertex,int noofcolors)
	{
		//System.out.println("here");
		int flag = 0;
		if(vertex.getData()==7)
			flag = 0;
		ArrayList<String> temp = new ArrayList<>();
		for(int i=0;i<colors.length;i++)
		{
			temp.add(colors[i]);
		}
		int coloredneighbours = 0;
		Edge edge = vertex.gethead();
		while(edge!=null)
		{
			
			String neighbourcolor = search(edge.getData()).getColor(); 
			if(!neighbourcolor.equals("white"))
			{
				if(temp.remove(neighbourcolor))
				coloredneighbours++;
			}
			if(flag==1)
				System.out.println("the neighbours are " + coloredneighbours);
			edge = edge.getNext();
			
		}
		if(coloredneighbours>=noofcolors)
			return "null";
		else
			return temp.get(0);
	}
	public Hashtable<vertices, String> deepcopy(Hashtable<vertices, String> current)
	{
		
		Iterator<vertices> iter = current.keySet().iterator();
		Hashtable<vertices,String> temp = new Hashtable<vertices,String>();
		while(iter.hasNext())
		{
			vertices buffer = iter.next();
			temp.put(buffer,current.get(buffer));
		}
		return temp;
	}
}

