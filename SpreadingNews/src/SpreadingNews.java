import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SpreadingNews 
{
	public int minTime(int[] supervisors)
	{
		int subordinates[] = new int[supervisors.length];
		for (int i = 0; i < subordinates.length; i++) 
			subordinates[i] = -1;
		getnoofsubordiantes(supervisors, 0, subordinates);
		return getmincalls(supervisors, subordinates);
	}
	public void getnoofsubordiantes(int supervisors[],int index,int subordinates[])
	{
		if(subordinates[index]== -1)
		{
			ArrayList<Integer> children = noofdirect(index, supervisors);
			subordinates[index] = 0;
			for (int i = 0; i < children.size(); i++) 
			{
				getnoofsubordiantes(supervisors, children.get(i), subordinates);
				subordinates[index] += 1+ subordinates[children.get(i)];
			}
		}
	}
	public ArrayList<Integer> noofdirect(int index,int supervisors[])
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = index+1; i < supervisors.length; i++) 
		{
			if(supervisors[i] > index)
				break;
			if(supervisors[i]== index)
				temp.add(i);
		}
		return temp;
	}
	public int getmincalls(int supervisors[],int subordinates[])
	{
		int time[]= new int[supervisors.length];
		int max = 0;
		ArrayList<Integer>	temp =  new ArrayList<Integer>();
		for (int i = 0; i < subordinates.length; i++) 
		{
			if(i==0)
				time[i]=0;
			temp = noofdirect(i, supervisors);
			NavigableMap<Integer,ArrayList<Integer>> map= new TreeMap<Integer, ArrayList<Integer>>();
			for (int j = 0; j < temp.size(); j++) 
			{
				if(map.containsKey(subordinates[temp.get(j)]))
				{
					ArrayList<Integer> arrayList =  map.get(subordinates[temp.get(j)]);
					arrayList.add(temp.get(j));
					map.put(subordinates[temp.get(j)], arrayList );
				}
				else
				{
					ArrayList<Integer > arrayList =  new ArrayList<Integer>();
					arrayList.add(temp.get(j));
					map.put(subordinates[temp.get(j)], arrayList );
				}
			}
			map = map.descendingMap();
			Iterator<Integer> iter = map.keySet().iterator();
			int index = 1;
			while(iter.hasNext())
			{
				int temp1 = iter.next();
				ArrayList<Integer> arrayList = map.get(temp1);
				for (int j = 0; j < arrayList.size(); j++) 
				{
					time[arrayList.get(j)] = time[i] + (index);
					if(time[arrayList.get(j)] > max)
					{
						max = time[arrayList.get(j)]; 
					}
					index++;
				}
			}
			temp.clear();
		}
		return max;
	}
	public static void main(String[] args) 
	{
		SpreadingNews news =  new SpreadingNews();
		int supervisors[] =  {-1,0,0,2,2};//{-1, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 12, 13, 14, 16, 16, 16};
		System.out.println("the mincalls are " + news.minTime(supervisors));
	}
}
