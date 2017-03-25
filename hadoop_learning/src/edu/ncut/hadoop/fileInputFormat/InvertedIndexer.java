/**
 * 文件名：InvertedIndexer.java
 * 所在包：edu.ncut.hadoop.fileInputFormat
 * 日期：2013-10-25 下午9:49:16
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.fileInputFormat;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


/**
 *
 * 项目名称：hadoop_learning
 * 类名称：InvertedIndexer
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-25 下午9:49:16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedIndexer {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
//		下面两句配置输出时进行压缩
		/*conf.setBoolean("mapred.out.compress", true);
		conf.setClass("mapred.output.compression.codec", GzipCodec.class, CompressionCodec.class);*/
		
		String[] otherArgs;
		try {
			otherArgs = new GenericOptionsParser(conf, args)
					.getRemainingArgs();
			if (otherArgs.length != 2) {
				System.err.println("Usage: wordcount <in> <out>");
				System.exit(2);
			}
			Job job = new Job(conf, "InvertedIndex");
			job.setJarByClass(InvertedIndexer.class);
			//设置输入格式
			job.setInputFormatClass(FileNameLocInputFormat.class);
			job.setMapperClass(InvertedIndexMapper.class);
//			job.setMapOutputKeyClass(Text.class);
//			job.setMapOutputValueClass(Text.class);
//			job.setCombinerClass(InvertedWordCombiner.class);
			job.setReducerClass(InvertedIndexReducer.class);
			// 添加使用自己的分区类
			// job.setPartitionerClass(TextPartition.class);
			// 设置分区的个数
			// job.setNumReduceTasks(3);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
//		job.setOutputFormatClass(AlphabetOutputFormat.class);// 设置输出格式
			FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
			System.exit(job.waitForCompletion(true) ? 0 : 1);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
