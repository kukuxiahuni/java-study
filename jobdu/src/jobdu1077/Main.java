package jobdu1077;

import java.util.Scanner;


public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：动态规划：最大子段和
	 * f[i] = max(f[i-1] + nums[i],nums[i]);，max = nums[0];s
	 * 1. 如果前i项字段的和 小于第i项，则fi = nums[i]
	 * 2. 此时可以记录i位置为最大子段和字段的起始位置。
	 * 3. 判断max与fi的大小，如果max《fi，记录结束位置
	 * 
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			if(n == 0){
				break;
			}
			
			int i;
			int[] nums = new int[n];
			for(i=0;i<n;i++){
				nums[i] = scanner.nextInt();
			}
			
			long[] results = new long[n];
			long max = nums[0];
			results[0] = nums[0];
			int begin = 0;
			int beginx = 0,end = 0;
			for(i=1;i<n;i++){
				results[i] = Math.max(results[i-1]+ nums[i], nums[i]);
				if(results[i] == nums[i]){
					begin = i;
				}
				//只有当max<result[i] && result[i]==nums[i]时，标识一个新子段的开始
				if(max < results[i]){
					max = results[i];
					beginx = begin;
					end = i;
				}
			}
			
			for(i=beginx;i<=end;i++){
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			
			System.out.println(max);
			
			
		}
	}

}
