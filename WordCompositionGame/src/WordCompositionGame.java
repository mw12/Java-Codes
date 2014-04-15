import java.util.ArrayList;
import java.util.Arrays;


public class WordCompositionGame {


	public String score(String[] listA, String[] listB, String[] listC)
	{
		
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(listA));
		ArrayList<String> arrayList1 = new ArrayList<String>(Arrays.asList(listB));
		ArrayList<String> arrayList2 = new ArrayList<String>(Arrays.asList(listC));
		
		int A = 0,B = 0,C = 0;
		
		
		for (int i = 0; i < arrayList.size(); i++) 
		{
			
			if (arrayList1.contains(arrayList.get(i)))
			{
				
				if (arrayList2.contains(arrayList.get(i))) 
				{
					A +=1;
				}
				else
					A +=2; 
			}
			else if (arrayList2.contains(arrayList.get(i)))
			{
				
				if (arrayList1.contains(arrayList.get(i))) 
				{
					A +=1;
				}
				else
					A +=2; 
			}
			else
				A +=3;
			
		}
		for (int i = 0; i < arrayList1.size(); i++) 
		{
			if (arrayList.contains(arrayList1.get(i)))
			{
				
				if (arrayList2.contains(arrayList1.get(i))) 
				{
					B +=1;
				}
				else
					B +=2; 
			}
			else if (arrayList2.contains(arrayList1.get(i)))
			{
				
				if (arrayList.contains(arrayList1.get(i))) 
				{
					B +=1;
				}
				else
					B +=2; 
			}
			else
				B +=3;
		}
		for (int i = 0; i < arrayList2.size(); i++) 
		{
			if (arrayList.contains(arrayList2.get(i)))
			{
				
				if (arrayList1.contains(arrayList2.get(i))) 
				{
					C +=1;
				}
				else
					C +=2; 
			}
			else if (arrayList1.contains(arrayList2.get(i)))
			{
				
				if (arrayList.contains(arrayList2.get(i))) 
				{
					C +=1;
				}
				else
					C +=2; 
			}
			else
				C +=3;
		}
		
		return A + "/" + B + "/" + C;


		
	}
	
	public static void main(String[] args) {
		
		
		WordCompositionGame compositionGame = new WordCompositionGame();
		String[] listA  ={"bcdbb","aaccd","dacbc","bcbda","cdedc","bbaaa","aecae"};
		String[] listB  ={"bcdbb","ddacb","aaccd","adcab","edbee","aecae","bcbda"};
		String[] listC  ={"dcaab","aadbe","bbaaa","ebeec","eaecb","bcbba","aecae","adcab","bcbda"};
		System.out.println(compositionGame.score(listA, listB, listC));

	}

}
