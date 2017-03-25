package jobdu1066;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

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
			String str = scanner.next();
			
			char[] strs = str.toCharArray();
			
			Arrays.sort(strs);
			
			System.out.println(String.valueOf(strs));
		}
	}
}
