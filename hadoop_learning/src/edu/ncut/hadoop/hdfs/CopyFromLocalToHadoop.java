/**
 * 文件名：CopyFromLocalToHadoop.java
 * 所在包：edu.ncut.hadoop.hdfs
 * 日期：2013-7-29 下午5:16:35
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *
 * 项目名称：hadoop_hdfs
 * 类名称：CopyFromLocalToHadoop
 * 类描述：将本地文件，拷贝到HDFS文件中
 * 创建人：黄传聪
 * 创建时间：2013-7-29 下午5:16:35
 * 修改人：黄传聪
 * 修改时间：2013-7-29 下午5:16:35
 * 修改备注：
 * @version
 */
public class CopyFromLocalToHadoop {
	
	public static void main(String[] args) throws IOException {
		
	//	step1 获取configure对象
			
			Configuration conf = new Configuration();
	//	step2
			FileSystem fs = FileSystem.get(conf);
//			因为其为linux操作系统
			Path src = new Path("word.txt");//File.separator
			Path dst = new Path("/user/hadoop/20130729/");
			
	//	step3
			fs.copyFromLocalFile(src, dst);
	}

	

	
}
