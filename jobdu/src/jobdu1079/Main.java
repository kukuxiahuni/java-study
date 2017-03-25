package jobdu1079;

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
		int[] costs = {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,4,1,2,3,1,2,3,4};
		int[] same = {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7};
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.next();
			int count = 0;
			for(int i=0;i<str.length();i++){
				count += costs[str.charAt(i)-'a'];
				//判断是否在同一个按键上面
				if(i>0){
					if(same[str.charAt(i-1)-'a'] == same[str.charAt(i)-'a']){
						count += 2;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}

}
