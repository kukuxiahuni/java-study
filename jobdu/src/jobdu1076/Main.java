package jobdu1076;

import java.math.BigDecimal;
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
			long n = scanner.nextLong();
			System.out.println(recrusion(n));
			
		}
	}

	private static BigDecimal recrusion(long n) {
		// TODO Auto-generated method stub
		BigDecimal bigDecimal = new BigDecimal(1);
		BigDecimal tempBigDecimal = null;
		for(int i=2;i<=n;i++){
			tempBigDecimal = new BigDecimal(i);
			bigDecimal = bigDecimal.multiply(tempBigDecimal);
		}
		
		return bigDecimal;
	}

}
