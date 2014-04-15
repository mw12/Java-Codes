import java.util.ArrayList;
import java.util.Collections;


public class FanFailure {

	public int[] getRange(int[] capacities, int minCooling)
	{
		ArrayList<Integer> list = new ArrayList<Integer>(capacities.length);
		for(int i=0;i<capacities.length;i++)
			list.add(i, capacities[i]);
		Collections.sort(list);
		int mfs=0;
		while((sum(list,mfs,capacities.length)-list.get(mfs))>minCooling)
			mfs++;
		int index = capacities.length;
		int mfc = 0;
		while((sum(list,0,index)-list.get(index-1))>minCooling)
			{
			index--;
			mfc++;
			}
		int result[] = new int[2];
		result[0] = mfs;
		System.out.println("mfs is " + mfs);
		result[1] = mfc;
		System.out.println("mfc	is " + mfc);
		return result;
	}
	public int sum(ArrayList<Integer> list,int start,int last)
	{
		int sum=0;
		for(int i=start;i<last;i++)
			sum += list.get(i);
		return sum;

	}
	public static void main(String[] args) {
		FanFailure failure = new FanFailure();
		int []capacities = {955, 96, 161, 259, 642, 242, 772, 369, 311, 785,
				 92, 991, 620, 394, 128, 774, 973, 94, 681, 771,
				 916, 373, 523, 100, 220, 993, 472, 798, 132, 361,
				 33, 362, 573, 624, 722, 520, 451, 231, 37, 921,
				 408, 170, 303, 559, 866, 412, 339, 757, 822, 192};
		int minCooling = 3619;
		failure.getRange(capacities, minCooling);
	

	}

}
