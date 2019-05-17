import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class redazcount extends Reducer<Text, IntWritable, Text, IntWritable> {

  @Override			
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
    String f=key.toString();
    char[] d=f.toCharArray();
	  int sum=0;
	 // int j=0;
    for(IntWritable i:values)
    { 	    	sum=sum+i.get();
    }
 
    if(96<(int)d[0] && (int)d[0]<123)
	{
    context.write(key,new IntWritable(sum));
	}
    
    
    
    
    
    }
}