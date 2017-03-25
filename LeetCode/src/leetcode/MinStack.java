/**
 * 文件名：MinStack.java
 * 所在包：leetcode
 * 日期：2014-11-12 下午7:52:28
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 项目名称：LeetCode
 * 类名称：MinStack
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-12 下午7:52:28
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MinStack {

	private Deque<Integer> numStack = new ArrayDeque<>(),
			minStack = new ArrayDeque<>();
	 public void push(int x) {
	     numStack.push(x);
	     if (minStack.isEmpty() || x <= minStack.peek()){
	    	 minStack.push(x);
	     } 
	 }

	public void pop() {
		if (numStack.isEmpty() || minStack.isEmpty()){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if (numStack.pop().equals(minStack.peek())){
			minStack.pop();
			
		}
	}

	public int top() {
		if (numStack.isEmpty()){
			throw new ArrayIndexOutOfBoundsException();
		}
	    return numStack.peek();    
	}
	public int getMin() {
		if (minStack.isEmpty()){
			throw new ArrayIndexOutOfBoundsException();
		}
	    return minStack.peek();
	}
	

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
