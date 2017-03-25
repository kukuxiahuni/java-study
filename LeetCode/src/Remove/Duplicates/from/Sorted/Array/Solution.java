package Remove.Duplicates.from.Sorted.Array;

import java.util.Arrays;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：移除排序数组中的重复数值，不允许使用额外的存储空间
 * 创建人：黄传聪
 * 创建时间：2014-8-8 下午10:29:27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        
        if(A==null || A.length ==0){
            return 0;
        }
        int length = A.length;
        int index = 0;
        A[index] = A[0];
        for(int i=1;i<length;++i){
            if(A[index] != A[i]){
                ++index;
                A[index] = A[i];
            }
        }
        System.out.println(Arrays.toString(A));
        return index+1;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		int[] A= {1,1,1,2,3,4,5,6,6,7};
		System.out.println(s.removeDuplicates(A));
	}
}