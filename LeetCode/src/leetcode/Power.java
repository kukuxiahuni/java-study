/**
 * 文件名：Power.java
 * 所在包：leetcode
 * 日期：2014-10-7 上午9:28:00
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Power
 * 类描述：求解数x的n次幂
 * 创建人：黄传聪
 * 创建时间：2014-10-7 上午9:28:00
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Power {
	public double pow(double x, int n) {
        boolean flag = false;
        if (n < 0){
            flag = true;
            n = -n;
        }
        
        double result = getPow(x, n);
        
        if (flag){
            return 1/result ;
        }
        
        return result;
    }
	
	private double getPow(double x, int n){
		
		if (n ==0 ){
			return 1;
		}
		
		if (n == 1){
			return x;
		}
		
		if (n == 2){
			return x * x;
		}
		double mid = getPow(x, n / 2);
		if ((n & 1) == 0){
			return mid * mid;
		}
		
		return mid * mid * x;
	}
	
	public static void main(String[] args) {
		Power p = new Power();
		
		System.out.println(p.pow(-4.48392, 6));
	}
}
