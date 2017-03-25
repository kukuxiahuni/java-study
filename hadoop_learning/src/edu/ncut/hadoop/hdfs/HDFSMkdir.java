/**
 * 文件名：HDFSMkdir.java
 * 所在包：edu.ncut.hadoop.hdfs
 * 日期：2013-7-28 下午10:29:20
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *
 * 项目名称：hadoop_hdfs
 * 类名称：HDFSMkdir
 * 类描述：创建HDFS文件夹
 * 创建人：黄传聪
 * 创建时间：2013-7-28 下午10:29:20
 * 修改人：黄传聪
 * 修改时间：2013-7-28 下午10:29:20
 * 修改备注：
 * @version
 */
public class HDFSMkdir {

	public static void main(String[] args) throws IOException{
//		step1 
		Configuration con = new Configuration();
//		step2
		FileSystem fs = FileSystem.get(con);
//		stp3
		fs.mkdirs(new Path("/user/hadoop/20130729"));
		
//		创建文件夹，只需要以上三步就可以了
//		step 4
		FileStatus status = fs.getFileStatus(new Path("/user/hadoop/20130729"));
		System.out.println(status.toString());
	}

	
}
