
public class Node {

	private int data;
	private int localmin;
	private Node next = null;
	
	public int getLocalmin() 
	{
		return localmin;
	}
	public void setLocalmin(int localmin) 
	{
		this.localmin = localmin;
	}
	Node()
	{
		this.data = 0;
		this.localmin = Integer.MAX_VALUE;
		this.next = null;
	}
	Node(int data)
	{
		this.data = data;
		this.localmin = Integer.MAX_VALUE;
		this.next = null;
	}
	Node(int data,int min)
	{
		this.data = data;
		this.localmin = min;
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
