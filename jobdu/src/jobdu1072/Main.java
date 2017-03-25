package jobdu1072;

import java.util.HashSet;
import java.util.Set;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：不同的面额值
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k;
		Set<Integer> set = new HashSet<Integer>();
		for(i=0;i<=5;i++){
			for(j=0;j<=4;j++){
				for(k=0;k<=6;k++){
					set.add(8 * i + 10 * j + 18 * k);
				}
			}
			
		}
		//去除0张的情况
		System.out.println(set.size()-1);

	}

}
