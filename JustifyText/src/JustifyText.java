public class JustifyText //O(n^2) with DP
{
	int linewidth = 15;
	int mincost = Integer.MAX_VALUE;
	String optimal = null;
	void justify(String sentence,int costtillnow,String justified)
	{
		if(sentence.length()<=linewidth)
		{
			if(costtillnow < mincost)
			{
				mincost = costtillnow;
				optimal = new StringBuffer(justified).append(sentence).toString();
			}
		}
		else
		{
			
			for (int linebreak = 1; linebreak < sentence.length() && linebreak<=linewidth; linebreak++) 
			{
				if(sentence.charAt(linebreak)==' ')
				{
					
					double costhere = Math.pow((linewidth - linebreak),3);
					justify
					(
							sentence.substring(linebreak+1),
							costtillnow + (int)costhere,
							new StringBuffer().append(justified + sentence.subSequence(0, linebreak) + "\n").toString()
					);
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		JustifyText justifyText = new JustifyText();
		justifyText.justify("Geeks for Geeks presents word wrap problem",0,new String());
		System.out.println("the cost is " + justifyText.mincost + " and string is " + justifyText.optimal);
	}

}
