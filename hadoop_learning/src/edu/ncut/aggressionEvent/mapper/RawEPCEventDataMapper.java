

package edu.ncut.aggressionEvent.mapper;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import edu.ncut.main.MainApi.Counter;
/**
 * 
 * 项目名称：AggressionEvent 类名称：FileInputMapper 类描述： 创建人：黄传聪 创建时间：2013-11-18
 * 下午3:54:52 修改人： 修改时间： 修改备注：
 * 
 * @version
 */
public class RawEPCEventDataMapper extends Mapper<Object, Text, Text, Text> {
	
	/** 订阅文件的名称 */
//	private String fileName;
//	private Text epcData ;
//	private MiddleEventTagData middleEventTagData ;
//	/** 读取次数   */    
//	private IntWritable count = new IntWritable(1);

	/**
	 * 获取外部参数 初始化具体信息
	 * 
	 * @param job
	 * @see org.apache.hadoop.mapred.MapReduceBase#configure(org.apache.hadoop.mapred.JobConf)
	 */
	@Override
	protected void map(Object lineNum, Text values, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		try{
			System.out.println("lineNum: " + lineNum);
			String str = values.toString();
			System.out.println("str : " + str);
			String[] strs = str.split(" ");
			context.write(new Text("0"), new Text("0"));
			
		}catch(ArrayIndexOutOfBoundsException e){
			//出错之后计数器进行加1
			context.getCounter(Counter.LINESKIP).increment(1);
			return;
		}
	}

//	@Override
//	protected void setup(Context context) throws IOException,
//			InterruptedException {
//		// TODO Auto-generated method stub
//
//		Configuration conf = context.getConfiguration();
//		// 获取配置信息
//		fileName = conf.get("ECSpec.file.fileName");
//		System.out.println("fileName" + fileName);
//		ecSpec = XmlParser.generateECSpec(fileName);
//		System.out.println("ecSpec toString : " + ecSpec.toString());
//	}

}
