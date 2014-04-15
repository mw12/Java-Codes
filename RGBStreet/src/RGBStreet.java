import java.util.Iterator;
import java.util.StringTokenizer;


public class RGBStreet {

	int count=0;
	public int estimateCost(String[] houses)
	{
		
		int red[] = new int[houses.length];
		int blue[] = new int[houses.length];
		int green[] = new int[houses.length];
		int [][] dp = new int[3][houses.length];
		for(int i=0;i<3;i++)
			for(int j=0;j<houses.length;j++)
				dp[i][j] = -1;
		tokenize(houses,red,green,blue);
		System.out.println(findmin(red, green,blue, 0,0,dp));
		System.out.println(count);
		
		return 0;
	}
	public int findmin(int red[],int green[],int blue[],int lastcolor,int i,int dp[][])//red - 1 green - 2 blue -3
	{
		count++;
		if(i==red.length)
			return 0;
		if(lastcolor!=0 && (dp[lastcolor-1][i]!=-1))
			return dp[lastcolor-1][i];
		else
		{
			if(lastcolor==1)
				{
					dp[lastcolor-1][i] = Math.min(green[i] +findmin(red,green,blue,2,i+1,dp),blue[i] + findmin(red,green,blue,3,i+1,dp)); 
					return dp[lastcolor-1][i];
				}
			else if(lastcolor==2)
				
				{
				dp[lastcolor-1][i] = Math.min(red[i] +findmin(red,green,blue,1,i+1,dp),blue[i] + findmin(red,green,blue,3,i+1,dp));
				return dp[lastcolor-1][i];
				}
			else if(lastcolor==3)
				
				{
				dp[lastcolor-1][i] = Math.min(red[i] + findmin(red, green, blue,1,i+1,dp),green[i] +findmin(red,green,blue,2,i+1,dp)); 
				return dp[lastcolor-1][i];
				}
			else
				return Math.min(red[i] + findmin(red, green, blue,1,i+1,dp),
						Math.min(green[i] +findmin(red,green,blue,2,i+1,dp),blue[i] + findmin(red,green,blue,3,i+1,dp)));
			
		}
		
	
	}
	public void tokenize(String[] houses,int red[],int green[],int blue[])
	{
		for(int i=0;i<houses.length;i++)
		{
			StringTokenizer tokens = new StringTokenizer(houses[i]," ");
			while(tokens.hasMoreTokens())
			{
				red[i] = Integer.parseInt(tokens.nextToken());
				green[i] = Integer.parseInt(tokens.nextToken());
				blue[i] = Integer.parseInt(tokens.nextToken());
					
			}
			
		}
	}
	public static void main(String[] args) {

		RGBStreet rgbStreet = new RGBStreet();
		String[] houses = {"71 39 44", "32 83 55", "51 37 63", "89 29 100", 
				 "83 58 11", "65 13 15", "47 25 29", "60 66 19"};
		rgbStreet.estimateCost(houses);

	}

}
