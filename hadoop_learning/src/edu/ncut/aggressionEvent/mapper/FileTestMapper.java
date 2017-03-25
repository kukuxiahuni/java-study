/**
 * 文件名：FileTestMapper.java
 * 所在包：edu.ncut.aggressionEvent.mapper
 * 日期：2013-11-19 下午10:52:23
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.aggressionEvent.mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import edu.ncut.aggressionEvent.io.MiddleEventTagData;

/**
 *
 * 项目名称：AggressionEvent
 * 类名称：FileTestMapper
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-11-19 下午10:52:23
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class FileTestMapper extends Mapper<Object, Text, Text, Text>{

	@Override
	protected void map(Object key, Text value,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		context.write(new Text("ggg"), new Text("2"));
	}

	
}
