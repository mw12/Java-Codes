import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TomekPhone {

	public int minKeystrokes(int[] frequencies, int[] keySizes)
	{
		
		
		ArrayList<Integer> keysleft = new  ArrayList<Integer>();
		int slots = 0;
		for (int i = 0; i < keySizes.length; i++) {
			keysleft.add(i, keySizes[i]);
			slots+= keySizes[i];
		}
		if (slots<frequencies.length) {
			return -1;
		}
		Collections.sort(keysleft);//ascending order of left chars
		int count =0;
		ArrayList<Integer> frequency = new ArrayList<Integer>();
		for (int i = 0; i < frequencies.length; i++) 
		{
			frequency.add(i, frequencies[i]);
		}
		Collections.sort(frequency);
		Collections.reverse(frequency);
		
		
		
		
		int[] turn = new int[keySizes.length];//keeping times of keys to be pressed
		
		for (int i = 0; i < frequency.size(); i++) 
		{
		//	System.out.println("counting for "+ frequency.get(i) );
			count += frequency.get(i)* findturn(keysleft,turn);
		//	System.out.println(count);
		}
		
		
		return count; 
		
	}
	public int findturn(ArrayList<Integer> keysleft,int [] turn)
	{
		int min = java.lang.Integer.MAX_VALUE;
		int keystobepressed = 0;
		int index = 0;
		for (int i = 0; i < turn.length; i++) 
		{
			//System.out.println("min is" + min);		
			if (turn[i]<min && keysleft.get(i)>0)
			{
				index = i;
				min = turn[i];
				
			}
		}
		
		turn[index]++;
		keystobepressed = turn[index];
		keysleft.set(index,keysleft.get(index)-1);
		//System.out.println("returnning " + keystobepressed);
		return keystobepressed;
	}
	public static void main(String[] args) {

		TomekPhone phone =  new TomekPhone();
		int frequencies[] = {100,1000,1,10};
		int keySizes[]  = {50};
		System.out.println(phone.minKeystrokes(frequencies, keySizes));
		
		
	}

}
