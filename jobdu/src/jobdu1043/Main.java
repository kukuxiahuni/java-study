package jobdu1043;

import java.util.Scanner;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：给出一个Data，求出是周几.
	 * 1.公元元年1月1日(1年1月1日)，是周一
	 * 2.从公元元年起计数
	 * 3.模7
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	private static String[] stringMonth = {"January", "February", "March", "April", "May", "June", "July","August", 
		"September", "October", "November", "December"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            
            int d = scanner.nextInt();
            String month = scanner.next();
            int y = scanner.nextInt();
            
           int m = -1;
           
           int i;
           
           for(i=0;i<stringMonth.length;i++){
        	   if(month.equals(stringMonth[i])){
        		   m = i;
        		   break;
        	   }
           }
           	//该行计算什么
            int total  = (y-1)+ (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
            for(i=1;i<=m;i++){
                total += months[i-1];
            }
             
            total += d;
            if(isLeapYear(y) && m > 2){
                total += 1;
            }
            
            System.out.println(weeks[total % 7]);
             
        }
	}
//  判断是否是闰年
    public static boolean isLeapYear(int y){
        //是闰年
        if(((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)){
            return true;
        }
        return false;
    }

}
