/**
 * 文件名：Main.java
 * 所在包：jobdu1517
 * 日期：2014-4-3 下午3:37:44
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1517;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-4-3 下午3:37:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final class Node{
			int data;
			Node next;
			public Node(int data) {
				this.data = data;
				this.next = null;
			}
		}
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			
			Node head = new Node(scanner.nextInt());
			Node p = head;
			Node node = null;
			for(int i=1;i<n;i++){
				node = new Node(scanner.nextInt());
				p.next = node;
				p = node;
			}
			
			if(k > n){
				System.out.println("NULL");
			}else{
				
				p = head;
				Node quick = head;
				for (int i = 0; i < k; i++) {
					quick = quick.next;
				}

				while (quick != null) {
					p = p.next;
					quick = quick.next;
				}
				if (p != null) {
					System.out.println(p.data);
				} else {
					System.out.println("NULL");
				}
			}
			
		}
	}

}
