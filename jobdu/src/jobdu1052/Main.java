package jobdu1052;

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
			
			int[] arrays = new int[n];
			
			int i;
			for(i=0;i<n;i++){
				arrays[i] = scanner.nextInt();
			}
			
			int target = scanner.nextInt();
			int result = -1;
			for(i=0;i<arrays.length;i++){
				if(target == arrays[i]){
					result = i;
					break;
				}
			}
			
		System.out.println(result);
			
		}
	}

}
