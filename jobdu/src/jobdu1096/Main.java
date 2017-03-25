package jobdu1096;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-28 上午10:41:27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int date1 = scanner.nextInt();
			int date2 = scanner.nextInt();
			
			int d1 = date1 % 100;
			int m1 = date1 / 100  %100;
			int y1 = date1 / 100  /100;
			
			int d2 = date2 % 100;
			int m2 = date2 / 100  %100;
			int y2 = date2 / 100  /100;
			
			//1. y2 ,y1 之间隔了几个闰年
			//2。 y1,y2 是不是闰年
			//3. 如果是闰年，其月份是否是大于2
			
			int days1 = countDays(y1,m1,d1);
			int days2 = countDays(y2, m2, d2);
			
			System.out.println(days1>days2 ? days1-days2+1:days2-days1+1);
			
		}
	}
	
	public static boolean isLeapYear(int year){
		if(year%4==0&&year%100!=0 || year%400==0){
			return true;
		}
		return false;
		
	}
	
	
	/**
	 * 方法名称：countDays()
	 * 方法描述：计算输入年份到0年12月31日的天数
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static int countDays(int y,int m,int d){
		int count = 0;
			
			count += ((y - 1) / 4 - (y - 1) / 100 + (y - 1)/400) + (y - 1) * 365;
		int i;
		for(i=1;i<m;i++){
			count += months[i-1];
		}
		
		if(isLeapYear(y) && m > 2){
			count += 1;
		}
		
		count += d;
		
		return count;
		
	}

}
