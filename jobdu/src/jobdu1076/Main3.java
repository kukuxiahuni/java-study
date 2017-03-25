package jobdu1076;

import java.util.Scanner;

public class Main3 {

	/**
	 * 方法名称：main()
	 * 方法描述：思路很重要
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			
			int[] nums = new int[10010];
			
			int i,j;
			//nums[0]存放的是数组中有多少有效值
			//从1 记录的值开始计算
			nums[0] = nums[1] = 1;
			for(i=2;i<=n;i++){
				//存储的每一个数，都要与i相乘
				//此处循环模拟竖式乘法
				//如24 * 5//24的存储方式为 4 2 
				// 4 2 
				// x 5
	            //20 10		得出的结果	   
				   
				for(j=1;j<=nums[0];j++){
					nums[j] = nums[j] * i;
				}
				//得出的结果向前进位 20 10 ；其中20 是低位数。
				// 0 carry = 2； 10 + 2 ：carry = 1
				//故数组值变为： 0 2 1
				//最后将数组反向输出
				for(j=1;j<=nums[0];j++){
					if(nums[j] >= 10){
						nums[j+1] += nums[j] / 10;
						nums[j] %= 10;
						if(j == nums[0]){
							nums[0]++;
						}
						
					}
				}
			}
			
			for(i=nums[0];i>0;i--){
				System.out.print(nums[i]);
			}
			System.out.println();

	}


	}
}

