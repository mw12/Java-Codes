import java.util.ArrayList;

public class linked_list 
{
	Node head = null;
	linked_list()
	{
		this.head = new Node();
		
	}
	linked_list(int headdata)
	{
		this.head = new Node(headdata);
		
	}
	linked_list(int values[])
	{
		Node temp = null;
		for(int i=0;i<values.length;i++)
		{
			//System.out.println("here");
			if (i==0) 
			{
				
				this.head = new Node(values[0]);
				temp = this.head;
			}
			else
			{
				temp.setNext( new Node(values[i]));
				temp = temp.getNext();
			}
			
		}
	}
	public void append(int nodedata)
	{
		Node temp = this.head;
		while(temp.getNext()!=null)
		{
			temp = temp.getNext();
		}
		temp.setNext(new Node(nodedata));
		
	}
	public Node search(int nodedata)
	{
		Node temp = this.head;
		while(temp!=null)
		{
			if (temp.getData()==nodedata) 
			{
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	public void prepend(int nodedata)
	{
		Node temp = new Node(nodedata);
		temp.setNext(this.head);
		this.head = temp;
		
	}
	public int length()
	{
		int count =0;
		Node temp = this.head;
		while(temp!=null)
		{
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	public Node nthfromlast(int n)
	{
		if(this.length()<n)
		{
			System.out.println("invalid arguments");
			return null;
		}
		else//valid arguments
		{
			int count = 0;
			Node back = null;
			Node front;
			while(count<n)
			{
				if(count==0)
					back = this.head;
				else
					back = back.getNext();
				count++;
			}
			front  = this.head;
			while(back.getNext()!=null)
			{
				front = front.getNext();
				back = back.getNext();
			}
			return front;
		}
			
	}
	public Object[] removeduplicates()//using buffer ie arraylist to store unique values of linked list
	{
		ArrayList<Integer> set =  new ArrayList<Integer>();
		Node temp = this.head;
		while(temp!=null)
		{
			if (set.contains(temp.getData())==false) 
			{
				set.add(temp.getData());
			}
			temp = temp.getNext();
		}
		return set.toArray();
		
	}
	public void removedup()
	{
		Node temp = this.head;
		while(temp!=null)
		{
			Node forward = temp;
			while(forward!=null)
			{
				if(forward.getNext()==null) 
				{
					
				}
				else if(forward.getNext().getData()==temp.getData())
				{
					forward.setNext(forward.getNext().getNext());
				}
				forward = forward.getNext();
			}
			temp = temp.getNext();
		}
	}
	public void display()
	{
		Node temp= this.head;
		while(temp!=null)
		{
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public Node detectloop()//detect the head of the loop if there otherwise null
	//logic of this is in cracking the coding interview on page no .110
	//using floyd's cycle detection algorithm
	{
		Node slow = head;
		Node fast = head;
		while(true)
		{
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(fast ==null || slow ==null)
				return null;
			if(fast==slow && fast!=null)
				break;
		}
		slow = head;
		while(fast!=slow)
		{
			fast = fast.getNext();
			slow = slow.getNext();
		}
		return fast;
	}
	public void reverselist()
	{
		Node previous = null;
		Node current = this.head;
		Node temp = null;
		while(current!=null)
		{
			temp = current.getNext();
			current.setNext(previous);
			previous = current;
			current = temp;
		}
		this.head = previous;
	}
}
