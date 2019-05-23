package aayush;
import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class str extends EvalFunc<String>{

	@Override
	public String exec(Tuple t) throws IOException {
	String x=(String)t.get(0);
	String y[]=x.split(" ");
	if(y.length>=1){
	String z=y[0].substring(1);
		return z;
	}else{
		return "wrong";
	}
	}

}
