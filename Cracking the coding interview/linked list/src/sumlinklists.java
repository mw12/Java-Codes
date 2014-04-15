import java.util.Scanner;
public class sumlinklists {

	public linked_list sumlists(linked_list first,linked_list second)
	{
		
		//if one can know the length of the link list
		int carry = 0;
		int length1 = first.length();
		int length2 = second.length();
		Node head1 = first.head;
		Node head2 = second.head;
		int temp ;
		if (length1>length2)//l1 > l2 
		{
			System.out.println("here");
			while(head2!=null)
			{
				temp = head1.getData() + head2.getData();
				System.out.println("sum is "+ temp);
				head1.setData((temp + carry)%10);
				carry = (temp + carry)/10;
				head1 = head1.getNext();
				head2 = head2.getNext();
			}
			while(carry>0)
			{
				temp = head1.getData() + carry;
				head1.setData(temp%10);
				carry = temp/10;
				if (head1.getNext()==null && carry>0) 
				{
					first.append(0);
					head1 = head1.getNext();
				}
				else
					head1 = head1.getNext();
			}
			
			return first;
		}
		else
		{
			return second;
		}
	}
	public static void main(String[] args) 
	{
		int values[] = new int[3];
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("enter 3 numbers to create a linked list");
		for(int i=0;i<values.length;i++)
			values[i] = scan.nextInt();

		linked_list  first = new linked_list(values);

		first.display();
		first.reverselist();
		first.display();
				
	}

}
