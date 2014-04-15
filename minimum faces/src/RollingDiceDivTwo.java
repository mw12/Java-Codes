
public class RollingDiceDivTwo {

	public int minimumFaces(String[] rolls)
	{
		StringBuffer []buffer = new StringBuffer[rolls.length];
		for(int i=0;i<rolls.length;i++)
		{
			StringBuffer temp = new StringBuffer();
			for(int j=0;j<rolls[i].length();j++)
			{
				temp.append(rolls[i].charAt(j));
			}
			buffer[i] = temp;
			System.out.println(temp);
		}
		System.out.println(findmin(buffer));
		return 0;
	}
	public int findmin(StringBuffer []rolls)
	{
		int result = 0;
		for(int k=0;k<rolls[0].length();k++)
		{
			
			int index = 0; 
			int maxout = 0;
			for(int i=0;i<rolls.length;i++)
			{
				int innermax = 0;
				
				for(int j=0;j<rolls[i].length();j++)
				{
					if(innermax<Character.getNumericValue(rolls[i].charAt(j)))
					{
						index=j;
						innermax = Character.getNumericValue(rolls[i].charAt(j));
					}
				}
				rolls[i].setCharAt(index,Character.forDigit(-1,10));
				if(maxout<innermax)
					maxout = innermax;
				
			}
			result += maxout;
			
		}
		
		return result;
	}
	public static void main(String[] args) {

		RollingDiceDivTwo diceDivTwo = new  RollingDiceDivTwo();
		String []rolls = {"281868247265686571829977999522", "611464285871136563343229916655", "716739845311113736768779647392", "779122814312329463718383927626",
"571573431548647653632439431183", "547362375338962625957869719518", "539263489892486347713288936885", "417131347396232733384379841536"};
		diceDivTwo.minimumFaces(rolls);
	}

}
