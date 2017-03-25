/**
 * 文件名：MainApi.java
 * 所在包：aggressionEvent.model
 * 日期：2013-11-12 上午10:27:30
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */

package edu.ncut.main;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import edu.ncut.aggressionEvent.mapper.RawEPCEventDataMapper;
import edu.ncut.aggressionEvent.reducer.RawEPCDataOutputReducer;

/**
 * 
 * 项目名称：AggressionEvent 类名称：MainApi 类描述： 创建人：黄传聪 创建时间：2013-11-12 上午10:27:30 修改人：
 * 修改时间： 修改备注：
 * 
 * @version
 */
public class MainApi extends Configured implements Tool {

	public enum Counter {
		LINESKIP;// 出错跳过的行数
	}

	/**
	 * 方法名称：main() 方法描述：
	 * 
	 * @param
	 * @return String
	 * @throws IOException
	 * @Exception
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int res;
		try {
			res = ToolRunner.run(new Configuration(), new MainApi(), args);
			System.exit(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int returnNum = -1;
		Configuration conf = getConf();
		Job job = new Job(conf, "aggressionEvent");
		// 设置运行的位置
		job.setJarByClass(MainApi.class);
		// 设置mapper和reducer
		job.setMapperClass(RawEPCEventDataMapper.class);
//		job.setReducerClass(RawEPCDataOutputReducer.class);
		FileInputFormat.addInputPath(job, new Path(
				"/user/hadoop/aggressionRawFiles"));
		FileOutputFormat.setOutputPath(job, new Path("/user/hadoop/out"));
		returnNum = (job.waitForCompletion(true) ? 0 : 1);

		return returnNum;
	}

}
