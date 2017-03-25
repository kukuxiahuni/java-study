/**
 * 文件名：InvertedWordCombiner.java
 * 所在包：edu.ncut.hadoop.invertedIndex
 * 日期：2013-10-23 下午3:32:27
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
 * 类名称：InvertedWordCombiner
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-23 下午3:32:27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedWordCombiner extends Reducer<Text, Text, Text, Text>{

	private Text newKey ;
	private Text newValue;
	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		int count = 0;
		for(Text value : values){
			count += Integer.valueOf(value.toString());
		}
		
		String keys[] = key.toString().split(":");
		newKey = new Text(keys[0]);
		newValue = new Text("[ " + keys[1] + " " + count + " ]");
		context.write(newKey, newValue);
	}

	
}
