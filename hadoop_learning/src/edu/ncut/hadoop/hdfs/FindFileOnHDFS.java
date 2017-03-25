/**
 * 文件名：FindFileOnHDFS.java
 * 所在包：edu.ncut.hadoop.hdfs
 * 日期：2013-8-12 下午7:21:21
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

/**
 *
 * 项目名称：hadoop_hdfs
 * 类名称：FindFileOnHDFS
 * 类描述：查找文件在集群中的位置
 * 创建人：黄传聪
 * 创建时间：2013-8-12 下午7:21:21
 * 修改人：黄传聪
 * 修改时间：2013-8-12 下午7:21:21
 * 修改备注：
 * @version
 */
public class FindFileOnHDFS {
	
//	获取HDFS集群上所有节点的名称信息
	public static void getHDFSNodes() throws IOException{
		Configuration conf = new Configuration();
		
		FileSystem fs = FileSystem.get(conf);
//		获取分布式文件系统
		DistributedFileSystem  dfs = (DistributedFileSystem) fs;
//		获取所有的节点
		DatanodeInfo[] dataNodeStats = dfs.getDataNodeStats();
//		打印节点信息
		for(int i=0;i<dataNodeStats.length;i++){
			System.out.println("DataNode_" + i + "_Name: " + dataNodeStats[i].getHostName());
		}
	}
//	查找某个文件在HDFS集群中的位置
	public static void getFileLocal() throws IOException{
		
		Configuration conf = new Configuration();
		
		FileSystem fs = FileSystem.get(conf);
		
		Path path = new Path("/user/hadoop/20130729/word.txt");
		
		FileStatus fileStatus = fs.getFileStatus(path);
		BlockLocation[] bl = fs.getFileBlockLocations(fileStatus, 0, fs.getLength(path));
		
		for(int i=0;i<bl.length;i++){
			String[] hosts = bl[i].getHosts();
			System.out.println("block_" + i + "_location: " + hosts[0]);
		}
	}
	
	public static void main(String[] args) throws IOException{
		getHDFSNodes();
		getFileLocal();
	}
	
	

}
