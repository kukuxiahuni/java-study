/**
 * 文件名：FileNameLocInputFormat.java
 * 所在包：edu.ncut.hadoop.fileInputFormat
 * 日期：2013-10-25 下午9:27:18
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.fileInputFormat;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：FileNameLocInputFormat
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-25 下午9:27:18
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class FileNameLocInputFormat extends FileInputFormat<Text,Text>{

	@Override
	public RecordReader<Text, Text> createRecordReader(InputSplit inputSplit,
			TaskAttemptContext context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileNameLocRecordReader fileNameLocReader = new FileNameLocRecordReader();
		fileNameLocReader.initialize(inputSplit, context);
		return fileNameLocReader;
	}


}
