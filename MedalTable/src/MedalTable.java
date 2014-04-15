import java.util.ArrayList;
import java.util.Arrays;

import java.util.StringTokenizer;


public class MedalTable {

	@SuppressWarnings("rawtypes")
	public class table implements Comparable
	{
		String name;
		int gold,silver,bronze;
		public table(String name,int gold,int silver,int bronze) 
		{
			this.name = name;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Object ob) 
		{
			table tab = (table)ob;
			if (this.gold != tab.gold)
				return -this.gold + tab.gold;
			else if (this.silver != tab.silver) {
				return -this.silver + tab.silver;
			}
			else if (this.bronze != tab.bronze) {
				return -this.bronze + tab.bronze;
			}
			else
				return this.name.compareTo(tab.name);
				
			
		}
		public String toString()
		{
			return name + " " + gold + " " + silver + " " + bronze; 
		}
		
	}
	public String[] generate(String[] results)
	{
		ArrayList<String> countries  = new ArrayList<String>();
		ArrayList<Integer> gold =  new ArrayList<Integer>();
		ArrayList<Integer> silver =  new ArrayList<Integer>();
		ArrayList<Integer> bronze =  new ArrayList<Integer>();
		getmedals(results, countries, gold, silver, bronze);

		table rank[] = new table[countries.size()];
		for (int i = 0; i < countries.size(); i++) 
		{
			rank[i] = new table(countries.get(i), gold.get(i), silver.get(i), bronze.get(i));
		}
		Arrays.sort(rank);
		String []ranking = new String[rank.length];
		for (int i = 0; i < rank.length; i++) 
		{
			ranking[i] = rank[i].toString();
			System.out.println(ranking[i]);
		}
		return ranking;
		
	}
	public void getmedals(String[] results,ArrayList<String> countries,ArrayList<Integer> gold,ArrayList<Integer> silver,ArrayList<Integer> bronze)
	{
		for (int i = 0; i < results.length; i++) 
		{
			StringTokenizer stringTokenizer =  new StringTokenizer(results[i]," ");
			int position = 0;
			while (stringTokenizer.hasMoreElements()) 
			{
				position++;
				String temp = stringTokenizer.nextToken();
				if (!countries.contains(temp)) 
				{
					countries.add(temp);
					if (position==1)
					{
						gold.add(1);
						silver.add(0);
						bronze.add(0);
					}
					else if (position==2)
					{
						gold.add(0);
						silver.add(1);
						bronze.add(0);
					}
					else
					{
						gold.add(0);
						silver.add(0);
						bronze.add(1);
					
					}
						
					
				}
				else {
					
					
					int index = countries.lastIndexOf(temp);
					//System.out.println("index is "  + index);
					if (position==1)
					{
						int gol = gold.get(index);
						gold.set(index,++gol);
					}
					else if (position==2)
					{
						int gol = silver.get(index);
						silver.set(index,++gol);
						
						
					}
					else
					{
						int gol = bronze.get(index);
						bronze.set(index,++gol);
						
					}
						
					
				}
				
			}
		}
		
	}
	

	
	public static void main(String[] args) {

		MedalTable medalTable =  new MedalTable();
		String[] results = {"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"};
		medalTable.generate(results);
		
		
	}

}
