/**
 * 文件名：InvertedIndex.java
 * 所在包：edu.ncut.hadoop.invertedIndex
 * 日期：2013-10-23 上午9:37:42
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.hadoop.invertedIndex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：InvertedIndex
 * 类描述：实现倒排索引
 * 创建人：黄传聪
 * 创建时间：2013-10-23 上午9:37:42
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InvertedIndex {

	private final static  class InverseIndexMapper extends Mapper<Object,Text,Text,IntWritable>{

//		设定key值和value值
		//key值：存储单词和URI组合
		private Text keyInfo = new Text();
		//存放出现的频率
		private IntWritable valueInfo = new IntWritable(1);
		//文件分割对象
		//设定字符屏蔽列表；
//		String[] ignoreStrings = {"," , ":" , "\\{" ,"\\}" , "\\[" , "\\]" , "\\(" , "\\)", "+", "-", "*","/","#","$","?","<","<<",">",">>","="
//				,"~","\\","\\\\"};
		private FileSplit split;
		@Override
		protected void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			split = (FileSplit) context.getInputSplit();
			//获取文件中的内容
			String str = value.toString();
//			for(String ingnore : ignoreStrings){
//				str.replaceAll(ingnore, "");
//			}
			str.replaceAll(",", "");
			//将文件中的内容进行切分
			String[] strs = str.split(" ");
			for(String s : strs){
				//设置key值
				System.out.println("mapperClass" + s + "," + split.getPath());
				keyInfo.set(s + "," + split.getPath());
				context.write(keyInfo, valueInfo);
			}
			
		}
		
	}
	//统计词频，用于词频和更改键值
	private final static class InvertedIndexCombiner extends Reducer<Text,IntWritable,Text,Text>{
		
		private Text tempKey ;
		private Text tempValue ;
		

		@Override
		protected void reduce(Text key, Iterable<IntWritable> value,
				Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int sum = 0;

			while(value.iterator().hasNext()){
				sum += value.iterator().next().get();
			}
			System.out.println("InvertedIndexCombiner : " + sum);
			String[] strs = key.toString().split(",");
			System.out.println(strs[0] + " "  + strs[1]);
			String str = strs[1] + " " +  sum;
			//重新设置键值对
//			tempKey.set(strs[0]);
//			tempValue.set(str.toString());
			tempKey = new Text(strs[0]);
			tempValue = new Text(strs[1] + ";" + sum);
			context.write(tempKey, tempValue);
		}
		
		
		
	}
	
	
	//设置输出格式
		private final static class InvertedIndexReduce extends Reducer<Text,Text,Text,Text>{
			
			private Text tempValue = new Text();
			@Override
			protected void reduce(Text key, Iterable<Text> value,
					Context context)
					throws IOException, InterruptedException {
				// TODO Auto-generated method stub
				String fileList = "";
				for(Text str : value){
					fileList += str.toString() + ";";
				}
				tempValue.set(fileList);
				context.write(key, tempValue);
			}
			

			
		}
		
		public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException{
			Configuration conf = new Configuration();
//			下面两句配置输出时进行压缩
			/*conf.setBoolean("mapred.out.compress", true);
			conf.setClass("mapred.output.compression.codec", GzipCodec.class, CompressionCodec.class);*/
			
			String[] otherArgs = new GenericOptionsParser(conf, args)
					.getRemainingArgs();
			if (otherArgs.length != 2) {
				System.err.println("Usage: wordcount <in> <out>");
				System.exit(2);
			}
			Job job = new Job(conf, "InvertedIndex");
			job.setJarByClass(InvertedIndex.class);
			job.setMapperClass(InverseIndexMapper.class);
//			job.setMapOutputKeyClass(Text.class);
//			job.setMapOutputValueClass(IntWritable.class);
		    job.setCombinerClass(InvertedIndexCombiner.class);
			job.setReducerClass(InvertedIndexReduce.class);
			// 添加使用自己的分区类
			// job.setPartitionerClass(TextPartition.class);
			// 设置分区的个数
			// job.setNumReduceTasks(3);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
//			job.setOutputFormatClass(AlphabetOutputFormat.class);// 设置输出格式
			FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
			System.exit(job.waitForCompletion(true) ? 0 : 1);
		}
}
