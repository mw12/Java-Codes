public class VocaloidsAndSongs {

	private long temp = 0;
	public int count(int S, int gumi, int ia, int mayu)
	{
		if((gumi + ia + mayu ) < S)
		{
			System.out.println(temp);
			return 0;
		}
		else
		{
			System.out.println(temp);
			getposs(S, gumi, ia, mayu);
		}
		
		return 0;
		
	}
	public void getposs(int S,int gumi,int ia , int mayu)
	{
		if(S < 0 || gumi <0 || ia<0 || mayu< 0)
			return;
		if(S==0 && (gumi!=0 |ia != 0 || mayu !=0))
			return;
		
		if(S+gumi+ia+mayu ==0)
			{
			temp++;
			return ;
			
			}
			getposs(S-1, gumi -1, ia -1, mayu-1);
			getposs(S-1, gumi -1, ia -1, mayu);
			getposs(S-1, gumi , ia -1, mayu-1);
			getposs(S-1, gumi -1, ia , mayu-1);
			getposs(S-1, gumi -1, ia, mayu);
			getposs(S-1, gumi , ia-1, mayu);
			getposs(S-1, gumi , ia , mayu-1);
				
		
	}
	public static void main(String[] args) 
	{
	
		VocaloidsAndSongs andSongs = new VocaloidsAndSongs();
		andSongs .count(50,10,10,10);
		//andSongs .count(18,12,8,9);
		


	}

}
