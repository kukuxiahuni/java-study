/**
 * 文件名：Main2.java
 * 所在包：jobdu1078
 * 日期：2013-10-21 上午10:24:10
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1078;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main2
 * 类描述：构建二叉树
 * 创建人：黄传聪
 * 创建时间：2013-10-21 上午10:24:10
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main2 {

	private char node;
	private Main2 lTree;
	private Main2 rTree;
	
	
	public Main2(char node) {
		this.node = node;
		this.lTree = null;
		this.rTree = null;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String preOrder = scanner.next();
			String inOrder = scanner.next();
			//生成二叉树
			Main2 binTree = new Main2(preOrder.charAt(0));
			generator(binTree,preOrder,inOrder);
			post(binTree);
			System.out.println();
		}
		
		
	}


	private static void post(Main2 binTree) {
		// TODO Auto-generated method stub
		if(binTree != null){
			post(binTree.lTree);
		post(binTree.rTree);
		System.out.print(binTree.node);
		}
	}


	private static Main2 generator(Main2 root ,String preOrder, String inOrder) {
		// TODO Auto-generated method stub
		
//		Main2 root = new Main2(preOrder.charAt(0));
		//根节点在中序遍历中的位置
		int index = inOrder.indexOf(preOrder.charAt(0));
		//拆分中序遍历的左右子树
		String lInorder = inOrder.substring(0,index);
		String rInorder = inOrder.substring(index+1,inOrder.length());
		//拆分前序遍历节点
		String lPreOrder = preOrder.substring(1,preOrder.length()-rInorder.length());
		String rPreOrder = preOrder.substring(preOrder.length()-rInorder.length(),preOrder.length());
		
		if(lPreOrder.length()>0){
			root.lTree = new Main2(lPreOrder.charAt(0));
			generator(root.lTree,lPreOrder,lInorder);
		}
		if(rPreOrder.length()>0){
			root.rTree = new Main2(rPreOrder.charAt(0));
			generator(root.rTree,rPreOrder,rInorder);
		}
		return null;
	}

}
