package jobdu1034;

import java.util.Arrays;
import java.util.Comparator;
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
			int m = scanner.nextInt();
			
			if(n==0 && m==0){
				break;
			}
			
			Integer[] price = new Integer[n];
			int i;
			for(i=0;i<n;i++){
				price[i] = scanner.nextInt();
			}
			
			Arrays.sort(price,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					if(o1 > o2){
						return -1;
					}else if(o1 < o2){
						return 1;
					}else{
						return 0;
					}
				}
			});
			if(m > n){
				m = n;
			}
			String str = "";
			for(i=0;i<m;i++){
				str += price[i] + " ";
			}
			
			System.out.println(str.trim());
		}
		
	}

}
