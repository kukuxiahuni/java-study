/**
 * 文件名：ConvertStackToQueue.java
 * 所在包：jobdu1512
 * 日期：2014-10-8 下午8:25:51
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1512;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：ConvertStackToQueue
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-8 下午8:25:51
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ConvertStackToQueue {

	private Deque<Integer> in = new ArrayDeque<Integer>();
	private Deque<Integer> out = new ArrayDeque<Integer>();
	
	public static void main(String[] args){
		ConvertStackToQueue main = new ConvertStackToQueue();
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			
			int n = scanner.nextInt();
			
			while(n > 0){
				
				String next = scanner.next();
				
				if ("PUSH".equals(next)){
					int value = scanner.nextInt();
					main.appendToTail(value);
				} else{
					System.out.println(main.deleteHead());
				}
				--n;
			}
		}
	}
	private void appendToTail(int value){
		in.push(value);
	}
	
	private int deleteHead(){
		
		if (out.isEmpty()){
			
			while(!in.isEmpty()){
				out.push(in.pop());
			}
		}
		
		if (out.isEmpty()){
			return -1;
		}
		return out.pop();
		 
		
	}
}
