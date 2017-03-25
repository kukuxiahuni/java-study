/**
 * 文件名：InvertedWordMapper.java
 * 所在包：edu.ncut.hadoop.invertedIndex
 * 日期：2013-10-23 下午3:21:42
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.invertedIndex;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：InvertedWordMapper
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-23 下午3:21:42
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedWordMapper extends Mapper<Object, Text, Text, Text>{

	private Text keyInfo = new Text();
	private Text valueInfo = new Text();
	private FileSplit split;
	@Override
	protected void map(Object key, Text value,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		split = (FileSplit) context.getInputSplit();
		String valueInfos = value.toString();
		StringTokenizer token = new StringTokenizer(valueInfos);
		while(token.hasMoreElements()){
			keyInfo.set(token.nextToken() + " : " + split.getPath());
			valueInfo.set("1");
			context.write(keyInfo, valueInfo);
		}
	}

	
}
