/**
 * 文件名：Pascal.java
 * 所在包：leetcode
 * 日期：2014-10-7 上午9:50:37
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Pascal
 * 类描述：采用滚动数组
 * 创建人：黄传聪
 * 创建时间：2014-10-7 上午9:50:37
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Pascal {

	public List<Integer> getRow(int rowIndex) {
        
		Integer[] result = new Integer[rowIndex + 1];
		result[0] = 1;
		
		for (int i=1; i<=rowIndex; ++i){
			
			for (int j=i; j>0; --j){
				
				if (i == j){
					result[i] = 1;
				} else{
					result[j] = result[j] + result[j-1];
				}
			}
		}
		
		return Arrays.asList(result);
        
    }
}
