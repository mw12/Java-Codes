import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public int longestcommonpattern(String A,String B)
	{
		String shorter;
		String longer;
		if(A.length()<B.length())
		{
			shorter = A;
			longer = B;
		}
		else
			{
			shorter = B;
			longer = A;
			}
		HashMap<Character, Integer > hashed = hash(shorter);
		return getcommoncharacters(longer, hashed);
		
//		Iterator<Character> iter = hashed.keySet().iterator();
//		while(iter.hasNext())
//		{
//			Character temp =  iter.next();
//			//System.out.println("key is " + temp + " and value is "+ hashed.get(temp));
//		}
		
	}
	public int getcommoncharacters(String longer,HashMap<Character,Integer> hashed)
	{
		int common =0;
		for (int i = 0; i < longer.length(); i++) 
		{
			if(hashed.containsKey(longer.charAt(i)) && hashed.get(longer.charAt(i))>0)
			{
				common++;
				hashed.put(longer.charAt(i), hashed.get(longer.charAt(i))-1);
			}
		}
		return common;
	}
	public HashMap<Character,Integer> hash(String shorter)
	{
		HashMap<Character, Integer> temp =  new HashMap<>();
		for (int i = 0; i < shorter.length(); i++) 
		{
			if(temp.containsKey(shorter.charAt(i)))
			{
				//System.out.println("here for " + shorter.charAt(i));
				int prevvalue =  temp.get(shorter.charAt(i));
				temp.put(shorter.charAt(i),++prevvalue);
			}
			else
			{
				temp.put(shorter.charAt(i),1);
			}
		}
		return temp;
	}
	public static void main(String[] args) 
	{
		Main mn = new Main();
		Scanner scan =  new Scanner(System.in);
		int nooftestcases = scan.nextInt();
		for (int i = 0; i < nooftestcases; i++) 
		{
			System.out.println(mn.longestcommonpattern(scan.next(), scan.next()));
			
		}
		scan.close();

	}	

}
