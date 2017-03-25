/**
 * 文件名：Main.java
 * 所在包：jobdu1512
 * 日期：2014-3-16 上午10:46:04
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */

package jobdu1512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * 
 * 项目名称：jobdu 类名称：Main 类描述：使用两个栈实现队列 创建人：黄传聪 创建时间：2014-3-16 上午10:46:04 修改人：
 * 修改时间： 修改备注：
 * 
 * @version
 */
public class Main {

	/**
	 * 方法名称：main() 方法描述：
	 * 
	 * @param
	 * @return String
	 * @throws IOException
	 * @Exception
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Stack<Integer> in = new Stack<Integer>();
		Stack<Integer> out = new Stack<Integer>();
		StreamTokenizer tokener = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));

		while (tokener.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) tokener.nval;
			tokener.nextToken();
			for (int i = 0; i < n; i++) {
				String str = tokener.sval;
				if ("PUSH".equals(str)) {
					tokener.nextToken();
					in.push((int) tokener.nval);
				} else if ("POP".equals(str)) {
					System.out.println(pop(in, out));
				}
				tokener.nextToken();
			}

		}

	}

	public static int pop(Stack<Integer> in, Stack<Integer> out) {
		if (out.isEmpty() == false) {
			return out.pop();
		} else if (in.isEmpty() == false) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
			in.clear();
			return out.pop();
		} else {
			return -1;
		}

	}
	

}
