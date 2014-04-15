import java.util.StringTokenizer;
public class ExerciseMachine {
	public int getPercentages(String time)
	{
		int multiplier = 3600;
		int seconds=0;
		int i = 0;
		StringTokenizer st = new StringTokenizer(time,":");
		while(st.hasMoreTokens())
		{
			String str = st.nextToken();
			seconds += (int)Integer.parseInt(str)* multiplier;
			multiplier /= 60;
		}
		
		for( i=1;i<100;i++)
		{
			if((((float)seconds/100)*i)%1 ==0 )
				break;
		}
		

		return ((100/i) -1);
		
		
	}
	public static void main(String[] args) {
		ExerciseMachine ex = new ExerciseMachine();
		ex.getPercentages("00:14:10");

	}

}
