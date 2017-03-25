/**
 * 文件名：Main.java
 * 所在包：jobdu1037
 * 日期：2013-11-18 上午11:32:29
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1037;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述: 实现大整数的加减乘法
 * 创建人：黄传聪
 * 创建时间：2013-11-18 上午11:32:29
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static final int LEN = 400;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			char[] a = scanner.next().toCharArray();
			char[] b = scanner.next().toCharArray();
//			add(a,b);
//			subtraction(a, b);
			multify(a, b);
			
		}

	}
	private static void add(char[] a, char[] b) {
		// TODO Auto-generated method stub
		int len = a.length > b.length ? a.length + 5:b.length + 5;
		char[] result = new char[len];
		int i,j,k=0,carry = 0;//carry是进位
		i=a.length-1;
		j=b.length-1;
		int temp = 0;
		while(i>=0 && j>=0){
			temp = a[i] - '0' + b[j] - '0' + carry;
			result[k++] = (char) (temp % 10 + '0');
			carry = temp / 10;
			i--;
			j--;
		}
		
		while(i>=0){
			temp = a[i] - '0' + carry;
			result[k++] = (char) (temp % 10 + '0');
			carry = temp / 10;
			i--;
		}
		
		while(j>=0){
			temp = b[j] - '0' + carry;
			result[k++] = (char) (temp % 10 + '0');
			carry = temp / 10;
			j--;
		}
		
		if(carry > 0){
			result[k++] = (char) (carry + '0');
		}
		
		for(i=k-1;i>=0;i--){
			System.out.print(result[i]);
		}
		System.out.println();
	}
	
	private static void subtraction (char[] a, char[] b){
		int len = a.length > b.length ? a.length + 5 : b.length + 5 ;
		char[] result = new char[len];
		
		int i = a.length - 1;
		int j = b.length - 1;
		int carry = 0; //借位
		int temp = 0;
		int k = 0;
		
		if(a.length > b.length || (a.length == b.length && a[0] > b[0]) ){
			
			while(i>=0 && j>=0){
//				System.out.println(a[i] + " " +  (a[i] - '0') + b[j] + " " + (b[j] - '0') );
				temp = (a[i] - '0') - (b[j] - '0') - carry;
				if(temp < 0){
					carry = 1;
					temp += 10;
				}
				result[k++] = (char) (temp + '0');
				i--;
				j--;
			}
			
			while(i >= 0){
				temp = a[i] - '0' - carry ;
				if(temp < 0){
					carry = 1;
					temp += 10;
				}
				result[k++] = (char) (temp + '0');
				i--;
			}
			result[k] = '+';
			
		}else{
			while(i>=0 && j>=0){
				temp = (b[j] - '0') - (a[i] - '0') - carry;
				if(temp < 0){
					carry = 1;
					temp += 10;
				}
				result[k++] = (char) (temp + '0');
				i--;
				j--;
			}
			
			while(j >= 0){
				temp = b[j] - '0' - carry ;
				if(temp < 0){
					carry = 1;
					temp += 10;
				}
				result[k++] = (char) (temp + '0');
				j--;
			}
			result[k] = '-';
		}
		
		for(i=k;i>=0;i--){
			if(result[i] != '+'){
				System.out.print(result[i]);
			}
		}
		
		System.out.println();
	}
	
	private static void multify(char[] a, char[] b){
		int len = a.length > b.length ? a.length * 2 + 5 : b.length * 2  +5 ;
		int[] result = new int[len];
		int i,j;//carry是进位
		
		
		int temp = 0;
		int m,n;
		for(i=a.length-1,m=0;i>=0;i--,m++){
			int carry = 0;
			for(j=b.length-1,n=0;j>=0;j--,n++){
				temp = (a[i] - '0') * (b[j] - '0') + result[m + n] + carry;
				result[m + n] = temp % 10 ;
				carry = temp / 10;
			}
			if(carry > 0){
				result[m + n] = carry ;
			}
		}
		
		i = result.length-1;
		while(result[i] == 0 && i>=0){
			i--;
		}
		
		for(;i>=0;i--){
			System.out.print(result[i]);
		}
		System.out.println();
	}

}
