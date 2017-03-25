/**
 * 文件名：Test.java
 * 所在包：edu.ncut.hadoop.mapreduce.mini
 * 日期：2013-8-14 下午10:15:51
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.mapreduce.mini;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：Test
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-8-14 下午10:15:51
  * 修改人：黄传聪
 * 修改时间：2013-8-14 下午10:15:51
 * 修改备注：
 * @version
 */
public class Test {

	/**
	 * 方法名称：main()
	 * 方法描述：最小的mapreduce
	 * @param  
	 * @return String    
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 * @Exception 
	 */
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
	    String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
	    if (otherArgs.length != 2) {
	      System.err.println("Usage: wordcount <in> <out>");
	      System.exit(2);
	    }
	    Job job = new Job(conf, "word count");
	    job.setJarByClass(Test.class);
	    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
	    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
