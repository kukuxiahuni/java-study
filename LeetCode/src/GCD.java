/**
 * 文件名：GCD.java
 * 所在包：
 * 日期：2014-9-18 下午3:57:53
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */

/**
 *
 * 项目名称：LeetCode
 * 类名称：GCD
 * 类描述：最大公约数	,和最小公倍数LCM
 * 
 *1. 注意0
 *2. 注意负数
 *3. //gcd(a,b) == gcd(b, a-b或者a%b);
	//gcd(a,1) == 1
	//gcd(a,a) == |a|
	//gcd(-a,b) == gcd(a,b)
 * 创建人：黄传聪
 * 创建时间：2014-9-18 下午3:57:53
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class GCD {

	
	//辗转相除法
	public static int gcd1(int a, int b){
		
		a = Math.abs(a);
		b = Math.abs(b);
		int temp = 0;
		if (a < b){
			temp = b;
			b = a;
			a = temp;
		}
		
		while (b != 0){
			
			temp = b;
			b = a % b;
			a = temp;
		
		}
		return a;
	}
	
	//更相减损术
	public static int gcd2 (int a, int b){
		
		if (a == b){
			return Math.abs(a);
		}
		a = Math.abs(a);
		b = Math.abs(b);
		int temp = 0;
		// a 取较大值
		a = a < b ? b : a;
		
		while (b != 0){
			temp = a - b;
			a = Math.max(b, temp);
			b = Math.min(b, temp);
		}
		return a;
	}
	
	//递归
	public static int gcd3 (int a, int b){
		
		if (a == 0 && b != 0){
			return Math.abs(b);
		} else if (a != 0 && b == 0){
			return Math.abs(a);
		} else if (a == 0 && b == 0){
			return a;
		}
		
		a = Math.abs(a);
		b = Math.abs(b);
		if (a % b == 0){
			return b;
		} else {
			return gcd3(b, a % b);
		}
		
	}
	//最小公倍数
	public static int lcm (int a, int b){
		if (a == 0 || b == 0){
			return 0;
		}
		return a * b / gcd1(a, b);
	}
	public static void main(String[] args) {
		gcd1(-1,0);
		System.out.println(gcd2(4,2));
		System.out.println(gcd3(-1,0));
	}
}
