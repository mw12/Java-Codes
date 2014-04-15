//implementation of queue using two stacks
public class MyQueue 
{
	Stack primary = new Stack();
	Stack secondary = new Stack();
	public int size()
	{
		return primary.size() + secondary.size();
	}
	public void queue(int data)
	{
		primary.push(data);
	}
	public Node dequeue()
	{
		if (!secondary.isEmpty()) 
		{
			return secondary.pop();
		}
		else
		{
			while(!primary.isEmpty())
			{
				secondary.push(primary.pop().getData());
			}
			if (secondary.getStackpointer()==null) 
			{
				System.out.println("Nobody is queued");
				
			}
			return secondary.pop();
		}
	}
	
	public static void main(String[] args) 
	{
		MyQueue q = new MyQueue();
		q.queue(1);
		q.queue(2);
		System.out.println(q.size());
		q.queue(3);
		q.queue(4);
		System.out.println(q.size());
		
		System.out.println("the element dequeued is " + q.dequeue().getData());
		System.out.println(q.size());
		

	}

}
