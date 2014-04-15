import java.util.ArrayList;
import java.util.Iterator;


public class SRMCards {

	int count = 0;

	public int maxTurns(int[] cards)
	{
	
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<cards.length;i++)
		arr.add(cards[i]);
		ArrayList<Integer> dp = new ArrayList<Integer>();
		for(int i=0;i<cards.length;i++)
		{
			dp.add(-1);
		}
		//System.out.println(dp.size());
		System.out.println(getmax(arr,dp,0));
		System.out.println("calls are" + count);
		
		return 0;
	}
	public int getmax(ArrayList<Integer> arr,ArrayList<Integer> dp,int iter)
	{
		count++;
		if(arr.size()==0)
			return 0;
		else
		{
			int max = 0;
			for(int i=0;i<arr.size();i++)
			{
				int temp=0;
				int found=0;
				if(dp.get(iter+i)!=-1)
				{
					found=1;
					temp = dp.get(iter+i);
					//System.out.println("here");
				}
				//System.out.println(arr.size());
				//System.out.println("in the for loop " +i + "th time");
				
				
				if(found==0)
				{
					//System.out.println("no dp");
					ArrayList<Integer> clone = new ArrayList<Integer>(arr.size());
					for(int j=0;j<arr.size();j++)
						clone.add(arr.get(j));
					temp = 1+ getmax(modify(clone,i),dp,iter+1);
				}
				//System.out.println("temp is " + temp);
				if(temp>max)
				{
					dp.set(iter+i,temp);
					max = temp;
				}
			}
			return max;
		}
		
	}
	public ArrayList<Integer> modify(ArrayList<Integer> arr,int index)
	{
		//System.out.println("in the modify ");
		int temp = arr.get(index);
		//System.out.println("removed " + arr.get(index));
		arr.remove(index);
		
		Iterator<Integer> iter = arr.iterator();
		while(iter.hasNext())
		{
			Integer ne = iter.next();
			if(ne==temp-1 || ne==temp+1 )
				{
				//System.out.println("removing " + ne);
				arr.remove(arr.indexOf(ne));
				iter = arr.iterator(); 
				}
		}
		return arr;
		
	}
	public static void main(String[] args) {
		SRMCards cards = new SRMCards();
		int[] card = {10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9,16,17};
		cards.maxTurns(card);
		

	}

}
