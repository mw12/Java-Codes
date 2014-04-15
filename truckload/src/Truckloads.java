import java.util.Scanner;


public class Truckloads {

	public int numTrucks(int numCrates, int loadSize)
	{
		return getpartitions( 0, numCrates, loadSize);
	}
	public int getpartitions(int low,int high,int loadSize)
	{
		System.out.println("called with low as " + low +  "high as " + high);
			if (high-low<=loadSize) 
				return 1;
			else
			{
				int mid =low +  (high-low)/2;
				System.out.println("mid is "+ mid);
				return getpartitions(low,mid, loadSize) + getpartitions( mid, high, loadSize);
				
				
			}
		
	}

	public static void main(String[] args) {
		Truckloads truckloads = new Truckloads();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the total number of crates u want to ship");
		int numCrates = scan.nextInt();
		System.out.println("enter the max size of crate that can be carried");
		int loadSize = scan.nextInt();
		System.out.println(truckloads.numTrucks(numCrates, loadSize));
		
		
		
	}

}
