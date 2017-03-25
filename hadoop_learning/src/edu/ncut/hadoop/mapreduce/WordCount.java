/**
 * 文件名：WordCount.java
 * 所在包：edu.ncut.hadoop.mapreduce
 * 日期：2013-8-13 上午10:20:59
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */

package edu.ncut.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * 
 * 项目名称：hadoop_learning 类名称：WordCount 类描述： 创建人：黄传聪 创建时间：2013-8-13 上午10:20:59
 * 修改人：黄传聪 修改时间：2013-8-13 上午10:20:59 修改备注：
 * 
 * @version
 */
public class WordCount {
	
//	

	/*public static class WordCountOutputFormat extends
			MultipleOutputFormat<Text, IntWritable> {
		private TextOutputFormat<Text, IntWritable> output = null;

		@Override
		protected RecordWriter<Text, IntWritable> getBaseRecordWriter(
				FileSystem fs, JobConf job, String name, Progressable arg3)
				throws IOException {
			if (output == null) {
				output = new TextOutputFormat<Text, IntWritable>();
			}
			return output.getRecordWriter(fs, job, name, arg3);
			
			return null;
		}

		@Override
		protected String generateFileNameForKeyValue(Text key,
				IntWritable value, String name) {
			char c = key.toString().toLowerCase().charAt(0);
			if (c >= 'a' && c <= 'z') {
				return c + ".txt";
			}
			return "result.txt";
		}

	}*/

	public static void main(String[] args) throws IOException,
			InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();
//		下面两句配置输出时进行压缩
		/*conf.setBoolean("mapred.out.compress", true);
		conf.setClass("mapred.output.compression.codec", GzipCodec.class, CompressionCodec.class);*/
		
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length != 2) {
			System.err.println("Usage: wordcount <in> <out>");
			System.exit(2);
		}
		Job job = new Job(conf, "word count");
		job.setJarByClass(WordCount.class);
		job.setMapperClass(MapClass.class);
		// job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(ReduceClass.class);
		// 添加使用自己的分区类
		// job.setPartitionerClass(TextPartition.class);
		// 设置分区的个数
		// job.setNumReduceTasks(3);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
//		job.setOutputFormatClass(AlphabetOutputFormat.class);// 设置输出格式
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
