import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ConceptualFilterReduce1 extends Reducer<Text, IntWritable, Text, IntWritable>
{	
	public void reduce(Text indices,Iterable<IntWritable> products,Context context) throws IOException, InterruptedException
	{
		
	}
}
