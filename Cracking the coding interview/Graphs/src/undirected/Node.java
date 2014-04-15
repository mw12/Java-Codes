package undirected;
public class Node 
{
	private int data;
	private Node next;
	private String color = "white";
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	Node()
	{
		this.data = 0;
		this.next = null;
	}
	Node(int datain) 
	{
		this.data = datain;
		this.next = null;
	}
	public int getData() 
	{
		return data;
	}
	public void setData(int data) 
	{
		this.data = data;
	}
	public Node getNext() 
	{
		return next;
	}
	public void setNext(Node next) 
	{
		this.next = next;
	}

}
