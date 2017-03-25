/**
 * 文件名：Main.java
 * 所在包：jobdu1388
 * 日期：2014-10-9 上午11:08:17
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1388;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-9 上午11:08:17
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			
			int n = scanner.nextInt();
			long pre = 1;
			long post = 2;
			
			if (n == 1){
				System.out.println(pre);
			} else if(n == 2){
				System.out.println(post);
			} else {
				
				long count = 0;
				for (int i=3; i<=n; ++i){
					count = pre + post;
					pre = post;
					post = count;
				}
				
				System.out.println(count);
			}
		}
	}
}
