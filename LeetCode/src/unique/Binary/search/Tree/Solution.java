package unique.Binary.search.Tree;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：Given n, how many structurally unique BST's (binary search trees) that store values 1...n?,该题目使用斯特灵数求解
 * 创建人：黄传聪
 * 创建时间：2014-7-31 下午11:05:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
	public int numTrees(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		int[] arrays = new int[n+1];
		arrays[0] = arrays[1] = 1;
		for (int i = 2; i <= n; i++) {
			arrays[i] = arrays[i - 1] * (4 * i - 2) / (i + 1);
		}

		return arrays[n];
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.numTrees(4));
	}
}