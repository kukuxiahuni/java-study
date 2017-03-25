package jobdu1094;

import java.util.Scanner;

public class Main3 {

	/**
	 * 方法名称：main()
	 * 方法描述：KMP算法
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.next();
			String subStr = scanner.next();
			
			int[] next = getNext(subStr);
			
			int i=0,j=0;//指示指针的位置
			int count = 0;
			while(i<str.length() && j<subStr.length()){
				if(str.charAt(i)==subStr.charAt(j)){
					i++;
					j++;
				}else{
					j = next[j];
				}
				if(j >= subStr.length()){
					System.out.println(i);
				}
				
				
			}
			System.out.println(count);
			
		}
	}

	private static int[] getNext(String subStr) {
		// TODO Auto-generated method stub
		
		int[] next = new int[subStr.length()];
		
		int i = -1;//前缀
		int j = 0; //后缀
		next[0] = -1;//数组从0开始，substr的0号位没有前缀和后缀
		
		while(j<subStr.length()-1){
			
			if(-1 == i || subStr.charAt(i) == subStr.charAt(j)){
				i++;
				j++;
				if(subStr.charAt(i) == subStr.charAt(j)){
					next[j] = next[i];
				}else{
					next[j] = i;
				}
			}else{
				i = next[i];
			}
		}
		
		return next;
	}

}
