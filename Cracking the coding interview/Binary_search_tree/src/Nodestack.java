
public class Nodestack {

	private int data;
	private Nodestack next = null;
	
	Nodestack()
	{
		this.data = 0;
		this.next = null;
	}
	Nodestack(int data)
	{
		this.data = data;
		this.next = null;
	}
	public Nodestack getNext() 
	{
		return next;
	}
	public void setNext(Nodestack next) 
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
