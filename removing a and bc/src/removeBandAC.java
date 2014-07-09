
public class removeBandAC 
{
	void printstring(int index,String string)
	{
		while(index<string.length())
		{
			if(string.charAt(index)!= 'a' && string.charAt(index)!='b')
			{
				System.out.print(string.charAt(index));
				index++;
			}
			else
			{
				if(string.charAt(index)=='a')
				{
					if(index+1 < string.length())
					{
						if(string.charAt(index+1)=='c')
							index = index+2;
						else 
							{
								System.out.print(string.charAt(index));
								index++;
							}
					}
					else
					{
						System.out.print(string.charAt(index));
						index++;
					}
					
				}
				else//b
				{
					index++;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		removeBandAC ac = new removeBandAC();
		ac.printstring(0, new String("ababac"));
		

	}

}
