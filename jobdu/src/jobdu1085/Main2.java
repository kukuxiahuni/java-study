/**
 * 文件名：Main2.java
 * 所在包：jobdu1085
 * 日期：2013-11-28 上午10:03:52
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1085;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main2
 * 类描述：快速幂取模
 * http://blog.sina.com.cn/s/blog_8619a25801010wcy.html
 * 创建人：黄传聪
 * 创建时间：2013-11-28 上午10:03:52
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
			long x = scanner.nextLong();
			long y = scanner.nextLong();
			long k = scanner.nextLong();
			
			long result = getRes(x,y,k-1);
			if(result == 0){
				result = k-1;
			}
			
			System.out.println(result);
		}
	}

	private static long getRes(long x, long y, long k) {
		// TODO Auto-generated method stub
		long ret = 1;
		while(y > 0){
			
			if((y&1) == 1){
				ret = (ret * x) % k;
			}
			
			x = (x * x) % k;
			y = y>>1;
		}
		return ret;
	}

}
