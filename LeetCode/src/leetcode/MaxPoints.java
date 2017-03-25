/**
 * 文件名：MaxPoints.java
 * 所在包：leetcode
 * 日期：2014-11-2 下午5:55:38
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 项目名称：LeetCode
 * 类名称：MaxPoints
 * 类描述：求一条直线经过给点点的最大点数
 * 思想： 通过直线的斜率确定，但是要注意斜率相同的两条直线不一定共线，可能平行。但是如果两条直线经过同一个点，则其共线。故选取一点，获取所有经过改点的直线所通过的点数
 *1. 斜率为0 和 不存在时
 *2. 两点重复
 *3. 斜率存在
 * 创建人：黄传聪
 * 创建时间：2014-11-2 下午5:55:38
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MaxPoints {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point[] points = new Point[3];
//		points[0] = new Point(3, 10);
//		points[1] = new Point(0, 2);
//		points[2] = new Point(2, 2);
//		points[3] = new Point(3, 10);
//		points[0] = new Point(84,250);
//		points[1] = new Point(0,0);
//		points[2] = new Point(1,0);
//		points[3] = new Point(0,-70);
//		points[4] = new Point(0,-70);
//		points[5] = new Point(1,-1);
//		points[6] = new Point(21,10);
//		points[7] = new Point(42,90);
//		points[8] = new Point(-42,-230);
		points[0] = new Point(2,3);
		points[1] = new Point(3,3);
		points[2] = new Point(-5,3);
		
		System.out.println(maxPoints(points));
	}
	
   public static int maxPoints(Point[] points) {
	  
	   if (points==null){
		   return 0;
	   }
	   
	   if (points.length<=2){
		   return points.length;
	   }
	   
	   Map<Double, Integer> maps = new HashMap<>();
	   int len = points.length;
	   int max = 0;
	   
	   for (int i=0; i<len-1; ++i){ //注意此处的临界值
		   maps.clear(); //保证容器为空
		   int duplicate = 0; //与i重复的点，最终要加在commonLine中
		   int commonLine = 1; //与i共线的点的当前最大值
		   Point p = points[i];
		   for (int j=i+1; j<len; ++j){
			   double slope = 0.0; //斜率
			   Point q = points[j];
			   if (p.x == q.x){
				   slope = Integer.MAX_VALUE; //斜率不存在的情形
				   if (p.y == q.y){ //两点重复的情形
					   ++duplicate;
					   continue;
				   }
			   } else {
				   if (p.y == q.y){  //注意double类型中存在正负0
					   slope = 0.0;
				   } else{
					   slope = 1.0 * (p.y - q.y) / (p.x - q.x) ;
				   }
			   }
			   int value = (maps.get(slope) == null ? 1 : maps.get(slope)) + 1;
			   
			   maps.put(slope, value);
			   commonLine = Math.max(commonLine, value);
			   
		   }
		   
		   max = Math.max(commonLine + duplicate, max);
	   }
	   return max;
   }

}
class Point {
	 int x;
	 int y;
	 Point() { x = 0; y = 0; }
	 Point(int a, int b) { x = a; y = b; }
}