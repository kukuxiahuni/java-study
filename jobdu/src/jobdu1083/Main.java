package jobdu1083;

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
			String str2 = scanner.next();
			
			int i,j;
			long sum = 0;
//			System.out.println("test" + Integer.valueOf(text));
			for(i=0;i<str.length();i++){
				for(j=0;j<str2.length();j++){
					int a = Integer.valueOf(str.charAt(i)-48);
					int b = Integer.valueOf(str2.charAt(j)-48);
//					System.out.println(a + " " + b);
					sum += a * b; 
				}
			}
			
			System.out.println(sum);
		}
	}

}
