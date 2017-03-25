/**
 * 文件名：TextPair.java
 * 所在包：edu.ncut.hadoop.mapreduce
 * 日期：2013-8-13 下午10:40:22
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 北方工业大学物联网研究室
 *
 */  

package edu.ncut.hadoop.mapreduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 *
 * 项目名称：hadoop_learning
 * 类名称：TextPair
 * 类描述：Text 实现原理
 * 创建人：黄传聪
 * 创建时间：2013-8-13 下午10:40:22
 * 修改人：黄传聪
 * 修改时间：2013-8-13 下午10:40:22
 * 修改备注：
 * @version
 */
public class TextPair implements Writable{

	private int id;
	private String name;
	
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		id = in.readInt();
		name = in.readUTF();
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(id);
		out.writeUTF(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
