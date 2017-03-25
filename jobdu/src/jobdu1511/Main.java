/**
 * 文件名：Main.java
 * 所在包：jobdu1511
 * 日期：2014-3-15 下午5:16:57
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1511;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-15 下午5:16:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	private final class Node{
		 int num;
		 Node next;
		public Node(int num) {
			this.num = num;
			next = null;
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
		Stack<Node> stacks = new Stack<Node>();
		Main main = new Main();
		Node head = main.new Node(-1);
		Node p = head;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int num = scanner.nextInt();
			if(num == -1) break;
			Node temp = main.new Node(num);
			p.next = temp;
			p = temp;
		}
		p = head.next;
		while(p!= null){
			stacks.push(p);
			p = p.next;
		}
		
		while(!stacks.isEmpty()){
			p = stacks.pop();
			System.out.println(p.num);
		}
		
//		print(p);
		
	}
	
	
	
	/**
	 * 方法名称：print()
	 * 方法描述：递归方式，九度中递归层数太深导致出错
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void print(Node nodes){

		if(nodes != null){
			if(nodes.next != null){
				print(nodes.next);
			}
			
			System.out.println(nodes.num);
		}
		
		
	}

}
