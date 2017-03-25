package jobdu1369;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	/**
	 * 方法名称：main()
	 * 方法描述：字符串全排序
	 * 基本思想：固定一个，求	其余的排序，典型的递归操作
	 * 如：abc
	 * 首先我们固定第一个字符a，求后面两个字符bc的排列。
	 * 当两个字符bc的排列求好之后，
	 * 我们把第一个字符a和后面的b交换，得到bac，
	 * 接着我们固定第一个字符b，求后面两个字符ac的排列。
	 * 现在是把c放到第一位置的时候了。
	 * 记住前面我们已经把原先的第一个字符a和后面的b做了交换，
	 * 为了保证这次c仍然是和原先处在第一位置的a交换，
	 * 我们在拿c和第一个字符交换之前，先要把b和a交换回来。
	 * 在交换b和a之后，再拿c和处在第一位置的a进行交换，得到cba。
	 * 我们再次固定第一个字符c，求后面两个字符b、a的排列
	 * 
	 * flags : 不起作用
	 * 问题：有重复输出，可以使用list或者是set解决重复，但是提交代码会出现运行超时
	 * 
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner  = new Scanner(System.in);
		while(scanner.hasNext()){
			char[] chs = scanner.next().toCharArray();
			//指示该数据是否被使用过
			boolean[] flags = new boolean[chs.length];
			Arrays.fill(flags, false);
			//排序
			Arrays.sort(chs);
			permutation(chs, 0, chs.length,flags);
		}
	}
	/**
	 * 方法名称：permutation()
	 * 方法描述：开始进行字符全排序操作
	 * @param  chs:待全排字符数组
	 * @param begin:开始位置
	 * @param size:待全排字符数组大小
	 * @return String    
	 * @Exception 
	 */
	public static void permutation(char[] chs,int begin,int size,boolean[] flags){
		
//		if(chs == null || begin > size){
//			return ;
//		}
		//本趟全排序操作结束
		if(begin == size){
			
			System.out.println(String.valueOf(chs));
//			System.out.println();
		}else{
			//正式开始全排序操作
			//固定起始位置，开始进行交换操作
			//第一趟全排，交换操作发生在本身，相当于没有交换
			//第二趟全排，会发生交换操作
			for(int i=begin;i<size;i++){
				
//				if(i != begin && chs[i] == chs[begin]&& flags[begin] )
//	                continue;
				
				if(i!=0 && chs[i]==chs[i-1] && flags[i-1]){
					continue;
				}
				flags[i] = true;
				//交换操作
				swap(chs, i, begin);
				
				//此时已经固定好了begin所指向的字符，开始对子串进行操作
				//递归操作开始
				
				permutation(chs, begin+1, size,flags);
				
				//交换结束后还得再还回来
				//时刻保证字符数组里的字符顺序，是输入时的顺序
				swap(chs, i, begin);
				
				//使用结束
				flags[i] = false;
			}
		}
	}
	private static void swap(char[] chs, int a, int b) {
		char temp = chs[b];
		chs[b] = chs[a];
		chs[a] = temp;
	}

}
