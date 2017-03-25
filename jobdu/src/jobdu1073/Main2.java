package jobdu1073;

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

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			
			int[][] arrays = new int[n+1][n+1];
			
			for(int i=2;i<=n;i++){
				arrays[i][1] = arrays[i][i] = 1;
				for(int j=2;j<i;j++){
					arrays[i][j] = arrays[i-1][j-1] + arrays[i-1][j];
				}
			}
			
			for(int i=2;i<=n;i++){
				String result = "";
				for(int j=1;j<=i;j++){
					result += arrays[i][j] + " ";
				}
				System.out.println(result.trim());
			}
		}
	}

}
