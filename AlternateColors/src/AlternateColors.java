
public class AlternateColors {

	public String getColor(long r, long g, long b, long k)
	{
		
		int turn = 1;
		int lastturn = 1;
		while(k>0)
		{
			lastturn = turn;
			if (turn==1) 
			{
				if (r>0) {
					r--;
					k--;
					
				}
				
					turn =2;
				
			}
			else if (turn==2) {
				if (g>0) {
					g--;
					k--;
				}
				
					turn =3;
			}
			else
			{
				if (b>0) {
					b--;
					k--;
				}
				
					turn =1;
			}
			//System.out.println(turn);
		}
		if (lastturn==1) {
			return "RED"; 
					
		}
		else if (lastturn==2) {
			return "GREEN";
		}
		else
			return "BLUE";
		
		
		
	}
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		AlternateColors alternateColors = new AlternateColors();
		long r= 1000000000;
		long g= 1;
		long b = 1;
		long k = 1000000002;
		alternateColors.getColor(r, g, b, k);
		long endtime  = System.nanoTime();
		System.out.println("Took "+((endtime - startTime)/1000000)/1000 + " sec"); 

	}

}
