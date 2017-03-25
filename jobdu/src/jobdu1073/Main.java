package jobdu1073;

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
			
			int i;
			for(i=2;i<=n;i++){
				String result = "";
				for(int j=1;j<=i;j++){
					result += solve(i,j) + " ";
				}
				System.out.println(result.trim());
			}
			
		}

	}
	
	public static int solve(int i,int j){
		if(j==1 || j==i){
			return 1;
		}else{
			return solve(i-1, j) + solve(i-1, j-1);
		}
		
	}

}
