package jobdu1062;

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
			double n = scanner.nextDouble();
			double result = 0f;
			if(n>=0 && n<2){
				result = (-1) * n + 2.5;
			}else if(n>=4 && n<6){
				result = n / 2 - 1.5;
			}else if(n >= 2 && n<4){
				result = 2 - 1.5 * (n - 3) * (n - 3);
			}
			
//			BigDecimal bigDecimal = new BigDecimal(result);
//			result = bigDecimal.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
//			System.out.println(result);
			System.out.format("%.3f\n", result);
		}
	}
}
