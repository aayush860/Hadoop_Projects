package aayush;
import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class gst6 extends EvalFunc<String> 
{

	@Override
	public String exec(Tuple t) throws IOException {
		int price=(Integer)t.get(0);
		int rate=2*10;
		int rate1=3*10;
		int x=rate*price;
		int y=rate1*price;
		String z=Integer.toString(x) +"	"+ Integer.toString(y);
		return z;
	}

}
