package jobdu1094;

import java.util.Scanner;

public class Main2 {

	/**
	 * 方法名称：main()
	 * 方法描述：普通字符串模式匹配
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.next();
			String subStr = scanner.next();
			
			int i=0,j=0;//指示指针的位置
			int count = 0;
			while(i<str.length() && j<subStr.length()){
				if(str.charAt(i)==subStr.charAt(j)){
					i++;
					j++;
				}else{
					i = i - j + 1;
					j = 0;
				}
				if(j >= subStr.length()){
					count++;
					i = i - j + 1;
					j = 0;
				}
				
				
			}
			System.out.println(count);
			
		}
	}
}


