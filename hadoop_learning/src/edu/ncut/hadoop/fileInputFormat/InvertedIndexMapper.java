/**
 * 文件名：InvertedIndexMapper.java
 * 所在包：edu.ncut.hadoop.fileInputFormat
 * 日期：2013-10-25 下午9:59:14
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.fileInputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：InvertedIndexMapper
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-25 下午9:59:14
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedIndexMapper extends Mapper<Text, Text, Text, Text>{

	@Override
	protected void map(Text key, Text values,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String value = values.toString();
		StringTokenizer tokenizer = new StringTokenizer(value);
		Text text = new Text();
		while(tokenizer.hasMoreElements()){
			text.set(tokenizer.nextToken());
			System.out.println(text.toString());
			context.write(text, key);
		}
	}

	
}
