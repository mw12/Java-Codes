//import java.lang.Object;
import java.util.Arrays;
public class YahtzeeScore {

	int maxPoints(int[] toss)
	{
		int sum []= new int[5];
		int count=1;
		for(int i=0;i<toss.length;i++)
		{
			count=1;
			sum[i]=toss[i];
			for(int j=i+1;j<toss.length;j++)
			{
				if(sum[i]==toss[j])
					count++;
			}
			sum[i]*=count;
		}
		Arrays.sort(sum);
		return sum[4];
	}
	public static void main(String[] args) {
		YahtzeeScore ob=new YahtzeeScore();
		int toss[]={ 6, 4, 1, 1, 3 };
		int max=ob.maxPoints(toss);
		System.out.println(max);
	}

}
