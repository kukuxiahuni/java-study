package offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 项目名称：jobdu
 * 类名称：StringCombiner
 * 类描述：字符串组合问题
 * 问题描述：输入一个字符串，输出该字符串中字符的所有组合。
 * 			举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
 * 创建人：黄传聪
 * 创建时间：2013-11-16 下午4:08:17
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class StringCombiner {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] chs = "abcd".toCharArray();
		combiner(chs);
	}

	//对字符串进行组合
	private static void combiner(char[] chs) {
		// TODO Auto-generated method stub
		if(chs == null || chs.length <= 0){
			return ;
		}
		//求解长度为i 的字符串组合，此处的长度为组合后字符串的长度
		for(int i=1;i<=chs.length;i++){
			List<Character> list = new ArrayList<Character>();
			combiner_m(chs,0,i,list);
		}
	}

	/**
	 * 方法名称：combiner_m()
	 * 方法描述：
	 * @param  begin :字符开始位置
	 * @param i： 组合串的长短
	 * @return String    
	 * @Exception 
	 */
	private static void combiner_m(char[] chs,int begin, int i, List<Character> list) {
		// TODO Auto-generated method stub
		if(chs == null || (begin>=chs.length && i!=0)){
			return ;
		}
		
		if(i == 0){
			for(char c : list){
				System.out.print(c);
			}
			System.out.println();
			return ;
		}
		
		//开始组合，
		//包含begin位置上面的字符
		list.add(chs[begin]);
		combiner_m(chs, begin+1, i-1, list);
		//不包含包含begin位置上面的字符
		Character ch = chs[begin];
//		System.out.println(ch);
		list.remove(ch);
		combiner_m(chs, begin+1, i, list);
	}

}
