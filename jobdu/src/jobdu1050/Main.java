package jobdu1050;

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
			String str = "";
			for(i=1;i<=n;i++){
				int result = 0;
				for(int j=1;j<i;j++){
					if(i % j == 0){
						result += j;
					}
				}
				
				if(result == i){
					str += result + " ";
				}
			}
			System.out.println(str.trim());
		}
	}

}
