
public class GreatFairyWar {

	public 	int minHP(int[] dps, int[] hp)
	{
		int sum=0;
		for(int i=0;i<hp.length;i++)
		{
			sum += hp[i]*sum(dps);
			dps[i]=0;
		}
		
		return sum;
	}
	public int sum(int []array)
	{
		int sum=0;
		for(int i=0;i<array.length;i++)
			sum += array[i];
		return sum;
	}
	public static void main(String[] args) {
		GreatFairyWar fairyWar = new GreatFairyWar();
		int dps[] = {20,12,10,10,23,10};
		int hp[] = {5,7,7,5,7,7};
		
		System.out.println(fairyWar.minHP(dps, hp));

	}

}
