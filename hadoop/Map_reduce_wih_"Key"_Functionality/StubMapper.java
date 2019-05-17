import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<LongWritable, Text, ykey, IntWritable> {

  @Override				//key		   value
						// 0		 2013,hp,mouse,50
  						// 1		 2013,hcl,keyboard,231
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
String s=value.toString();
String data[]=s.split(",");


IntWritable wr=new IntWritable(Integer.parseInt(data[3]));
IntWritable tx=new IntWritable(Integer.parseInt(data[0]));
Text tx1=new Text(data[1]);
ykey yk=new ykey();
yk.setyear(tx);
yk.setbrand(tx1);
context.write(yk,wr);

  }
}
