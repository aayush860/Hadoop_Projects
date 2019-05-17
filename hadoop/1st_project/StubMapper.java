import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override				//key		   value
						// 0		 2013,hp,mouse,50
  						// 1		 2013,hcl,keyboard,231
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
String s=value.toString();
String data[]=s.split(",");
//String t=s.substring(0,5)+data[1];


IntWritable wr=new IntWritable(Integer.parseInt(data[3]));
Text tx=new Text(data[1]);
context.write(tx,wr);

  }
}
