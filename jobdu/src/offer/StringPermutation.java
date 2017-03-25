/**
 * 文件名：StringPermutation.java
 * 所在包：offer
 * 日期：2014-3-25 下午2:26:31
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package offer;

/**
 *
 * 项目名称：jobdu
 * 类名称：StringPermutation
 * 类描述：使用递归方式实现字符串全排列
 * 创建人：黄传聪
 * 创建时间：2014-3-25 下午2:26:31
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class StringPermutation {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
		char[] ch = "abcd".toCharArray();
		permutation(ch, 0);
//		System.out.println(0<<1);
	}
	
	private static boolean isSwap(char[] s, int begin, int end){
		
		for(int i=begin;i<end;i++){
			if(s[i] == s[end]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 方法名称：permutation()
	 * 方法描述：index:当前第几个数， size：共有多少个数
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void permutation(char[] s, int index){
		if(index >= s.length){
			System.out.println(new String (s));
		}else{
			//index 与其后面的字符进行交换
			for(int i=index;i<s.length;i++){
				if(isSwap(s, index, i)){
					swap(s, index, i);
					permutation(s, index+1);
					//恢复交换现场
					swap(s, index, i);
					
				}
			}
		}
	}
	
	public static void swap(char[] s,int i, int j){
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
		
	}

}
