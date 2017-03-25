package jobdu1078;

import java.util.Scanner;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：不构建二叉树
	 * 原理：1. 前序遍历确定根节点；2. 中序遍历确定左右子树。
	 * 具体实现： 1. 首先，确定前序遍历节点在中序遍历树种的位置，并保存
	 * 2. 对中序遍历树，按照保存的位置信息展开后续遍历。
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	//存储根结点的位置
	static int[] rootIndex ;
	static int k = 0;
	static String preOreder ;
	static String inOrder ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
	
		while(scanner.hasNext()){
			k = 0;
			rootIndex = new int[101];
			preOreder = scanner.next();
			inOrder = scanner.next();
			int i,j;
			for(i=0;i<preOreder.length();i++){
				for(j=0;j<inOrder.length();j++){
					if(preOreder.charAt(i) == inOrder.charAt(j)){
						//记录中序遍历中，根节点的位置
						rootIndex[i] = j;
					}
				}
			}
			 post(0, inOrder.length()-1);
			 System.out.println();
			
		}
		
		
	}
	private static void post(int begin, int end){
		if(end < begin) return ;
		if(end >= begin){
			int n = rootIndex[k++];
			//遍历左右子书
			post(begin, n-1);
			post(n+1,end);
			System.out.print(inOrder.charAt(n));
		}
		
	}

}
