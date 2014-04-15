import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SUBMIN {

	public void findsubsets(int numbers[],int queries[])
	{
		ArrayList<Integer> searched = new ArrayList<>();
		
		for (int i = 0; i < queries.length; i++) 
		{
			searched = search(numbers, queries[i]);
			//System.out.println("the no of occurences are "+ searched.size());
			Iterator<Integer> iter = searched.iterator();
			int index = 0;
			int left = 0;
			int right = 0;
			int subsets =0;
			while(iter.hasNext())
			{
				subsets++;//self added
				index = iter.next();
				//getting left index
				left = index;
				for (int j = index; j >=0; j--) 
				{
					
					if(numbers[j]<numbers[index])
					{
						break;
					}
					left =j;
					
				}
				if(left==-1)
					left =0;
				right = index;
				for(int j=index+1;j<numbers.length;j++)
				{
					
					if(numbers[j]<=numbers[index])
					{
						break;
					}
					right = j;
				}
				//System.out.println("left is "+ left + "index is "+ index + " and right is "+ right);
				subsets += index - left;//left side
				subsets += right-index;//right side
				subsets += (right-index) * (index-left);
				
				//subsets =0;
			}
			System.out.println(subsets);
			searched.clear();
		}
	}
	public ArrayList<Integer> search(int numbers[],int key)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) 
		{
			if(numbers[i]==key)
			{
				temp.add(i);
			}
		}
		return temp;
	}
	public static void main(String[] args) 
	{
		SUBMIN submin = new SUBMIN();
		Scanner scan =  new Scanner(System.in);
		int size = scan.nextInt();
		int numbers[] = new int[size];
		for (int i = 0; i < size; i++) 
		{
			numbers[i]= scan.nextInt();
		}
		int noofqueries = scan.nextInt();
		int queries[] =  new int[noofqueries];
		for (int i = 0; i < noofqueries; i++) 
		{
			queries[i]= scan.nextInt();
		}
		submin.findsubsets(numbers, queries);
		scan.close();

	}

}
