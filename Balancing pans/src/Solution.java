import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/***
 * Logic
1. first we need to generate the sequence required of numbers
2. now in every function call we need to check whether the amount of weight that has to be balanced now is possible from the 
leftside of the sequence legally
3. if possible then put those weight in the lighter pan
and we are done
else
	we need to add the element with the highest weight available till now to the lighter pan
	and modify the sequence of weights required and call recursively.
*/

public class Solution 
{

	public void printconfiguration(int weight)
	{
		ArrayList<Integer> sequence = generatesequence(weight); 
		for (int i = 0; i < sequence.size(); i++) 
		{
			System.out.print(sequence.get(i) + " ");
		}
		System.out.println();
		ArrayList<Integer> leftpan =	new ArrayList<Integer>();
		ArrayList<Integer> rightpan =	new ArrayList<Integer>();
		rightpan.add(weight);
		balance(weight, sequence, leftpan,rightpan, 0, weight);
		Iterator<Integer> iter = leftpan.iterator();
		System.out.println("printing leftpan");
		while(iter.hasNext())
		{
			System.out.print(iter.next() + " ");
		}
		System.out.println("\nprinting rightpan");
		Iterator<Integer> iter1 = rightpan.iterator();
		while(iter1.hasNext())
		{
			int temp = iter1.next();
			if(temp == weight)
				continue;
			else
				
			System.out.print(temp + " ");
		}
		System.out.println();
	}
	public void balance(int difference,ArrayList<Integer> weightsleft,ArrayList<Integer> leftpan,ArrayList<Integer> rightpan,
			int leftpanweight,int rightpanweight)
	{
		//System.out.println("here for difference of " + difference);
		if(difference!=0)
		{
				String heavier ;
				if(leftpanweight > rightpanweight)
					heavier = "left";
				else
					heavier = "right";
				//check if sum is possible
				//if yes then add that returned sequence of weights to the pan that is lighter
				
				ArrayList<Integer> leftsum = new ArrayList<>(); 
				if(possible(weightsleft, difference,-1,leftsum))
				{
					//System.out.println("possible");
					for (int i = 0; i < leftsum.size(); i++) 
					{
						if(heavier == "right")
						{
							leftpan.add(leftsum.get(i));
							leftpanweight += leftsum.get(i);
						}
						else
						{
							rightpan.add(leftsum.get(i));
							rightpanweight += leftsum.get(i);
						}
					}
				}
				else
				{
					//add the max weight that you have left to the pan which has less weight
					if(heavier == "left")
						{
						int weightremoved = weightsleft.remove(weightsleft.size()-1); 
						rightpan.add(weightremoved);
						rightpanweight += weightremoved; 
						}
					else
						{
						int weightremoved = weightsleft.remove(weightsleft.size()-1);
						leftpan.add(weightremoved);
						leftpanweight += weightremoved;
						}
					
					balance(Math.abs(rightpanweight-leftpanweight),
							getmodifiedweightsleft(weightsleft, Math.abs(rightpanweight-leftpanweight)) ,
							leftpan, rightpan, leftpanweight, rightpanweight);
				}
		}
	}
	public ArrayList<Integer> getmodifiedweightsleft(ArrayList<Integer> weightsleft,int number)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < weightsleft.size(); i++) 
		{
			temp.add(weightsleft.get(i));
			if(weightsleft.get(i)>= number)
				break;
		}
		return temp;
	}
	public boolean possible(ArrayList<Integer> weightsleft,int difference,int lastindex,ArrayList<Integer> result)
	{
		int index = 0; 
		if(difference==0)
			return true;
		for(int i=weightsleft.size()-1;i>=0;i--)
		{
			if(weightsleft.get(i)<=difference)
			{
				//System.out.println("index is "+ i);
				index = i;
				break;
			}
		}
		if(index==lastindex-1 || index==lastindex)
		{
			return false;
			
		}
		else
		{
			result.add(weightsleft.get(index));
			return possible(weightsleft, difference - weightsleft.get(index), index, result);
		}
		
	}
	public ArrayList<Integer> generatesequence(int weight)
	{
		ArrayList<Integer> arrayList =  new ArrayList<>();
		arrayList.add(1);
		//arrayList.add(3);
		int index = 0;
		while(arrayList.get(index)< weight)
		{
			if(index==0)
				arrayList.add(3);
			else
			{
				arrayList.add((2 * arrayList.get(index) + arrayList.get(index-1)));
			}
			index ++;
		}
		return arrayList;
	}
	public static void main(String[] args) 
	{
		
		System.out.println("enter the weigth to be measured");
		Scanner scan =  new Scanner(System.in);
		int weight = scan.nextInt();
		Solution solution =  new Solution();
		solution.printconfiguration(weight);
		scan.close();
	}

}
