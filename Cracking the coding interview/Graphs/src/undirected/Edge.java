package undirected;

public class Edge 
{
	private int data;
	private Edge next;
	Edge()
	{
		this.data = 0;
		this.next = null;
	}
	Edge(int data)
	{
		this.data = data;
	}
	Edge(int data,Edge next)
	{
		this.data = data;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Edge getNext() {
		return next;
	}
	public void setNext(Edge next) {
		this.next = next;
	}
	
}
