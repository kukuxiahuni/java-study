/**
 * 文件名：M6174.java
 * 所在包：offer
 * 日期：2014-4-1 下午4:19:18
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package offer;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：M6174
 * 类描述：6174问题
 * 创建人：黄传聪
 * 创建时间：2014-4-1 下午4:19:18
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class M6174 {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			num = scanner.nextInt();
//			System.out.println(num);
			int[] nums = new int[1000];
			int index = 0;
			nums[index++] = num;
			System.out.print(num);
			while(true){
				nums[index] = getNextNum(nums[index-1]);
				System.out.print(" -> " + nums[index]);
				boolean flag = false;
				for(int i=0;i<index;i++){
					if(nums[i] == nums[index]){
						flag = true;
						break;
					}
				}
				
				if(flag) break;
				index++;
			}
		}

	}
	
	
	/**
	 * 方法名称：getNextNum()
	 * 方法描述：x是一个四位数，该方法返回x组成的最大值-最小值
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int getNextNum(int x){
//		System.out.println(x);
		
		char[] chs = String.valueOf(x).toCharArray();
		int length = chs.length;
		
		for(int i=0;i<length;i++){
			boolean flag = false;
			for(int j=1;j<length-i;j++){
				if(chs[j-1] > chs[j]){
					char temp = chs[j-1];
					chs[j-1] = chs[j];
					chs[j] = temp;
					flag = true;
				}
			}
			
			if(!flag){
				break;
			}
		}
		int upResult = Integer.parseInt(new String(chs));
		char[] temp = new char[length];
		int index = 0;
		for(int i=length-1;i>=0;i--){
			temp[index++] = chs[i];
		}
		
		int downResult = Integer.parseInt(new String(temp));
		return (downResult - upResult);
		
		
	}

}
