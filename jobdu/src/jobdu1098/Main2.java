/**
 * 文件名：Main2.java
 * 所在包：jobdu1098
 * 日期：2013-10-28 上午9:02:56
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1098;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main2
 * 类描述：不使用map容器
 * 创建人：黄传聪
 * 创建时间：2013-10-28 上午9:02:56
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main2 {

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
			int[] nums = new int[26];
			char[] chs = scanner.nextLine().toCharArray();
			int i ;
			for(i=0;i<chs.length;i++){
				if(chs[i]>='A' && chs[i] <= 'Z'){
					nums[chs[i]-'A']++;
				}
			}
			
			for(i=0;i<26;i++){
				char ch = (char) (i+'A');
				System.out.println( ch + ":" + nums[i]);
			}
		}
	}

}
