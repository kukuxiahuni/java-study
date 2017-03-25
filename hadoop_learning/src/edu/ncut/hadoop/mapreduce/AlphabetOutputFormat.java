/**
 * 文件名：AlphabetOutputFormat.java
 * 所在包：edu.ncut.hadoop.mapreduce
 * 日期：2013-8-16 下午6:01:45
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapred.lib.MultipleOutputFormat;
import org.apache.hadoop.util.Progressable;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：AlphabetOutputFormat
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-8-16 下午6:01:45
 * 修改人：黄传聪
 * 修改时间：2013-8-16 下午6:01:45
 * 修改备注：
 * @version
 */
public class AlphabetOutputFormat extends MultipleOutputFormat<Text, IntWritable>{

	@Override
	protected String generateFileNameForKeyValue(Text key, IntWritable value,
			String name) {
		// TODO Auto-generated method stub
		char c = key.toString().toLowerCase().charAt(0);
		if(c>='a' && c<='z'){
			return c + ".txt";
		}else{
			return "other.txt";
		}
		
	}

	@Override
	protected RecordWriter<Text, IntWritable> getBaseRecordWriter(
			FileSystem arg0, JobConf arg1, String arg2, Progressable arg3)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
