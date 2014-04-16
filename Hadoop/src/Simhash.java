import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.jobcontrol.JobControl;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.jobcontrol.ControlledJob;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.mahout.math.DenseMatrix;
import org.apache.mahout.math.Matrix;
import org.apache.mahout.math.SingularValueDecomposition;

import conceptual.MatrixImplementor;

public class Simhash implements Tool
{
	public int run(String[] args) throws Exception 
	{
		/**
		 * ******** shinglecount**********
		 **/
//		Job shinglecount =  Job.getInstance(getConf(),"shinglecount");
//
//		shinglecount.setMapperClass(shinglemapper.class);
//		shinglecount.setReducerClass(shinglereducer.class);
//		
//		shinglecount.setOutputKeyClass(Text.class);
//		shinglecount.setOutputValueClass(IntWritable.class);
//		
//		FileInputFormat.addInputPath(shinglecount, new Path(args[0]));
//	    FileOutputFormat.setOutputPath(shinglecount, new Path(args[1]));
//	    
//	    /*
//		 * ******** docshavingterm**********
//		 * calculating no of documents that contain that term
//		 */
//	    
//	    Job docshavingterm = Job.getInstance(getConf(), "docscontaingword");
//	    
//	    docshavingterm.setMapperClass(docshavingtermmapper.class);
//	    docshavingterm.setReducerClass(docshavingtermreducer.class);
//	    
//	    docshavingterm.setMapOutputKeyClass(Text.class);
//	    docshavingterm.setMapOutputValueClass(Text.class);
//	    
//	    docshavingterm.setOutputKeyClass(Text.class);
//	    docshavingterm.setOutputValueClass(IntWritable.class);
//	    
//	    FileInputFormat.addInputPath(docshavingterm, new Path(args[1]));
//	    FileOutputFormat.setOutputPath(docshavingterm, new Path(args[2]));
//	    
//	    /*
//		 * ******** termstfidf**********
//		 * tfidf computation of the term
//		 */
//	    
//	    Job tfidf = Job.getInstance(getConf(), "tfidf computation");
//	    
//	    tfidf.setMapperClass(tfidfmapper.class);
//	    tfidf.setReducerClass(tfidfreducer.class);
//	    
//	    tfidf.setMapOutputKeyClass(Text.class);
//	    tfidf.setMapOutputValueClass(Text.class);
//	    
//	    tfidf.setOutputKeyClass(Text.class);
//	    tfidf.setOutputValueClass(IntWritable.class);
//	    
//	    FileInputFormat.addInputPath(tfidf, new Path(args[2]));
//	    FileOutputFormat.setOutputPath(tfidf, new Path(args[3]));
//	    
//	    /*
//		 * ******** shingletfidf**********
//		 * shingling and hashing them
//		 */
//	    
//	    
//	    Job shingletfidf = Job.getInstance(getConf(), "shingle tfidf");
//	    
//	    shingletfidf.setMapperClass(shingletfidfmapper.class);
//	    shingletfidf.setReducerClass(shingletfidfreducer.class);
//	    
//	    shingletfidf.setOutputKeyClass(Text.class);
//	    shingletfidf.setOutputValueClass(Text.class);
//	    
//	    FileInputFormat.addInputPath(shingletfidf, new Path(args[3]));
//	    FileOutputFormat.setOutputPath(shingletfidf, new Path(args[4]));
//
//	    
//	    /*
//		 * ******** fingerprint**********
//		 *
//        */
//	    
//	    
//	    Job fingerprint = Job.getInstance(getConf(), "docfingerprint");
//	    
//	    fingerprint.setMapperClass(fingerprintmapper.class);
//	    fingerprint.setReducerClass(fingerprintreducer.class);
//	    
//	    fingerprint.setOutputKeyClass(Text.class);
//	    fingerprint.setOutputValueClass(Text.class);
//	    
//	    FileInputFormat.addInputPath(fingerprint, new Path(args[4]));
//	    FileOutputFormat.setOutputPath(fingerprint, new Path(args[5]));
//	    
//	    
//	    /*
//	     *	Rotation of bits
//	     */
//		
//	    Job deduplication  = Job.getInstance(getConf(), "deduplication");
//	    
//	    deduplication.setMapperClass(deduplicationmapper.class);
//	    deduplication.setReducerClass(deduplicationreducer.class);
//	    
//	    deduplication.setMapOutputKeyClass(IntWritable.class);
//	    deduplication.setMapOutputValueClass(Text.class);
//	    
//	    deduplication.setOutputKeyClass(Text.class);
//	    deduplication.setOutputValueClass(Text.class);
//	    
//	    FileInputFormat.addInputPath(deduplication, new Path(args[5]));
//	    FileOutputFormat.setOutputPath(deduplication, new Path(args[6]));
//	    
//	    /*
//		 * ******** Job control**********
//		 * 
//		 */
//	    
//	    ControlledJob controlledJob1 =  new ControlledJob(shinglecount, null);
//	    ControlledJob controlledJob2 = new ControlledJob(docshavingterm,null);
//	    controlledJob2.addDependingJob(controlledJob1);
//	    
//	    
//	    ControlledJob controlledJob3 =  new ControlledJob(tfidf, null);
//	    controlledJob3.addDependingJob(controlledJob2);
//	    
//	    
//	    ControlledJob controlledJob4 =  new ControlledJob(shingletfidf, null);
//	    controlledJob4.addDependingJob(controlledJob3);
//	    
//	    ControlledJob controlledJob5 =  new ControlledJob(fingerprint, null);
//	    controlledJob5.addDependingJob(controlledJob4);
//	    
//	    
//	    
//	    
//	    ControlledJob controlledJob6 =  new ControlledJob(deduplication, null);
//	    controlledJob6.addDependingJob(controlledJob5);
//	    
	    JobControl control =  new JobControl("Simhash");
//	    
//	    control.addJob(controlledJob1);
//	    control.addJob(controlledJob2);
//	    control.addJob(controlledJob3);
//	    control.addJob(controlledJob4);
//	    control.addJob(controlledJob5);
//	    control.addJob(controlledJob6);
//	    
//	    
	    /*ControlledJob controlledJob7 =  new ControlledJob(matrixmultiplication1, null);
	    ControlledJob controlledJob8 =  new ControlledJob(matrixmultiplication2, null);
	    
	    controlledJob8.addDependingJob(controlledJob7);
	    
	    control.addJob(controlledJob7);
	    control.addJob(controlledJob8);*/
	    
	    /*Job tdm1 =  Job.getInstance(getConf(),"tdm1");

		tdm1.setMapperClass(tdmMap1.class);
		tdm1.setReducerClass(tdmReducer1.class);
		
		tdm1.setOutputKeyClass(Text.class);
		tdm1.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(tdm1, new Path(args[0]));
	    FileOutputFormat.setOutputPath(tdm1, new Path(args[1]));
	    
	    ControlledJob controlledJob9 =  new ControlledJob(tdm1, null);
	    control.addJob(controlledJob9);
	    
	    Job tdm2 =  Job.getInstance(getConf(),"tdm2");

		tdm2.setMapperClass(tdmMapper2.class);
		tdm2.setReducerClass(tdmReducer2.class);
		
		tdm2.setOutputKeyClass(Text.class);
		tdm2.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(tdm2, new Path(args[1]));
	    FileOutputFormat.setOutputPath(tdm2, new Path(args[2]));
	    
	    ControlledJob controlledJob10 =  new ControlledJob(tdm2, null);
	    control.addJob(controlledJob10);
	    
	    controlledJob10.addDependingJob(controlledJob9);
	    
	    
	    Job tdm3 =  Job.getInstance(getConf(),"tdm3");

		tdm3.setMapperClass(tdmMapper3.class);
		tdm3.setReducerClass(tdmReducer3.class);
		
		tdm3.setOutputKeyClass(Text.class);
		tdm3.setOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(tdm3, new Path(args[1]));
	    FileOutputFormat.setOutputPath(tdm3, new Path(args[2]));
	    
	    ControlledJob controlledJob11 =  new ControlledJob(tdm3, null);
	    control.addJob(controlledJob11);
	    
	    controlledJob11.addDependingJob(controlledJob10);*/
	   
    	Job matrixmultiplication1 =  Job.getInstance(getConf(),"matrixmultiplication1");

		matrixmultiplication1.setMapperClass(MatrixMultiplicationMap1.class);
		matrixmultiplication1.setReducerClass(MatrixMultiplicationReduce1.class);
		
		matrixmultiplication1.setOutputKeyClass(IntWritable.class);
		matrixmultiplication1.setOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(matrixmultiplication1, new Path(args[0]));
	    FileOutputFormat.setOutputPath(matrixmultiplication1, new Path(args[1]));
	    

		Job matrixmultiplication2 =  Job.getInstance(getConf(),"matrixmultiplication2");

		matrixmultiplication2.setMapperClass(MatrixMultiplicationMap2.class);
		matrixmultiplication2.setReducerClass(MatrixMultiplicationReduce2.class);
		
		matrixmultiplication2.setOutputKeyClass(Text.class);
		matrixmultiplication2.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(matrixmultiplication2, new Path(args[1]));
	    FileOutputFormat.setOutputPath(matrixmultiplication2, new Path(args[2]));

	    ControlledJob controlledJob11 =  new ControlledJob(matrixmultiplication1, null);
	    ControlledJob controlledJob12 =  new ControlledJob(matrixmultiplication2, null);
	    
	    control.addJob(controlledJob11);
	    control.addJob(controlledJob12);
	    
	    controlledJob12.addDependingJob(controlledJob11);
	    
	    MatrixImplementor mi = new MatrixImplementor();
    	DenseMatrix tdm = mi.buildmatrix("/home/sahil/tdm3", matrixmultiplication1.getConfiguration());
    	SingularValueDecomposition svd = mi.getsvd(tdm);
    	
    	Matrix U = svd.getU();
    	Matrix S = svd.getS();
    	Matrix V = svd.getV();
    	
    	Matrix Vtranspose = V.transpose();
    	int columnsS = S.columnSize(); //dont know exactly which matrices to multiply
    	int rowsS = S.rowSize();
    	
    	mi.writetofile(S, new Path("/home/sahil/svd1/matrix1"), matrixmultiplication1.getConfiguration());
    	mi.writetofile(Vtranspose, new Path("/home/sahil/svd1/matrix2"), matrixmultiplication1.getConfiguration());
    	
    	
    	
	    
	    Thread thread =  new Thread(control);
	    thread.setDaemon(true);
	    thread.start();
	    
	    while(true)
	    {
	    	if (control.allFinished())
		    {
	    		control.stop();
	    		break;
			}
	    }
	    
	    
	    return 0;
	}
	public static void main(String[] args) throws Exception
	{
		if(args.length !=3)
		{
			System.out.println("the arguments are too many or too less");
			System.exit(1);
		}
		else
		{
			ToolRunner.run(new Simhash(), args);
		}
	}
	@Override
	public Configuration getConf() 
	{
		return new Configuration();
	}
	@Override
	public void setConf(Configuration arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
	

}
