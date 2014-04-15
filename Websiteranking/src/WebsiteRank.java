import java.util.ArrayList;
import java.util.StringTokenizer;
public class WebsiteRank {

	public long countVotes(String[] votes, String website)
	{
		
		ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
		getarray(votes, arrayList);
		ArrayList<String> error = new ArrayList<String>();
		return(getvotes(arrayList, website, error));
	}
	public long getvotes(ArrayList<ArrayList<String>> arrayList,String head,ArrayList<String> error)
	{
		long sum=0;
		int index = getindex(arrayList, head);
		if(index==-1)
			return 1;
		else
		{
			for (int i = 1; i < arrayList.get(index).size(); i++) 
			{
				ArrayList<String> list = new ArrayList<String>();
				for (int j = 0; j < error.size(); j++) 
					list.add(j,error.get(j));
				
				if (list.contains(arrayList.get(index).get(i))==false) 
				{
					list.add(arrayList.get(index).get(0));
					sum += getvotes(arrayList, arrayList.get(index).get(i), list);
				}
			}
		}
		if(sum==0)
			return 0;
		else
			return 1+sum;
	}
	public int getindex(ArrayList<ArrayList<String>> arrayList,String head)
	{
		int index = -1;
		for (int i = 0; i < arrayList.size(); i++) 
		{
			if (head.equals(arrayList.get(i).get(0)))
				index = i;
		}
		return index;
	}
	public void getarray(String[] votes,ArrayList<ArrayList<String>> arrayList)
	{
		for (int j = 0; j < votes.length; j++) 
		{
			StringTokenizer stringTokenizer = new StringTokenizer(votes[j]," ");
			ArrayList<String> arrayList2 = new ArrayList<String>();
			while (stringTokenizer.hasMoreElements())
				arrayList2.add(stringTokenizer.nextToken());
			arrayList.add(arrayList2);
		}
		
	}
	public static void main(String[] args) {
		
		WebsiteRank rank = new WebsiteRank();
		String []votes = {"A B C D", "B C D", "C D"};
		String website = "A";
		System.out.println("the answer is " + rank.countVotes(votes, website));

	}

}
