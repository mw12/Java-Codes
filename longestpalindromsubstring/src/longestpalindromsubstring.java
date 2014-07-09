
public class longestpalindromsubstring 
{
	int minindex = 0;
	int maxindex = 0;
	int length = 0;
	public boolean LCP(String string,int i,int j)
	{
		if(i>j)
			return true;
		else if(i==j && string.charAt(i) == string.charAt(j))
		{
			if((length)< 1)
			{
				maxindex = minindex = i;
				length = 1;
			}
				return true;
		}
		else if(i==j)
			return false;
		else
		{
			if(string.charAt(i)==string.charAt(j) && LCP(string, i+1, j-1))
			{
				if(length < (j-i))
				{
					length = j-i+1;
					minindex = i;
					maxindex = j;
				}
				return true;
			}
			else
			{
				LCP(string,i+1,j);
				LCP(string,i,j-1);
				
				return false;
			}
		}
			
	}
	public static void main(String[] args) 
	{
		longestpalindromsubstring longestpal =  new longestpalindromsubstring();
		String string = "forgeeksskeegfor";
		longestpal.LCP(string, 0, string.length()-1);
		System.out.println(string.substring(longestpal.minindex, longestpal.maxindex+1));

	}

}
