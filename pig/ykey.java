import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import java.io.*;

public class ykey implements WritableComparable<ykey>{
	
	
	private IntWritable year;
	private Text brand;
	
	
	public ykey()
	{
	year=new IntWritable();
	brand=new Text();
	}
	
	
	

	public IntWritable getyear() {
		return year;
	}
	public void setyear(IntWritable year) {
		this.year = year;
	}
	public Text getbrand() {
		return brand;
	}
	public void setbrand(Text brand) {
		this.brand = brand;
	}



	public String toString()												//for String display
	{
		String res=year+"	"+brand;
		return res;
	}
	@Override
	public int compareTo(ykey yk) {
		// TODO Auto-generated method stub
		int r=year.compareTo(yk.year);
		if(r>0)
		{return 1;
		}
		else if(r<0)
		{return -1;
		}
		else
		{
			int n=brand.compareTo(yk.brand);
			return n;
		}
			
	}
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		year.readFields(arg0);
		brand.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		year.write(arg0);
		brand.write(arg0);
	}

	

}
