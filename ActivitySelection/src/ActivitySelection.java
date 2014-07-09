
public class ActivitySelection 
{
	int maximum = 1;
	int maxactivities(int start[],int finish[],int index)// the activities must be sorted by finish time
	{
		if(index==start.length-1)
			return 1;
		else
		{
			int maxact = 1;
			for (int i = index+1; i < finish.length; i++) 
			{
				int temp = 1 + maxactivities(start, finish, i);
				if(start[i]>=finish[index])
				{
					if(temp > maxact)
						maxact = temp;
				}
			}
			if(maxact > maximum)
				maximum = maxact;
			return maxact;
		}
	
	}
	public static void main(String[] args) 
	{
		ActivitySelection activitySelection = new ActivitySelection();
		int start[] = {0,1,2,3,5,5,6,8,8,12};//{1,3,0,5,3,5,6,8,8,2,12};
		int finish[] = {6,4,14,5,7,9,10,11,12,14};//{4,5,6,7,9,9,10,11,12,14,16};
		activitySelection.maxactivities(start, finish, 0);
		System.out.println("the no of activities are " + activitySelection.maximum);
		

	}

}
