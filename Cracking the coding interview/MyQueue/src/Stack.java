public class Stack 
{
	private Node stackpointer = null;
	Stack()
	{
		this.stackpointer = null;
	}
	Stack(int data)
	{
		this.push(data);
	}
	Stack(int values[])
	{
		for(int i=0;i<values.length;i++)
		{
			this.push(values[i]);
		}
	}
	public Node getStackpointer() {
		return stackpointer;
	}
	public void setStackpointer(Node stackpointer) {
		this.stackpointer = stackpointer;
	}
	public int size()
	{
		int count=0;
		Node temp = stackpointer;
		while(temp!=null)
		{
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	public boolean isEmpty()
	{
		if (stackpointer==null) 
		{
			return true;
		}
		else
			return false;
	}
	public void push(int data)
	{
		Node temp = new Node(data);
		temp.setNext(stackpointer);
		stackpointer = temp;
	}
	public Node pop()
	{
		if(stackpointer!=null)
		{
			Node temp = stackpointer;
			stackpointer = stackpointer.getNext();
			return temp;
		}
		else
			return null;
	}


}
