import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.*;

public class StubReducerf extends Reducer<Text,IntWritable, Text,Text> {

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void setup( @SuppressWarnings("rawtypes") org.apache.hadoop.mapreduce.Reducer.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("name"),new Text("sales"));
		super.setup(context);
		
	}

	
	
	
	
	
	
	
	
	
	
	static double xz=0;
	@Override	 				// hp		(80,90,50)
								// hcl		(70,60)	
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
		FileOutputStream fos=new FileOutputStream("/home/cloudera/fff.txt");					//address
    double sum=0;
		for(IntWritable i:values)
    {
    	sum=sum+i.get();
    
		double e=0.1;
		String x=Double.toString(sum)+"		"+Double.toString(e*sum);
		
		context.write(key,new Text(x));
		
		xz=xz+sum;
 	
		String y=key.toString();
		String fin=y+"		"+x;
		
		
		char p[]=fin.toCharArray();
	
		for(int u=0;u<fin.length();u++)
		{
		fos.write(p[u]);
		}
    }	
	
		fos.close();
    							}

	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void cleanup(@SuppressWarnings("rawtypes") org.apache.hadoop.mapreduce.Reducer.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("TOTAL"),new DoubleWritable(xz));
		super.cleanup(context);
	}


	}