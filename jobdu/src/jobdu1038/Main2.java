package jobdu1038;

import java.util.Scanner;

public class Main2 {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] factorials = new int[11];
		factorials[0] = 1;
		int i;
		for(i=1;i<11;i++){
			factorials[i] = factorials[i-1] * i;
		}
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			
			for(i=factorials.length-1;i>=0;i--){
				if(n >= factorials[i]){
					n -= factorials[i];
				}
			}
			if(n == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
