/**
 * 文件名：ValidNumber.java
 * 所在包：leetcode
 * 日期：2014-11-4 下午12:08:29
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：ValidNumber
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-4 下午12:08:29
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ValidNumber {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isNumber("."));
	}
	
	public static boolean isNumber(String s) {
	    if (s==null || s.length()<=0){
	    	return false;
	    }
	    s = s.replaceAll(" ", "");
	    if (s.length() <= 0){
	    	return false;
	    }
	    char[] chs = s.toCharArray();
	    int len = s.length();
	    int index = 0;
	    //判断第一个字符是不是合法字符,只有数字、+、 - 是合法的
	    if ( chs[index]=='e' || chs[index]=='E' || (len==1 && chs[index]=='.')){
	    	return false;
	    }
	    if (chs[index]=='+' || chs[index]=='-'){
	    	++index;
	    }
	    
	    if (index >= len){
	    	return false;
	    }
	    
	    boolean numeric = true;
	    //数字扫描，并返回结束的index
	    index = scanNum(chs, index);
	    
	    if (index < len){
	    	//浮点数
	    	if (chs[index] == '.'){
	    		++index;
	    		if (index >= len){
	    			return false;
	    		}
	    		index = scanNum(chs, index);
	    		if (index >= len){
	    			return true;
	    		}
	    		if (chs[index]=='e' || chs[index]=='E'){
	    			return numeric = isExponential(chs, index);
	    		}
	    		
	    		return numeric && (index>=len);
	    	} else if (chs[index]=='e' || chs[index]=='E'){
	    		return isExponential(chs, index);
	    	} else {
	    		//非法字符
	    		return false;
	    	}
	    }
	    
	    return numeric && (index>=len);
	}

	private static boolean isExponential(char[] chs, int index) {
		// TODO Auto-generated method stub
		if ('e' != chs[index] && chs[index]!='E'){
			return false;
		}
		int len = chs.length;
		++index;
		if (index >= len){
			return false;
		}
		
		if (chs[index]=='+' || chs[index]=='-'){
			++index;
		}
		if (index >= len ){
			return false;
		}
		
		index = scanNum(chs, index);
		
		return index >= len;
	}

	private static int scanNum(char[] chs, int index) {
		// TODO Auto-generated method stub
		
		while (index < chs.length && (chs[index]>='0' && chs[index]<='9')){
			++index;
		}
		return index;
	}

}
