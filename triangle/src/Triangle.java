/* Author: @TharieHimself */
import java.util.Scanner;
public class Triangle{
	
	
	private Scanner scan;
	public double trian()
	{
		int [][] coordinates  = new int[3][2];
		return calcArea(coordinates);
	
	}
	
	public double calcArea(int coordinates[][])
	{
	   scan = new Scanner(System.in);
	     
	     
	     double[] sides = new double[3];
	     int count = 0;
	     
	     for(int r=0; r<3; r++)
	     {
	    	 for(int c=0; c<2;c++){
	    		 count++;
	    		 //System.out.print("Enter Coordinate "+count+": ");
	    		 coordinates[r][c] = scan.nextInt();
	    	 }
	     }
	     
	     for(int i = 0; i<3; i++)
		{
	     sides[i] = Math.sqrt((Math.pow((coordinates[i][0]- coordinates[(i + 1) % 3][0]), 2)) + Math.pow((coordinates[i][1] - coordinates[(i + 1) % 3][1]), 2));
		}
	     
	     double s = (sides[0]+ sides[1]+ sides[2])/2;
	     double area = Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
	     
	     /* THIS WILL ROUND OFF THE AREA TO THREE DECIMAL PLACES */
	     double roundOff = Math.round(area * 1000.0) / 1000.0;
	  	     
	     scan.close();
	     return roundOff;
	     
	}
	public static void main(String args[])
	{
		Triangle triangle = new Triangle();
		Scanner scanner = new Scanner(System.in);
		//System.out.println("enter the number of traingles");
		int N = scanner.nextInt();
		double num[] = new double[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = triangle.trian();
	}
		double min = java.lang.Double.MAX_VALUE;
		int least=0;
		double max = java.lang.Double.MIN_VALUE;
		int greatest = 0;
		for (int i = 0; i < num.length; i++) {//min
			if (num[i]<min) {
				least = i+1;
				min = num[i];
			}
		}
		System.out.print(least + " ");
		for (int i = 0; i < num.length; i++) {
			if (num[i]>=max) {
				greatest = i+1;
				max = num[i];
			}
		}
		System.out.print(greatest);
		scanner.close();

}
}