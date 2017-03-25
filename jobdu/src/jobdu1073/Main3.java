package jobdu1073;

import java.util.Scanner;

public class Main3 {

	/**
	 * 方法名称：main()
	 * 方法描述：使用备忘录方式的递归
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	static int[][] arrays= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			
			arrays = new int[n+1][n+1];
			for(int i=2;i<=n;i++){
				for(int j=1;j<=i;j++){
					arrays[i][j] = solve(i,j);
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
	
	public static int solve(int i,int j){
		if(j==1 || j==i){
			return 1;
		}else if(arrays[i-1][j-1]!=0 && arrays[i-1][j]!=0){
			return arrays[i-1][j-1] + arrays[i-1][j];
		}else{
			return solve(i-1, j) + solve(i-1, j-1);
		}
		
	}

}
