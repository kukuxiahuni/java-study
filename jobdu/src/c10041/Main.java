package c10041;

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
			
			int[][] arr = new int[n+1][n+1];
			int i,j;
			//第一行
			arr[1][1] = 1;
			//i 标识第i行
			for(i=2;i<=n;i++){
				//两侧为1
				arr[i][1] = arr[i][i] = 1;
				for(j=2;j<i;j++){
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			
			}
			
			for(i=1;i<=n;i++){
				//打印开头空格
				for(j=1;j<=n-i;j++){
					System.out.print(" ");
				}
				//打印数组元素
				for(j=1;j<=i;j++){
//					System.out.print(arr[i][j] + " ");
					System.out.format("%d ", arr[i][j]);
				}
				System.out.println();
			}
		
		}

	}

}
