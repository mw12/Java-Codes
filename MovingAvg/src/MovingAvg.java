import java.util.ArrayList;
import java.util.Collections;
public class MovingAvg {

	public double difference(int k, double[] data)
	{
		ArrayList<Double> arrayList  = new ArrayList<Double>();
		
		for (int i = 0; i <= data.length-k; i++) 
		{
			double sum = 0;
			for (int j = i; j < i+k; j++) 
			{
				sum+= data[j];
			}
			arrayList.add(sum/k);
		}
		return Collections.max(arrayList) - Collections.min(arrayList);
		
	}
		public static void main(String[] args) {
	MovingAvg avg = new MovingAvg();
	double data[] = {3,8,9,15};
	int k = 2;
	avg.difference(k, data);

	}

}
