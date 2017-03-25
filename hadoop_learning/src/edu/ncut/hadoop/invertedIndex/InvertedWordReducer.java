/**
 * 文件名：InvertedWordReducer.java
 * 所在包：edu.ncut.hadoop.invertedIndex
 * 日期：2013-10-23 下午3:27:29
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.invertedIndex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：InvertedWordReducer
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-23 下午3:27:29
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedWordReducer extends Reducer<Text, Text, Text, Text>{

	private Text outputValues ;
	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String outputValue = "";
		for(Text value : values){
			outputValue += value.toString() + " ; ";
		}
		outputValue.substring(0, outputValue.length()-1);
		outputValues = new Text(outputValue);
		context.write(key, outputValues);
	}
	
	

}
