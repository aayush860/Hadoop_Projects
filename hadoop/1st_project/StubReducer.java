import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text,IntWritable, Text,Text> {

  
	@Override	 				// hp		(80,90,50)
								// hcl		(70,60)	
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

    int sum=0;
		for(IntWritable i:values)
    {
    	sum=sum+i.get();
    }
		double e=0.1;
		String s=Integer.toString(sum);
		String f=Double.toString(e*sum);
		
		String x=s+"		"+f;
		context.write(key,new Text(x));
	
	}
}