public class ShorterSuperSum {

	int flag=1;
	
	public int calculate(int k, int n)
	{
		int [][] arr = new int[k][n];
		for(int i=0;i<k;i++)
			for(int j=0;j<n;j++)
				{
				arr[i][j] = -1;
				//System.out.print(" " + arr[i][j]);
				}
		 System.out.println(find(k, n, arr,flag));
		 for(int i=0;i<k;i++)
		 {
			 for(int j=0;j<n;j++)
					System.out.print(" " + arr[i][j]);
			 System.out.println();
		 }
			
		 
		 return 0;
		
	}
	public int find(int k,int n,int arr[][],int flag)
	{		
			if(k==0)
				{
					arr[0][n-1]= n;
					return n;
				}
			if(flag!=1 && arr[k][n-1]!=-1)
			{
				int sum = 0;
				for(int i =0;i<=n-1;i++)
					sum += arr[k-1][i];
				return sum;
			}
			else
			{
				int sum = 0;
				for(int i=1;i<=n;i++)
				{
					sum += find(k-1,i,arr,2);
				}
				if(flag!=1)
					arr[k][n-1] = sum;
				return sum;
			}
		
	}
	
	public static void main(String[] args) {
		
		ShorterSuperSum shorterSuperSum = new ShorterSuperSum();
		shorterSuperSum.calculate(2,3);
	}

}
