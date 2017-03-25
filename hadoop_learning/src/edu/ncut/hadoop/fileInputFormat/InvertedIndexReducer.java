/**
 * 文件名：InvertedIndexReducer.java
 * 所在包：edu.ncut.hadoop.fileInputFormat
 * 日期：2013-10-25 下午10:07:01
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.fileInputFormat;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：InvertedIndexReducer
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-25 下午10:07:01
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text>{

	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		for(Text value : values){
			context.write(key, value);
		}
	}

}
