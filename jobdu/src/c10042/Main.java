package c10042;

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
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int p = scanner.nextInt();
			
			int[][] arr1 = new int[m][n];
			int[][] arr2 = new int[n][p];
			
			int i,j;
			for(i=0;i<m;i++){
				for(j=0;j<n;j++){
					arr1[i][j] = scanner.nextInt();
				}
			}
			
			for(i=0;i<n;i++){
				for(j=0;j<p;j++){
					arr2[i][j] = scanner.nextInt();
				}
			}
			
			int k,q;
			int[][] result = new int[m][p];
			for(i=0;i<m;i++){
				for(j=0;j<p;j++){
					result[i][j] = 0;
					for(k=0;k<n;k++){
						result[i][j] += arr1[i][k] * arr2[k][j];
					}
				}
			}
			
			for(i=0;i<m;i++){
				for(j=0;j<p;j++){
					System.out.print(result[i][j] + " ");
				}
				
				System.out.println();
			}
		}
	}

}
