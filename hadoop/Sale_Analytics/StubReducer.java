import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text,IntWritable, Text,Text> {

	
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

    double sum=0;
		for(IntWritable i:values)
    {
    	sum=sum+i.get();
    
		double e=0.1;
		String s=Double.toString(sum);
		String f=Double.toString(e*sum);
		
		String x=s+"		"+f;
		context.write(key,new Text(x));
		xz=xz+sum;
    }
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void cleanup(@SuppressWarnings("rawtypes") org.apache.hadoop.mapreduce.Reducer.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("TOTAL"),new DoubleWritable(xz));
		super.cleanup(context);
	}


	}