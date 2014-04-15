import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;


public class PeopleCircle {

	public String order(int numMales, int numFemales, int K)
	{
		ArrayList<Integer> people = new ArrayList<Integer>(numFemales + numMales);
		
		StringBuffer finalresult = new StringBuffer();
		for(int j=0;j<(numFemales + numMales);j++)
			finalresult.append("F");
		
		for(int i=0;i<finalresult.length();i++)
			people.add(i);
			
		int slot = K-1;
		
		while(numFemales>0)
		{
			while(slot>=people.size())
				slot -=people.size();
			
			people.remove(slot);
			slot--;
			
			slot +=K;
			numFemales--;
		}
		
		for(int m = 0;m<people.size();m++)
		{
			finalresult.setCharAt(people.get(m),'M');
		}
//		System.out.println(people.toString());
//		System.out.println(finalresult.toString());
		return finalresult.toString();
		
	}
	
	public static void main(String[] args) {
		PeopleCircle ob = new PeopleCircle();
		ob.order(25,25,1000);
		
	}

}
