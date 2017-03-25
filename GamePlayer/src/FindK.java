import java.util.Arrays;

/**
 * 文件名：FindK.java
 * 所在包：
 * 日期：2014-11-20 下午10:27:26
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */

/**
 *
 * 项目名称：GamePlayer
 * 类名称：FindK
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-20 下午10:27:26
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class FindK {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {1,2,3};
		System.out.println(calculate(array, 3));
	}
	
	private static boolean calculate(int[] number, int k){
		if (number == null || number.length<=0){
			return false;
		}
		Arrays.sort(number); //按照升序排序
		return calculate(number, 0, k);
	}

	private static boolean calculate(int[] number, int index, int k) {
		// TODO Auto-generated method stub
		if (index >= number.length || k<0){
			return false;
		}
		k -= number[index];
		if (k == 0 && index < number.length){
			return true;
		} 
		
		boolean result = false; 
		result = calculate(number, index + 1, k);
		if (!result){
			k += number[index];
			result = calculate(number, index + 1, k);
		}
		return result;
		
	}

}
