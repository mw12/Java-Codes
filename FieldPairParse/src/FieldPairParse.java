import java.util.ArrayList;
public class FieldPairParse {

	public int[] getPairs(String[] data)

	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < data[0].length(); i++) 
		{
			if (data[0].charAt(i)==' ' && checkvalid(data, i))
			{
					int j=i+1;
					int count =1;
					while(data[0].charAt(j)==' ' && checkvalid(data, j))
					{
						count++;
						j++;
					}
					arrayList.add(count);
					i=j	;
				
			}
			
		}
		
		if (arrayList.size()%2 ==0) {
			
			int result[] = new  int[0];
			return result;
		}
		else
		{
			int result[] = new  int[arrayList.size()];
			for(int i=0;i<arrayList.size();i++)
				{
				
				System.out.print(arrayList.get(i) + " ");
				result[i] = arrayList.get(i);
				}
			return result;
		}
		
		
		
	}
	public boolean checkvalid(String []data,int i)
	{
		boolean valid = true;
		for (int j = 0; j < data.length; j++) 
		{
			if (data[j].charAt(i)!=' ') 
			{
				valid = false;
				break;
			}
		}
		return valid;
	}
	public static void main(String[] args) {

		FieldPairParse fieldPairParse =  new FieldPairParse();
		String[] data = {"X X X", "X X X"};
		fieldPairParse.getPairs(data);

	}

}
