public class Stack 
{
	private Nodestack stackpointer = null;
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
	public Nodestack getStackpointer() {
		return stackpointer;
	}
	public void setStackpointer(Nodestack stackpointer) {
		this.stackpointer = stackpointer;
	}
	public int size()
	{
		int count = 0;
		Nodestack temp = this.stackpointer;
		while(temp!=null)
		{
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	public void pushatbottom(Stack stack,int data)
	{
		if (!stack.isEmpty())
		{
			int popped = stack.pop().getData();
			pushatbottom(stack, data);
			stack.push(popped);
		}
		else
		{
			stack.push(data);
		}
	}
	public void push(int data)
	{
		Nodestack temp = new Nodestack(data);
		temp.setNext(stackpointer);
		stackpointer = temp;
	}
	public Nodestack pop()
	{
		if(stackpointer!=null)
		{
			Nodestack temp = stackpointer;
			stackpointer = stackpointer.getNext();
			return temp;
		}
		else
			return null;
	}
	public boolean isEmpty()
	{
		if(stackpointer==null)
			return true;
		else
			return false;
	}
	public Stack sort(Stack stack,boolean ascending)
	{
		Stack secondary = new Stack();
		while(!stack.isEmpty())
		{
				Nodestack temp = secondary.getStackpointer();
				int data = stack.pop().getData();
				if (ascending) //ascending sort
				{
					while(temp!=null && temp.getData()>data)
					{
						stack.push(secondary.pop().getData());
						temp = temp.getNext();
					}
					secondary.push(data);
				}
				else//descending sort
				{
					while(temp!=null && temp.getData()<data)
					{
						stack.push(secondary.pop().getData());
						temp = temp.getNext();
					}
					secondary.push(data);
				}
				
			
		}
		return secondary;
	}
	public void display()
	{
		Nodestack temp = this.getStackpointer();
		while(temp!=null)
		{
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public void reversestack()
	{
		if (!this.isEmpty()) 
		{
			int popped = this.pop().getData();
			reversestack();
			pushatbottom(this,popped);
		}
		
	}
}
