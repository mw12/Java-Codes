
public class editdistance 
{
	String first = "ABD";
	String second = "BC";
	int deletecost = 1;
	int insertcost = 1;
	int replacecost = 1;
			
	public int editDistance(int index1,int index2)//second string is to be formed from second
	{
		if(index1==first.length())
		{
			if(index2==second.length())
				return 0;
			else
			{
				return second.length()-index2;
			}
			
		}
		else
		{
			if (index2==second.length())
			{
				return first.length()-index1;
					
			}
			else
			{
				if(first.charAt(index1)==second.charAt(index2))
					return editDistance(index1+1, index2+1);
				else
				{
					return Math.min
							(
									(editDistance(index1+1, index2)+deletecost),//deleted from first string
									Math.min
									(
											(editDistance(index1, index2+1)+insertcost),//inserted in first string
											(editDistance(index1+1, index2+1) + replacecost)
									)
							);
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		editdistance edit = new editdistance();
		System.out.println(edit.editDistance(0, 0));

	}

}
