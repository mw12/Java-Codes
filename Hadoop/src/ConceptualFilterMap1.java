import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer.Context;

import com.cedarsoftware.util.io.JsonReader;


public class ConceptualFilterMap1 extends Mapper<LongWritable, Text, Text, Text>
{
	public void setup(Context context) throws IOException, InterruptedException 
    {
    	Configuration conf = context.getConfiguration();
    	String mapstring = conf.get("map");
    	
		StringBuffer sf = new StringBuffer(mapstring);
		
		InputStream is = new ByteArrayInputStream(sf.toString().getBytes());
		
		JsonReader reader = new JsonReader(is);
		Map<String, Integer> readMap = (HashMap)reader.readObject();
		
		for(String key: readMap.keySet())
		{
			System.out.println(key + " -> " + readMap.get(key));
		}
    }  
	


	public void map(LongWritable offset,Text line,Context context) throws IOException,InterruptedException
	{
		
	}
	

}
