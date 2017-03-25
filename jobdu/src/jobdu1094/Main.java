package jobdu1094;

import java.util.Scanner;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：一般字符串匹配方式
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
			
			int i;
			int count = 0;
			for(i=0;i<=str.length()-subStr.length();i++){
//				String temp = str.substring(i, subStr.length()+i);
//				System.out.println(temp);
				if(str.substring(i, subStr.length()+ i).equals(subStr)){
					count++;
				}
			}
			
			System.out.println(count);
		}
	}

}
