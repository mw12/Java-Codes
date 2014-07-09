public class LSI 
{

	static int calls = 0;
	int maxlength = 1;
	public int recursiveLSI(int array[],int index,int lsiarray[])//with memoization
	{
		calls++;
		if(index==array.length)
			return 0; 
		else
		{
			if(lsiarray[index]!=-1)
				return lsiarray[index];
			int length = 1;
			for (int i = index+1; i < array.length; i++) 
			{
				int forwardprospect = recursiveLSI(array, i,lsiarray);
				if(array[i]>array[index])
				{
					if((1 + forwardprospect) > length)
						length = 1 + forwardprospect;
				}
			}
			if(length > maxlength)
				maxlength = length;
			lsiarray[index] = length;
			return length;
		}
	}
	public int iterativLSI(int array[])//iterative O(n^2)
	{
		int lsiarray[] = new int[array.length];
		if(array.length > 0)
			lsiarray[array.length-1] = 1;
		maxlength =1;
		for (int i = array.length-2; i >=0 ; i--) 
		{
			int max =1;
			for (int j = i+1; j < lsiarray.length; j++) 
			{
				if(array[j]> array[i] && (lsiarray[j]+1)>max)
					max = lsiarray[j] + 1;
			}
			lsiarray[i] = max;
			if(max>maxlength)
				maxlength = max;
		}
		return maxlength;
	}
	public int lincresub(int array[],int index,int lastchoosen)//brute force
	{
		//calls++;
		if(index==array.length)
			return 0;
		else
		{
			int choosen = Integer.MIN_VALUE;
			if(array[index]>lastchoosen)
			{
				choosen = 1 + lincresub(array, index+1, array[index]);
			}	
			int notchoosen = lincresub(array, index+1, lastchoosen);
			
			return Math.max(choosen, notchoosen);
			
		}
	}
	public static void main(String[] args) 
	{
		int array[] =  { 100, 9, 22 ,33, 21, 50, 41, 60, 80 };
		int lsiarray[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		LSI lsi = new LSI();
		System.out.println(lsi.lincresub(array, 0, Integer.MIN_VALUE));
		
//		System.out.println(lsi.recursiveLSI(array, 0,lsiarray) + " length is " + lsi.maxlength);
//		System.out.println("calls are " + calls);
//		System.out.println(lsi.iterativLSI(array));
		

	}

}
