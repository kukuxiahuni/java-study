package jobdu1099;

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
			String str = scanner.next();
			
			String[] substrs = new String[str.length()];
			
			//切割子串
			int i;
			for(i=0;i<str.length();i++){
				substrs[i] = str.substring(i);
			}
			
			Arrays.sort(substrs);
			
			for(i=0;i<substrs.length;i++){
				System.out.println(substrs[i]);
			}
		}
	}

}
