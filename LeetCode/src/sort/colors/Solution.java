package sort.colors;
/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：类似于荷兰国旗问题
 * 创建人：黄传聪
 * 创建时间：2014-8-18 下午3:24:35
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
    public void sortColors(int[] A) {
//        Arrays.sort(A);
    	
    	//i,j,k分别为 0,1,2的指针，指向各个序列的最后一个位置
    	// 该问题类似于插入排序，但是序列有三个
    	// 0插入到相应的位置时，修改i，并且 1和2的序列整体后移一位
    	// 1 插入时i不变，修改j，2的序列整体后移
    	// 2 插入时，i，j不变，k修改
    	int i, j, k;
    	i = j = k = -1;
    	
    	for(int index=0; index<A.length; ++index){
    		if(A[index] == 0){
    			//2的序列后移
    			A[++k] = 2;
    			A[++j] = 1;
    			A[++i] = 0;
    		}else if(A[index] == 1){
    			A[++k] = 2;
    			A[++j] = 1;
    		}else{
    			A[++k] = 2;
    		}
    	}
    }
}