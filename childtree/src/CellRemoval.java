import java.util.ArrayList;
public class CellRemoval {

	public int cellsLeft(int[] parent, int deletedCell)
	{
		int index = 0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(deletedCell);
		while(index<arrayList.size())
		{
			for (int i = 0; i < parent.length; i++) 
			{
				if (parent[i]==arrayList.get(index)) {
					arrayList.add(i);
				}
			}
			index++;
		}
		for (int i = 0; i < arrayList.size(); i++) 
			parent[arrayList.get(i)]=-2;
		
		int count=0;
		for (int i = 0; i <parent.length; i++) {
			if (parent[i]!=-2) 
			{
				int j=0;
				for (;j <parent.length;j++) 
				{
					if(parent[j]==i)
						break;
				}
				if (j==parent.length) 
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
	CellRemoval cellRemoval = new CellRemoval();
	int parent[] = {26,2,32,36,40,19,43,24,30,13,21,14,24,21,19,4,30,10,44,12,7,32,17,43,
		 35,18,7,36,10,16,5,38,35,4,13,-1,16,26,1,12,2,5,18,40,1,17,38,44,14};
//	int parent[]  ={-1,0,0,1,1};
	int deletedCell =24;
	
	System.out.println( cellRemoval.cellsLeft(parent, deletedCell));

	}

}
