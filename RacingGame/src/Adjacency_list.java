
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Adjacency_list 
{
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
	
	//utility functions
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
					{
					System.out.print(Edge.getData() + " ");
					System.out.print(Edge.getCost());
					}
				else
				{
					System.out.print(Edge.getData() + " " +  Edge.getCost() +"->");
				}
				Edge = Edge.getNext();
			}
			if(temp.getLinkdown()==null)
				System.out.println();
			else
				System.out.print("\n|\n");
			temp = temp.getLinkdown();
		}
	}
	public void add(int from,int to,int cost)
	{
		vertices first = this.search(from); 
		if(first==null)
			first = this.addvertex(from);
		vertices second = this.search(to);
		if(second==null)
			second = this.addvertex(to);
		if(from==to)
			first.append(to,cost);
		else
		{
			List<Edge> temp = getconnections(from);
			Iterator<Edge> iter = temp.iterator();
			while(true)
			{
				if(iter.hasNext())
				{
					Edge da = iter.next(); 
					if(da.getData()==to)
					{
						if(da.getCost()>cost)
						{
							da.setCost(cost);
						}
						break;
					}
					
				}
				else
				{
					first.append(to,cost);//directed graph
					break;
				}
			}
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

	//specific functions
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
}

