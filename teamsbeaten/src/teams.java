import java.util.ArrayList;

/*
 * you are given a matrix containing info about whether a team has been beaten or has beaten that team..
 * now you need to find out no of ways to arrange the teams in such an order that the team on the left must
 * have beaten the team on the right of it...
 */

public class teams {
	//System.out.print("here with index as " + index);
//	System.out.print(" and array as ");
//	for(int i = 0;i<array.size();i++)
//		System.out.print(" " + array.get(i));
//	System.out.println();
	public int getnoofways(int [][]matrix,int index,ArrayList<Integer> array)
	{
//		
		if(index==matrix.length)
			{
			System.out.println("returned with 1");
			return 1;
			}
		if(array.size()==0)
			{
			System.out.println("returnig with 0");
			return 0;
			}
		
		int sum = 0;
		
		for(int i=0;i<array.size();i++)
		{
			ArrayList<Integer> newarray = new ArrayList<Integer>();
			for(int j=0;j<matrix.length;j++)
			{
				if(matrix[array.get(i)-1][j]==array.get(i))
					newarray.add(j+1);
		
			}
			if(getnoofways(matrix, index+1,newarray)>0)
			{
				System.out.println("the value chosen is " + array.get(i));
				sum ++;
			}
		}
		return sum;
			
	}
	public static void main(String[] args) {
	
		teams team = new teams();
		int [][]matrix = {{0,1,1,1},{1,0,2,2},{1,2,0,4},{1,2,4,0}};
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<matrix.length;i++)
			list.add(i,i+1);
		
		System.out.println(team.getnoofways(matrix,0,list));

	}

}
