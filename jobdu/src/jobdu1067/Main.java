package jobdu1067;

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

		Scanner scanner = new Scanner (System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			
			long[] recursions = new long[n+1];
			recursions[0] = 1;
			int i;
			for(i=1;i<=n;i++){
				recursions[i] = recursions[i-1] * i;
			}
			
			System.out.println(recursions[n]);
			
		}
	}

}
