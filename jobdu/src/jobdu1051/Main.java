package jobdu1051;

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
			int a = scanner.nextInt();
			int m = scanner.nextInt();
			
			String[] strs = new String[m];
			strs[0] = String.valueOf(a);
			int i;
			for(i=1;i<m;i++){
				strs[i] = strs[i-1] + a;
			}
			
			String result = "0";
			for(i=0;i<m;i++){
				result = add(result,strs[i]);
			}
			
			System.out.println(result);
		}
	}

	private static String add(String result, String string) {
		// TODO Auto-generated method stub
		int to = 0;//进位
		int i = result.length()-1;
		int j = string.length()-1;
		StringBuilder str = new StringBuilder();
		//字符串位对其，相加
		while(i>=0 && j>=0){
			int temp = result.charAt(i)-'0' + string.charAt(j)-'0' + to;
			str.insert(0, temp % 10);
			to = temp / 10;
			i--;
			j--;
		}
		
		//若result串未加完
		while(i>=0){
			//与进位相加
			int temp = result.charAt(i)-'0' + to;
			str.insert(0, temp % 10);
			to = temp / 10;
			i--;
		}
		while(j>=0){
			int temp = result.charAt(j)-'0' + to;
			str.insert(0, temp % 10);
			to = temp / 10;
			j--;
		}
		
		if(to > 0){
			str.insert(0,to);
		}
		return str.toString();
	}

}
