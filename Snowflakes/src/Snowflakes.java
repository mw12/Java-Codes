
public class Snowflakes {

	public String[] flareOut(String[] snowflake)
	{
		char quater[][] = new char[snowflake.length][snowflake.length];
		int length=0;
		for (int i = 0; i < quater.length; i++) 
		{ 
			length++;
			for (int j = 0; j < length; j++) 
			{
				quater[i][j] = snowflake[i].charAt(j);
				if(i!=j)
				{
					quater[j][i] = quater[i][j];
				}
			}
		}
		
		StringBuilder builder2[] = new StringBuilder[snowflake.length*2];
		String re[]  = new String[snowflake.length*2];
		for (int i = 0; i < quater.length; i++) 
		{
			StringBuilder builder = new StringBuilder();
			StringBuilder builder1 = new StringBuilder();
			for (int j = 0; j < quater.length; j++) 
				builder.append(quater[i][j]);
			
			builder1  = new StringBuilder(builder);
			builder1.reverse();
				
			re[i+quater.length] = (builder1 + "" + builder);
			re[quater.length-i-1] = builder1 + "" + builder;
		}
		for(int i=0;i<builder2.length;i++)
		{
			System.out.println(re[i]);
		}
	
		return re;
		
	}
	public static void main(String[] args) {

		Snowflakes snowflakes = new  Snowflakes();
		String snowflake[] = {".",
				 "..",
		 "*.*"};
		snowflakes.flareOut(snowflake);
	}

}
