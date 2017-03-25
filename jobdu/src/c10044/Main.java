package c10044;

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
			char[] ch1 = scanner.next().toCharArray();
			char[] ch2 = scanner.next().toCharArray();
			
			int[] num1 = new int[ch1.length];
			int[] num2 = new int[ch2.length];
			int[] result = new int[ch1.length * ch2.length];
			
			int i,j;
			
			//转化成整数
			for(i=ch1.length-1;i>=0;i--){
				num1[i] = ch1[i] - '0';
			}
			
			for(i=ch2.length-1;i>=0;i--){
				num2[i] = ch2[i] - '0';
			}
			
			//开始相乘
			//设置进位
			
			int m,n;//设置乘法结果存储位置
			for(i=num1.length -1,m=0;i>=0;i--,m++){
				int to = 0;
				for(j=num2.length-1,n=0;j>=0;j--,n++){
					int tmp = num2[j] * num1[i] + to + result[m + n];
					to = tmp / 10;
					result[m + n] = tmp % 10;
				}
				if(to > 0){
					result[m + n ] = to;
				}
			}
			
			int len = result.length-1;
			while(result[len--] == 0);
			for(i=len+1;i>=0;i--){
				System.out.print(result[i]);
			}
			System.out.println();
		}
	}

}
