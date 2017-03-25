package jobdu1070;

import java.util.Scanner;

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
			int y = scanner.nextInt();
			int m = scanner.nextInt();
			int d = scanner.nextInt();
			
			int i;
			int total  = 0;
			for(i=1;i<m;i++){
				total += months[i-1];
			}
			
			total += d;
			
			//此处，注意只有是大于2月的月份，闰年才起作用
			if(isLeapYear(y) && m > 2){
				total += 1;
			}
			
			System.out.println(total);
			
		}
	}
	
//	判断是否是闰年
	public static boolean isLeapYear(int y){
		//是闰年
		if(((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)){
			return true;
		}
		return false;
	}

}
