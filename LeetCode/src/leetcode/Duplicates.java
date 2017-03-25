/**
 * 文件名：Duplicates.java
 * 所在包：leetcode
 * 日期：2014-8-30 下午9:17:31
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.Arrays;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Duplicates
 * 类描述：Remove Duplicates from Sorted Array II 
 * 创建人：黄传聪
 * 创建时间：2014-8-30 下午9:17:31
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Duplicates {

public int removeDuplicates(int[] A) {
        
        if(A.length <=2){
            return A.length;
        }
        int index = 2;
        
        for(int i=2; i<A.length; ++i){
            
            if(A[index-2] != A[i]){
                A[index++] = A[i];
            }
        }
        System.out.println(Arrays.toString(A));
        return index;
    }
}
