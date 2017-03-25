/**
 * 文件名：InvertedWordIndex.java
 * 所在包：edu.ncut.hadoop.invertedIndex
 * 日期：2013-10-23 下午3:21:14
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.invertedIndex;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import edu.ncut.aggressionEvent.mapper.AggressionDataMapper;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：InvertedWordIndex
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-23 下午3:21:14
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedWordIndex {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException{
		Configuration conf = new Configuration();
//		下面两句配置输出时进行压缩
		/*conf.setBoolean("mapred.out.compress", true);
		conf.setClass("mapred.output.compression.codec", GzipCodec.class, CompressionCodec.class);*/
		
		Job job = new Job(conf, "InvertedIndex");
		job.setJarByClass(InvertedWordIndex.class);
		job.setMapperClass(AggressionDataMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
//	    job.setCombinerClass(InvertedWordCombiner.class);
//		job.setReducerClass(InvertedWordReducer.class);
		// 添加使用自己的分区类
		// job.setPartitionerClass(TextPartition.class);
		// 设置分区的个数
		// job.setNumReduceTasks(3);
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(Text.class);
//		job.setOutputFormatClass(AlphabetOutputFormat.class);// 设置输出格式
		FileInputFormat.addInputPath(job, new Path("/user/hadoop/aggressionRawFiles"));
		FileOutputFormat.setOutputPath(job, new Path("/user/hadoop/out1"));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
