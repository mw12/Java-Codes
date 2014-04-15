
public class linked_loop 
{
	private Nodemodified head = null;
	public Nodemodified getHead() {
		return head;
	}
	public void setHead(Nodemodified head) {
		this.head = head;
	}
	linked_loop(int values[])
	{
		Nodemodified current = null;
		for(int i=0;i<values.length;i++)
		{
			
			if(i==0)
			{
				this.setHead(new Nodemodified(values[0]));
				current = this.getHead();
			}
			else
			{
				current.setNext(new Nodemodified(values[i]));
				current = current.getNext();
			}
		}
	}
	public void display()
	{
		Nodemodified temp = this.getHead();
		while(temp!=null)
		{
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	public boolean detectloopvisited()
	{
		Nodemodified temp = this.getHead();
		while(temp!=null)
		{
			temp.setVisited(true);
			if(temp.getNext()!=null)
			{
				if(temp.getNext().isVisited())
					return true;
				else
					temp = temp.getNext();
			}
			else
				return false;
		}
		return false;
		
	}
	public Nodemodified search(int data)
	{
		Nodemodified temp = this.getHead();
		while(temp!=null)
		{
			if(temp.getData()==data)
				break;
			else
				temp = temp.getNext();
		}
		if(temp==null)
			return null;
		else
			return temp;
	}
	public static void main(String[] args) 
	{
		int values[] = new int[]{1,2,3,4,5};
		linked_loop list = new linked_loop(values);
		list.display();
		list.search(5).setNext(list.search(2));
		
		System.out.println(list.detectloopvisited());
		//System.out.println(list.detectloopreversing());
		//System.out.println(list.detectloophash().getData());
//		System.out.println(tail.getNext().getData());
	}

}
