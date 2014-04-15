
public class Node {

	private int data;
	private Node next = null;
	
	Node()
	{
		this.data = 0;
		this.next = null;
	}
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
	public Node getNext() 
	{
		return next;
	}
	public void setNext(Node next) 
	{
		this.next = next;
	}
	public int getData() 
	{
		return data;
	}
	public void setData(int data) 
	{
		this.data = data;
	}
	

}
