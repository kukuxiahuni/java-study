/**
 * 文件名：AggressionDataMapper.java
 * 所在包：edu.ncut.aggression.mapper
 * 日期：2013-11-20 上午11:31:11
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.aggressionEvent.mapper;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * 项目名称：aggressiondatafilter
 * 类名称：AggressionDataMapper
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-11-20 上午11:31:11
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class AggressionDataMapper extends Mapper<Object, Text, Text, Text>{

	@Override
	protected void map(Object key, Text value,
			Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		try{
			String str = value.toString();
			String[] strs = str.split(" ");
			context.write(new Text("xx"), new Text(strs[1]));
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
	}

}
