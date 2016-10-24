package hadoop.TianChiUdf;

import com.aliyun.odps.io.LongWritable;
import com.aliyun.odps.udf.UDF;

/***
 * BASE UDF
 */
public final class MyUDF extends UDF {
	
	private Long result ;  
	  
    public MyUDF() {  
      result=(long) 0;  
    }  
    /**
     * UDF Evaluate接口
     * 
     * UDF在记录层面上是一对一，字段上是一对一或多对一。 Evaluate方法在每条记录上被调用一次，输入为一个或多个字段，输出为一个字段
     */
    public Long evaluate() {
        // TODO: 请按需要修改参数和返回值，并在这里实现你自己的逻辑
    	result=result + 1;  
        return result; 
    }
}
