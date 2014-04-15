

public class Edge 
{
	private int data;
	private int cost=0;
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	private Edge next;
	Edge()
	{
		this.data = 0;
		this.next = null;
	}
	Edge(int data,int cost)
	{
		this.data = data;
		this.cost = cost;
	}
	Edge(int data,int cost,Edge next)
	{
		this.data = data;
		this.cost = cost;
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
