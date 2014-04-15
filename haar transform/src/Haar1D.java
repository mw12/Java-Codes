import java.util.Scanner;


public class Haar1D {

public int[] transform(int[] data, int L)
{
	modify(data, 1, L, data.length);
	for (int i = 0; i < data.length; i++) {
		System.out.print(data[i] + " ");						
	}
	return data;
}
public void modify(int [] data,int iteration,int  L,int high)
{
	
		int mid = high/2;
		int transformed[] = new int[data.length];
		for(int i=0;i<mid;i++)
		{
			transformed[i] = data[2*i]+ data[2*i+1];
			transformed[mid+i] =   data[2*i] - data[2*i+1] ;
			
		}
		for (int i = 0; i < high; i++) {
			data[i] = transformed[i];
		}
		if(iteration<L)
			modify(data,iteration+1, L,mid);
		
}
	public static void main(String[] args) {
		
		Haar1D haar1d  = new Haar1D();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the array elements number of");
		int num = scan.nextInt();
		//int array[] = new int[num];
//		System.out.println("enter the array elements now");
//		for (int i = 0; i < num; i++) {
//			array[i] = scan.nextInt();
//			
//		}		
		int array[] = {94, 47, 46, 28, 39, 89, 75, 4, 28, 62, 69, 89, 34, 55, 81, 24};
		System.out.println("enter the level of transformationf");
		int iterations = scan.nextInt();
		haar1d.transform(array,iterations);

	}

}
