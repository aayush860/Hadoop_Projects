
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

@SuppressWarnings("unused")
public class dricount {

  @SuppressWarnings("deprecation")
public static void main(String[] args) throws Exception {

       if (args.length != 2) {   
       System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
      System.exit(-1);
    }
   
    Job job = new Job();
    job.setJobName("Stub Driver");
    
    job.setMapperClass(mprcount.class);					//define the mapper class
    job.setReducerClass(redcount.class);				//define the reducer class
    job.setJarByClass(dricount.class);					//define the driver class
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    
    Path p1=new Path(args[0]);
    FileInputFormat.addInputPath(job,p1);
    Path p2=new Path(args[1]);
    FileOutputFormat.setOutputPath(job,p2);
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }
}

