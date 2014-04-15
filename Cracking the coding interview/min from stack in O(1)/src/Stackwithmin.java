
public class Stackwithmin 
{
	private Node stackpointer = null;
	Stackwithmin()
	{
		this.stackpointer = null;
	}
	Stackwithmin(int data)
	{
		stackpointer = new Node(data);
		
	}
	
	public Node getStackpointer() {
		return stackpointer;
	}
	public void setStackpointer(Node stackpointer) {
		this.stackpointer = stackpointer;
	}
	public Node pop()
	{
		if(stackpointer==null)
		{
			System.out.println("the stack is empty");
			return null;
		}
		else
		{
			Node temp = stackpointer;
			stackpointer = stackpointer.getNext();
			return temp;
			
		}
	}
	public void push(int data)
	{
		if (stackpointer==null) 
		{
			stackpointer = new Node(data,data);
			
		}
		else
		{
			Node temp = new Node(data, data);
			temp.setNext(stackpointer);
			temp.setLocalmin(Math.min(temp.getLocalmin(),stackpointer.getLocalmin()));
			stackpointer = temp;
		}
	}
	public int getmin()
	{
		if (stackpointer==null) 
		{
			return Integer.MAX_VALUE;	
		}
		else
		{
			
			return stackpointer.getLocalmin();
		}
	}

}
