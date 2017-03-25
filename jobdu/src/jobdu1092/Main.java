package jobdu1092;

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
			int n = scanner.nextInt();
			System.out.println(fibonacci(n));
		}
	}
	
	public static int fibonacci(int n){
		if(n==0){
			return 0;
		}else if( n==1){
			return 1;
		}else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

}
