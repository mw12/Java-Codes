import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cryptography {

	public long encrypt(int[] numbers)
	{
		int sum=1;
		ArrayList<Integer> b = new ArrayList<>();
		for(int i=0;i<numbers.length;i++)
			{
			sum = sum*numbers[i];
			b.add(numbers[i]);
			}
		
		int min = Collections.min(b);
		sum = sum / min;
		sum= sum* (min+1);
		System.out.println(sum);
		
		return 0;
		
	}
	public static void main(String[] args) {
		Cryptography cryptography = new Cryptography();
		int []numbers = {1,2,3};
		cryptography.encrypt(numbers);

	}

}
