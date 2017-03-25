/**
 * 文件名：ReduceClass.java
 * 所在包：edu.ncut.hadoop.mapreduce
 * 日期：2013-8-13 上午9:54:20
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：ReduceClass
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-8-13 上午9:54:20
 * 修改人：黄传聪
 * 修改时间：2013-8-13 上午9:54:20
 * 修改备注：
 * @version
 */
/**
 * map 的输出时reduce的输入
 * */
public class ReduceClass extends Reducer<Text, IntWritable, Text, IntWritable>{

	private IntWritable intValue = new IntWritable(0);
	@Override
// 假设key为name，并且出现了两次，则其存储方式为 ： name [1,1](其为value中的值)
	protected void reduce(Text key, Iterable<IntWritable> value,
			Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		while(value.iterator().hasNext()){
			sum += value.iterator().next().get();
		}
		intValue.set(sum);
		context.write(key, intValue);
		
	}

	
	
}
