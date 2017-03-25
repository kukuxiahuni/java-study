/**
 * 文件名：Main.java
 * 所在包：jobdu1385
 * 日期：2014-3-15 下午5:50:07
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1385;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-15 下午5:50:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {
	
	private boolean flag = true;
	private class Node{
		public int num;
		public Node lChild;
		public Node rChild;
		public Node(int num) {
			this.num = num;
			lChild = null;
			rChild = null;
		}
		
		
	}

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int[] pre = new int[n];
			int[] mid = new int[n];
			//前序序列
			for(int i=0;i<n;i++){
				pre[i] = scanner.nextInt();
			}
			//中序遍历
			for(int i=0;i<n;i++){
				mid[i] = scanner.nextInt();
			}
			Main main = new Main();
			main.rebuild(pre, mid);
		}
		
		
		
//		int[] pre = {1,2,4,7,3,5,6,8};
//		int[] order = {4,7,2,1,5,3,8,6};
		
	}
	
	public void rebuild(int[] pre, int[] order){
		
		if (pre == null || order == null || order.length <= 0 || pre.length <= 0){
			return ;
		}
		
		Node head = build (pre, order);
		
		if (head == null || flag == false){
			System.out.println("No");
 		} else{
 			
 			postOrder(head);
 			System.out.println();
 		}
		
	}

	private Node build(int[] pre, int[] order) {
		
		//获取根节点值
		int headVal = pre[0];
		
		Node head = new Node(headVal);
		
		//退出条件
		//1. 前序中只剩下一个节点
		
		if (pre.length == 1 && order.length == 1){
			
			return head;
		}
		
		if (flag){
			
			//找到中序遍历中根节点的位置
			int index = -1;
			for (int i=0; i<order.length; ++i){
				if (order[i] == headVal){
					index = i;
					break;
				}
			}
			
			if (index == -1){
				flag = false;
			}
			//左子树长度
			int leftLength = index;
			int rightLength = order.length - 1 - index;
			if (leftLength > 0){
				
				//根节点左侧为左子树的值，
				int[] preLeft = Arrays.copyOfRange(pre, 1, leftLength + 1);
				int[] orderLeft = Arrays.copyOfRange(order, 0, leftLength);
				head.lChild = build(preLeft, orderLeft);
			}
			
			if (rightLength > 0){
				
				int[] orderaRight = Arrays.copyOfRange(order, index+1, order.length);
				int[] preRight = Arrays.copyOfRange(pre, leftLength + 1, pre.length);
				head.rChild = build(preRight, orderaRight);
			}
		}
		
		
		return head;
	}
	
	private void postOrder(Node head){
		
		if (head == null){
			return;
		}
		
		postOrder(head.lChild);
		postOrder(head.rChild);
		
		System.out.print(head.num + " ");
	}
}
