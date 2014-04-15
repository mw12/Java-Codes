public class meat {

	public int findmin(int [] meatballs,int index,int taken,int wanted,int left)
	{
		if(left<(wanted-taken))
			
			{
			System.out.println("here");
			return 1000;
			}
		if(taken>=wanted)
		{
			System.out.println("There");
			return 0;
		}
		if(index==meatballs.length)
		{
			System.out.println("length");
			return 1000;
		}
			
		else
		{
			System.out.println("else");
			return Math.min(1+findmin(meatballs, index+1,taken + meatballs[index],wanted,left-meatballs[index]),findmin(meatballs,index+1,taken,wanted,left));
		}
	}
	
	public static void main(String[] args) {
		meat me = new meat();
		
		int []meatballs = {1,2,3,4};
		int wanted = 7;
		System.out.println(me.findmin(meatballs,0,0,wanted,10));
		

	}

}
