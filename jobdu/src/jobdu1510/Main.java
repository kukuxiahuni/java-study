package jobdu1510;

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

		Scanner scanner = new Scanner(System.in).useDelimiter("\\.+");
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			
//			str = str.replaceAll(" ", "%20");
//			System.out.println(str);
			System.out.println(replace(str));
		}
		
		
	}
	
	private static String replace(String str){
		
		if (str == null || str.length() <= 0){
			return null;
		}
		
		int blankNum = 0; //记录空格数
		int originalLen = str.length();
		
		for (int i=0; i<originalLen; ++i){
			
			if (str.charAt(i) == ' '){
				++blankNum;
			}
		}
		
		int newLen = originalLen + blankNum * 2;
		char[] chs = new char[newLen];
		
		int i = originalLen - 1;
		int j = newLen - 1;
		
		while (i >= 0 && j >= 0){
			
			if (str.charAt(i) == ' '){
				chs[j--] = '0';
				chs[j--] = '2';
				chs[j--] = '%';
			} else{
				chs[j--] = str.charAt(i);
			}
			
			--i;
		}
		
		return new String(chs);
	}
}
