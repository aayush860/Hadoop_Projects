import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<ykey,IntWritable, ykey,IntWritable> {

  
	@Override	 				// 2013		  hcl,hp
								// 2014		 hcl,longitech	
  public void reduce(ykey key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

    int sum=0;
		for(IntWritable i:values)
    {
    	sum=sum+i.get();
    }
  		 
    context.write(key,new IntWritable(sum));
  		
  
  }
}