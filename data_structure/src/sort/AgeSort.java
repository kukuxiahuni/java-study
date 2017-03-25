/**
 * 文件名：AgeSort.java
 * 所在包：sort
 * 日期：2014-10-8 下午10:47:56
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

/**
 *
 * 项目名称：data_structure
 * 类名称：AgeSort
 * 类描述：对一个公司的所有员工的年龄进行排序《剑指offer》p65
 * 创建人：黄传聪
 * 创建时间：2014-10-8 下午10:47:56
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class AgeSort {

	public void sort(int[] ages) throws Exception{
		
		if (ages == null || ages.length <= 0){
			return;
		}
		
		//年龄为0-99，其实范围应该更小
		int oldestAge = 99; //最老年龄
		int[] ageCounts = new int[oldestAge + 1];
		
		//统计各个年龄出现的次数
		for (int i=0; i<ages.length; ++i){
			
			if (ages[i] < 0 || ages[i] > oldestAge){
				throw new Exception("年龄值错误");
			}
			
			++ageCounts[ages[i]];
		}
		
		//对ages中的数值进行重新写入。从0-oldestAge，分别按照其出现的次数写入到ages数组中
		int index = 0;
		for (int i=0; i<=oldestAge; ++i){
			for (int j=0; j<ageCounts[i]; ++j){
				ages[index] = i; //根据年龄出现的次数填入年龄
				++index;
			}
		}
	}
}
