import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class BikeRace 
{

	public String[] eliminated(int track, String[] name, int[] start, int[] speed)
	{
		//map three things together for arranging after sorting
		TreeMap<Integer, TreeMap<String,Integer>> map =  new TreeMap<>();
		for (int i = 0; i < speed.length; i++) 
		{
			TreeMap<String, Integer> key =  new TreeMap<String, Integer>();
			key.put(name[i],speed[i]);
			map.put(start[i],key);
		}
		float timeovertake[] = new float[start.length];
		
		
		//Lists to play with
		ArrayList<Integer> starttime = new  ArrayList<Integer>();
		ArrayList<String> names = new  ArrayList<String>();
		ArrayList<Integer> speeds = new ArrayList<Integer>();
		
		//sort according to start time
		for (int i = 0; i < start.length; i++) 
			starttime.add(i,start[i]);
		
		Collections.sort(starttime);
		
		//make the other two arrays with the corresponding values that were mapped
		for (TreeMap<String,Integer> val:map.values()) 
		{
			for(String na:val.keySet())
			{
				names.add(na);
			}
			for (Integer sped : val.values())
			{
				speeds.add(sped);
			}
		}
		
		for (int i = 0; i < names.size(); i++) 
		{
			System.out.print(names.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < names.size(); i++) 
		{
			System.out.print(starttime.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < names.size(); i++) 
		{
			System.out.print(speeds.get(i) + " ");
		}
		System.out.println();
		
		//check if surpassed before joining the race
		for (int i = 0; i < timeovertake.length; i++) 
		{
			float min = java.lang.Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) 
			{
				if ((starttime.get(j)    +(float) track/speeds.get(j) )  <= starttime.get(i)  && (starttime.get(j)    + (float)   track/speeds.get(j) )<min)  
				{
					timeovertake[i] = starttime.get(j) + track/speeds.get(j);
					min = timeovertake[i];
				}
			}
			System.out.println("time default is " + timeovertake[i]);
		}
		
		//Real thing that is not so tuf to think
		for (int i = 0; i < timeovertake.length; i++) 
		{
			System.out.println("checking for " + names.get(i));
			float minover = java.lang.Integer.MAX_VALUE;
			for (int j = 0; j < timeovertake.length; j++) 
			{
				System.out.println("See if " + names.get(j) + " can overtake " + names.get(i));
				if (j<i && speeds.get(i)<speeds.get(j))
				{
					System.out.println("checking backtracking");
					float relative = speeds.get(j) - speeds.get(i);
					float timegap = starttime.get(i) - starttime.get(j);
					float disgap = timegap * speeds.get(j);
					float distance = track - (disgap % track);
					float timewillbeovertaken = starttime.get(i) + (distance / relative);
					System.out.println("time is " + timewillbeovertaken);
					System.out.println("timeovertake[j] " + timeovertake[j]);
					if (minover>timewillbeovertaken && (timewillbeovertaken<timeovertake[j]  || timeovertake[j]==0 ) && relative>0 && (timewillbeovertaken<timeovertake[i] || timeovertake[i]==0))
						{
							System.out.println("edited down");
							timeovertake[i] = timewillbeovertaken;
							minover = timeovertake[i];
						}
					
				}
				if(j>i)
				{

					float relative = speeds.get(j) - speeds.get(i);
					float timegap = starttime.get(j) - starttime.get(i);
					float disgap = timegap * speeds.get(i);
					if (track<disgap)
						disgap %= track; 
					if (relative>0)
					{
						float timewillbeovertaken = starttime.get(j) + (disgap / relative);
					//	System.out.println("time is " + timewillbeovertaken);
						
						if (timewillbeovertaken<minover && (timeovertake[j]>timewillbeovertaken || timeovertake[j]==0) )
						{
							System.out.println("here relative is " + relative);
							timeovertake[i] = timewillbeovertaken;
							minover = timewillbeovertaken;
						}
					}
				}
			}
		}
		ArrayList<Float> ja = new ArrayList<Float>();
		int count=0;
		for (int i = 0; i < timeovertake.length; i++) 
		{
			if (timeovertake[i]!=0) {
				count++;
				ja.add(timeovertake[i]);
				
			}			
			System.out.print(timeovertake[i] + " ");
			
		}
		//System.out.println("count is " + count);
		//int min = ;
		ArrayList<Integer> indexes;
		String[] result = new String[count];
		int index =0;
		while(count>=1)
		{
			indexes = getindexes(timeovertake, java.lang.Integer.MAX_VALUE,ja);
			ArrayList<String> arrayList2 = new ArrayList<String>();
			for(int i=0;i<indexes.size();i++)
				arrayList2.add(names.get(indexes.get(i)));
				Collections.sort(arrayList2);
				
				for (int i = 0; i < indexes.size(); i++) 
				{
					
					result[index] = arrayList2.get(i);
					//System.out.println("inserted " + result[index]);
					index++;
					count--;
				}
			
			//min = timeovertake[indexes.get(0)];
			//count-= indexes.size();
			indexes.clear();
		}
		return result;
		
	}
	public ArrayList<Integer> getindexes (float[] timeovertake,float min,ArrayList<Float> ja)
	{
		
		ArrayList<Integer> indexes = new  ArrayList<Integer>();
		for (int i = 0; i < timeovertake.length; i++) 
		{
			if (ja.contains(timeovertake[i]) && timeovertake[i]<min && timeovertake[i]!=0 )
			{
				
				min = timeovertake[i];
			}
		}
		for (int i = 0; i < timeovertake.length; i++) 
		{
			if (timeovertake[i]==min)
			{
				Float a =timeovertake[i];
				ja.remove(a);
				indexes.add(i);
			}
		}
		//System.out.println("return list of  size " + indexes.size());
		return indexes;
		
	}
	public static void main(String[] args) {
		BikeRace bikeRace =  new BikeRace();
		int track = 1000;
		//{1000, {"A", "B", "C", "D"}, {100, 200, 0, 1}, {10, 15, 4, 4}}

		String[] name ={"A", "B", "C", "D"};
		int[] start = {100, 200, 0, 1};
		int []speed   ={10, 15, 4, 4};
		String []result =  bikeRace.eliminated(track, name, start, speed);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
			
		}

	}

}
