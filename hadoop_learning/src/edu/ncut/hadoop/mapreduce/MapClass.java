/**
 * 文件名：MapClass.java
 * 所在包：edu.ncut.hadoop.mapreduce
 * 日期：2013-8-13 上午9:54:09
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：MapClass
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-8-13 上午9:54:09
 * 修改人：黄传聪
 * 修改时间：2013-8-13 上午9:54:09
 * 修改备注：
 * @version
 */
/**
 * 在hadoop中 ： text(其为对象) == String, Integer == IntWritable
 * 
 * 
 * */
public class MapClass extends Mapper<Object, Text, Text, IntWritable>{
	
	private Text keyText = new Text("key"); //相当于 String keyText = “key”
	private IntWritable intValue = new IntWritable(1); //初始值为1

	@Override
	protected void map(Object key, Text value, org.apache.hadoop.mapreduce.Mapper<Object,Text,Text,IntWritable>.Context context) throws java.io.IOException ,InterruptedException {
		
//		获取值
		String str = value.toString();
//		分词，默认使用空格。此处建议使用split
		StringTokenizer stringTokenizer = new StringTokenizer(str);
//		遍历
		 while (stringTokenizer.hasMoreTokens()) {
	         keyText.set(stringTokenizer.nextToken());
	         context.write(keyText, intValue);   //如果str=“My hh” 则（My，1）（hh，1）
	     }

	}

	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.setup(context);
	}
	
	
}
