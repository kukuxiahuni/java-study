/**
 * 文件名：EvaluateReverse.java
 * 所在包：leetcode
 * 日期：2014-11-2 下午4:55:18
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：EvaluateReverse
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-2 下午4:55:18
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class EvaluateReverse {

	private final static List<String> symbols = Arrays.asList("+", "-", "*", "/");
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] tokens = {"4","3","-"};
		
		System.out.println(evalRPN(tokens));
	}
	
	 public static int evalRPN(String[] tokens) {
		 
		 if (tokens==null || tokens.length<=0){
			 return -1;
		 }
		 
		 Deque<Integer> stack = new ArrayDeque<>();
		 
		 for (String str : tokens){
			 
			 if (isSymbol(str)){
				 stack.push(getResult(stack.pop(), stack.pop(), str));
			 } else {
				 stack.push(Integer.valueOf(str));
			 }
		 }
		 
		 return stack.peek();
	 }
	 
	 
	 /**
	 * 方法名称：getResult()
	 * 方法描述：使用第二个数操作第一个数
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static Integer getResult(Integer a, Integer b, String str) {
		// TODO Auto-generated method stub
		 switch(str){
		 case "+" :
			 return a + b;
		 case "-" :
			 return b - a;
		 case "*" :
			 return a * b;
		 case "/" :
			 return b / a;
		 }
		return null;
	}

	private static boolean isSymbol (String str){
		 
		 return symbols.contains(str);
	 }

}
