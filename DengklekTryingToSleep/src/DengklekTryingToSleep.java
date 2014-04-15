public class DengklekTryingToSleep {

	public int minDucks(int[] ducks)
	{
		int max = ducks[0],min = ducks[0];
		for(int i=0;i<ducks.length;i++)
		{
			if(ducks[i]>max)
				max = ducks[i];
			if(ducks[i]<min)
				min = ducks[i];
		}
		
		return max-min-ducks.length+1;
	}
	public static void main(String[] args) {
		
		DengklekTryingToSleep dengklekTryingToSleep = new DengklekTryingToSleep();
		int ducks[] = {58};
		System.out.println(dengklekTryingToSleep.minDucks(ducks));

	}

}
