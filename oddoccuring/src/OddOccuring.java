public class OddOccuring 
{
	int startindex = 0;
	int lastindex = 0;
	public void subarrysum(int array[],int given)
	{
		int sum = 0;
		int temp;
		for (int i = 0; i < array.length; i++) 
		{
			temp = sum + array[i];
			if(temp <given)
			{
				sum = temp;
			}
			else if(temp == given)
			{
				lastindex = i;
				break;
			}
			else
			{
				while(temp> given)
				{
					temp -= array[startindex];
					startindex ++;
				}
				if(temp == given)
				{
					lastindex = i;
					break;
				}
				else
				{
					sum = temp;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		int array[] = {1, 4, 0, 0, 3, 10, 5};
		OddOccuring occuring =  new OddOccuring();
		int given = 7;
		occuring.subarrysum(array,given);
		System.out.println("startindex is " + occuring.startindex + " and lastindex is " + occuring.lastindex);

	}

}
