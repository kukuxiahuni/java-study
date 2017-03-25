/**
 * 文件名：MiddleEventTagData.java
 * 所在包：edu.ncut.aggressionEvent.io
 * 日期：2013-11-18 下午4:02:55
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package edu.ncut.aggressionEvent.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
/**
 *
 * 项目名称：AggressionEvent
 * 类名称：MiddleEventTagData
 * 类描述：原始标签信息处理的中间结果
 * 创建人：黄传聪
 * 创建时间：2013-11-18 下午4:02:55
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MiddleEventTagData implements WritableComparable<MiddleEventTagData>{
	/** 标签码信息   */    
	private Text epcData;
	/**  物理读写器标识   */    
	private Text readPoint;
	/** 读取发生时间   */    
	private Text eventTime;
	/** 逻辑识读器名称    */    
	private Text logicReaderName;
	/** 标签读取次数   */    
	private IntWritable counts;
	/** 标签在某个识读器上的读取率   */    
	private FloatWritable ratio;
	
	public MiddleEventTagData(){
	}
	
	public MiddleEventTagData(Text epcData,Text readPoint,Text eventTime,Text logicReaderName,
			IntWritable counts, FloatWritable ratio ){
		this.epcData = epcData;
		this.readPoint = readPoint;
		this.eventTime = eventTime;
		this.logicReaderName = logicReaderName;
		this.counts = counts;
		this.ratio = ratio;
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		epcData.write(out);
		readPoint.write(out);
		eventTime.write(out);
		logicReaderName.write(out);
		counts.write(out);
		ratio.write(out);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		epcData.readFields(in);
		readPoint.readFields(in);
		eventTime.readFields(in);
		logicReaderName.readFields(in);
		counts.readFields(in);
		ratio.readFields(in);
	}


	
	
	/**     
	 * 根据时间比较
	 * @param o
	 * @return    
	 * @see java.lang.Comparable#compareTo(java.lang.Object)    
	 */
	@Override
	public int compareTo(MiddleEventTagData o) {
		// TODO Auto-generated method stub
		return eventTime.compareTo(o.eventTime);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epcData == null) ? 0 : epcData.hashCode());
		result = prime * result
				+ ((logicReaderName == null) ? 0 : logicReaderName.hashCode());
		result = prime * result
				+ ((readPoint == null) ? 0 : readPoint.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiddleEventTagData other = (MiddleEventTagData) obj;
		if (epcData == null) {
			if (other.epcData != null)
				return false;
		} else if (!epcData.equals(other.epcData))
			return false;
		if (logicReaderName == null) {
			if (other.logicReaderName != null)
				return false;
		} else if (!logicReaderName.equals(other.logicReaderName))
			return false;
		if (readPoint == null) {
			if (other.readPoint != null)
				return false;
		} else if (!readPoint.equals(other.readPoint))
			return false;
		return true;
	}

	public Text getEpcData() {
		return epcData;
	}

	public void setEpcData(Text epcData) {
		this.epcData = epcData;
	}

	public Text getReadPoint() {
		return readPoint;
	}

	public void setReadPoint(Text readPoint) {
		this.readPoint = readPoint;
	}

	public Text getEventTime() {
		return eventTime;
	}

	public void setEventTime(Text eventTime) {
		this.eventTime = eventTime;
	}

	public Text getLogicReaderName() {
		return logicReaderName;
	}

	public void setLogicReaderName(Text logicReaderName) {
		this.logicReaderName = logicReaderName;
	}

	public IntWritable getCounts() {
		return counts;
	}

	public void setCounts(IntWritable counts) {
		this.counts = counts;
	}

	public FloatWritable getRatio() {
		return ratio;
	}

	public void setRatio(FloatWritable ratio) {
		this.ratio = ratio;
	}
	
	

}
