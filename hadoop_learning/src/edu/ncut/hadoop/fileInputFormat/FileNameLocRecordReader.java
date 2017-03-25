/**
 * 文件名：FileNameLocRecordReader.java
 * 所在包：edu.ncut.hadoop.fileInputFormat
 * 日期：2013-10-25 下午9:30:10
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
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：FileNameLocRecordReader
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-25 下午9:30:10
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class FileNameLocRecordReader extends RecordReader<Text, Text>{

	private String fileName;
	//使用最新版本的数据，也就是mapreduce包中的数据
	private LineRecordReader lineRecordReader = new LineRecordReader();
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Text getCurrentKey() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Text text = new Text("(" + fileName + " @" + lineRecordReader.getCurrentKey() + ")" );
		return text;
	}

	@Override
	public Text getCurrentValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return lineRecordReader.getCurrentValue();
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void initialize(InputSplit arg0, TaskAttemptContext arg1)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		lineRecordReader.initialize(arg0, arg1);
	    fileName = ((FileSplit)arg0).getPath().getName();
		
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

}
