import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public int makehimhappy(int appletype[],int sum)
	{
		HashMap<Integer, Integer> hashed =  new HashMap<>();
		int mintime = Integer.MAX_VALUE;
		boolean even = false;
		if(sum%2==0)
			 even =  true;
		for (int i = 0; i < appletype.length; i++) 
		{
			if(appletype[i] < sum)
			{
				if((even && (appletype[i]*2)!=sum) || !even)//even
				{
					int timeforthis = Math.min(i+1, appletype.length-i);
					//System.out.println("time for " + appletype[i] + " is " + timeforthis);
					if(hashed.containsKey(appletype[i]))
					{
						if(hashed.get(appletype[i])> timeforthis)
						{
							hashed.put(appletype[i],timeforthis);
						}
					}
					else
					{
						hashed.put(appletype[i], timeforthis);
					}
					
					if(hashed.containsKey(sum - appletype[i]))
					{
						int temp = Math.max(hashed.get(appletype[i]), hashed.get(sum-appletype[i]));
						if(temp < mintime)
						{
							mintime = temp;
						}
					}
				}
				
			}
		}
		if(mintime==Integer.MAX_VALUE)
			return -1;
		else
			return mintime;
	}
	
	public int mintime(int appletype[],int sum)
	{
		HashMap<Integer, Integer> hashed =  setmoves(appletype, sum);
		Iterator<Integer> iter = hashed.keySet().iterator();
		int mintime = Integer.MAX_VALUE;
		while(iter.hasNext())
		{
			
			int type1 = iter.next();
			if(type1 > sum/2)
				break;
			if(hashed.containsKey(sum-type1))
			{
				int temp = Math.max(hashed.get(type1), hashed.get(sum-type1)); 
				if(temp < mintime)
				{
					mintime = temp; 
				}				
			}
		}
		if(mintime==Integer.MAX_VALUE)
			return -1;
		else
			return mintime;
	}
	 
	public HashMap<Integer, Integer> setmoves(int appletype[],int sum)
	{
		HashMap<Integer, Integer> temp =  new HashMap<>();
		for (int i = 0; i < appletype.length; i++) 
		{
			if(appletype[i]<sum)
			{
				if(!temp.containsKey(appletype[i]))
				{
					if((sum%2)!=0 || (sum%2==0 && appletype[i]!=sum/2))//either odd or if even then only those which are not half
					{
						temp.put(appletype[i],findmintime(appletype, appletype[i]));
					}
				}
			}
		}
//		
//		Iterator<Integer> iter  = temp.keySet().iterator();
//		while(iter.hasNext())
//		{
//			int key = iter.next();
//			System.out.println("the minimum moves for " + key + " is " + temp.get(key));
//		}
		return temp;
	}
	public int findmintime(int appletype[] , int key)
	{
		for (int i = 0; i < appletype.length; i++) 
		{
			if(appletype[i]==key)
			{
				return Math.min(i+1,appletype.length-i);				
			}
		}
		
			return 0;
		
	}
	public static void main(String[] args)
	{
		Main mn = new Main();
		Scanner scan  =  new Scanner(System.in);
		int noofapples = scan.nextInt();
		int sum = scan.nextInt();
		int appletype[] =  new int[noofapples];
		for (int i = 0; i < noofapples; i++) 
		{
			appletype[i] = scan.nextInt();
		}
		System.out.println(mn.makehimhappy(appletype, sum));
		scan.close();

	}

}
