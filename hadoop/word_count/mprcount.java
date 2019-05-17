import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mprcount extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override				//key		   value
						// 0		 My name is aayush
  						// 1		 I study at medicaps
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
String na=value.toString();
 char x[]=na.toCharArray();
 for(int i=0;i<na.length();i++)
 {
	 Text tx=new Text(Character.toString(x[i]));
	 IntWritable iwr=new IntWritable(1);
	 context.write(tx,iwr);
	 }
  }
}

