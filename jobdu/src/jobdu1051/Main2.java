package jobdu1051;

import java.util.Scanner;

public class Main2 {

	/**
	 * 题目1051：数字阶梯求和 
	 * 方法名称：main()
	 * 方法描述：
	 *  使用大数据加法                                                       
                                  1
								1 1
							  1 1 1
							1 1 1 1
		1。 先是后4个1 相加，也就是 1 *　ｎ＋ 进位
		2， 在是前面三个1相加，并且加上进位
		3.  其相加的数据，carry = sum / 10; nums[i++] = sum % 10   
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int a = scanner.nextInt();
			int m = scanner.nextInt();
			int[] nums = new int[m + 1];
			int carry = 0;//进位位
			int k = 0;
			for(int i=0;i<m;i++){
				int temp = (m - i) * a + carry;
				nums[k++] = temp % 10;
				carry = temp / 10;
			}
			if(carry > 0){
				nums[k++] = carry;
			}
			
			k--;
			for(;k>=0;k--){
				System.out.print(nums[k]);
			}
			
			System.out.println();
		}
	}

}
