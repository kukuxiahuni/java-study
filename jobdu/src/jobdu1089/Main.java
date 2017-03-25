package jobdu1089;

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
			if(n == 0){
				break;
			}
			int i ;
			for(i=0;i<n;i++){
				int a = scanner.nextInt();
				int b = scanner.nextInt();
//				System.out.println(reverse(a));
//				System.out.println(reverse(b));
				if(reverse(a + b) == reverse(a) + reverse(b)){
					System.out.println(a + b);
				}else{
					System.out.println("NO");
				}
			}
		}

	}

	private static int reverse(int nextInt) {
		// TODO Auto-generated method stub
		
		if(nextInt < 10){
			return nextInt;
		}
		return (nextInt % 10) * 10 + nextInt / 10;
	}

}
