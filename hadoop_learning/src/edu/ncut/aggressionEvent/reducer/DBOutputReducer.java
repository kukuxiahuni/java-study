/**
 * 文件名：DBOutputReducer.java
 * 所在包：aggressionEvent.reducer
 * 日期：2013-11-11 下午8:27:10
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.aggressionEvent.reducer;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 *
 * 项目名称：AggressionEvent
 * 类名称：DBOutputReducer
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-11-11 下午8:27:10
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class DBOutputReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text>{


	@Override
	public void reduce(Text key, Iterator<Text> values,
			OutputCollector<Text, Text> collector, Reporter arg3) throws IOException {
		// TODO Auto-generated method stub
		while(values.hasNext()){
			Text value = values.next();
			collector.collect(key, value);
		}
	}

	
}
