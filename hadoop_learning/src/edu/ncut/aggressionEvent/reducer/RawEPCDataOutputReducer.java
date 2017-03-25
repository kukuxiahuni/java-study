/**
 * 文件名：FileOutputReducer.java
 * 所在包：edu.ncut.aggressionEvent.reducer
 * 日期：2013-11-19 上午11:15:48
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.aggressionEvent.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import edu.ncut.aggressionEvent.io.MiddleEventTagData;
/**
 *
 * 项目名称：AggressionEvent
 * 类名称：FileOutputReducer
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-11-19 上午11:15:48
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class RawEPCDataOutputReducer extends Reducer<Text, MiddleEventTagData, Text, IntWritable>{

	@Override
	protected void reduce(Text key, Iterable<MiddleEventTagData> values,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int count = 0;
		for(MiddleEventTagData value : values){
			if(value != null ){
				count += value.getCounts().get();
			}
		}
		context.write(key, new IntWritable(count));
	}
	

}
