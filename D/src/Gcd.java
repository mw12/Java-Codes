
public class Gcd {

	
		public int findgcd(int array[],int low,int high)
		{
			if(low==high)
				return array[high];
			if(high-low==1)
				return gcd(array[low],array[high]);
			else
			{
				int mid  = array.length/2;
				return (gcd(findgcd(array,low,mid),findgcd(array,mid+1,high)));
			}
		}
		
		public int gcd(int a,int b)
		{
			if(a<b)
			{	
				if(b%a==0)
					return a;
				else
					return gcd(b%a,a);
			}
			else
			{
				if(a%b==0)
					return b;
				else
					return gcd(a%b,b);
			}
		}

		
	

	public static void main(String[] args) {
		int array[] = {4,7,5};
		Gcd gcd = new Gcd();
		System.out.println(gcd.findgcd(array,0,array.length-1));

	}

}
