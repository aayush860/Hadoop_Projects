import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import java.io.*;

public class product implements WritableComparable<product>
{
	private Text brand;
	private Text pname;
    
	
	public product()
    {
    	brand=new Text();
    	pname=new Text();
    }
			
    		public Text getbrand() {
				return brand;
			}
			public void setbrand(Text brand) {
				this.brand = brand;
			}
			public Text getpname() {
				return pname;
			}
			public void setpname(Text pname) {
				this.pname = pname;
			}
/*			
	public boolean equals()												//
{
		product pr=new product();
		if(brand.equals(pr.brand) && pname.equals(pr.pname))
	{return true;}
		else
	{return false;}
}
*/
	@Override
	public int compareTo(product pr) 									//for sorting
	{
		// TODO Auto-generated method stub

		int n=pname.compareTo(pr.pname);
		if(n>0)
		{
			return 1;
		}
		else if(n<0)
		{
			return -1;
		}
		else
			return 0;
	}


	
	public String toString()												//for String display
	{
		String res=brand+"		"+pname;
		return res;
	}
	

	@Override
public void readFields(DataInput arg0) throws IOException {					//Serialize
	// TODO Auto-generated method stub
brand.readFields(arg0);	
pname.readFields(arg0);	
}

@Override
public void write(DataOutput arg0) throws IOException {						//De-Serialize
	// TODO Auto-generated method stub
	brand.write(arg0);	
	pname.write(arg0);	
}


	
}
