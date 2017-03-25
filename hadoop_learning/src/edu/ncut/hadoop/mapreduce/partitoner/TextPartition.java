/**
 * 文件名：TextPartition.java
 * 所在包：edu.ncut.hadoop.mapreduce.partitoner
 * 日期：2013-8-16 下午4:12:11
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.mapreduce.partitoner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：TextPartition
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-8-16 下午4:12:11
 * 修改人：黄传聪
 * 修改时间：2013-8-16 下午4:12:11
 * 修改备注：
 * @version
 */
public class TextPartition extends Partitioner<Text, Text>{

	
	/**     
	 * @param key
	 * @param value
	 * @param numPartitions:分区数目，同时表示reduce的个数
	 * @return    
	 * @see org.apache.hadoop.mapreduce.Partitioner#getPartition(java.lang.Object, java.lang.Object, int)    
	 */
	@Override
	public int getPartition(Text key, Text value, int numPartitions) {
		// TODO Auto-generated method stub
		int result = 0;
		if(key.equals("long")){
			result = 0 % numPartitions;
		}else if(key.equals("short")){
			result = 1 % numPartitions;
		}else if(key.equals("right")){
			result = 2 % numPartitions;
		}
		
		return result;
	}

}
