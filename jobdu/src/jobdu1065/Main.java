package jobdu1065;

import java.util.Scanner;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：超时，用c++不超
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int h = scanner.nextInt();
			//计算每行的值
			int sum = h + (h-1) * 2;
			int i,j;
			for(i=1;i<=h;i++){
				//输出空格
				//空格数
				int num = h + (i - 1) * 2;
				int blockNum = sum - num;
				for(j=0;j<blockNum;j++){
					System.out.print(" ");
				}
				for(j=0;j<num;j++){
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
