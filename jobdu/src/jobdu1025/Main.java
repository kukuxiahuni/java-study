package jobdu1025;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	static double[] values = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> allowStr = Arrays.asList("A","B","C");
		Scanner scanner  = new Scanner(System.in);
		
		while(scanner.hasNext()){
			double maxPrice = scanner.nextDouble();
			int n = scanner.nextInt();
			if(n==0){
				break;
			}
			values = new double[n+1];
			//输入发票项目
			int i,j,k=0;
			for(i=0;i<n;i++){
				int m = scanner.nextInt();
				double sum = 0;
				int flag = 0;
				for(j=0;j<m;j++){
					String s = scanner.next();
					String[] strs = s.split(":");
					if(allowStr.contains(strs[0]) && Double.valueOf(strs[1])<=600.00){
						sum += Double.valueOf(strs[1]);
						flag ++;
					}
					//保存符合要求的数据
				}
				if(flag == m && sum <= 1000.00){
					values[k++] = sum;//(int) (sum * 100);
				}
			}
			
			//数据输入结束
			//使用动态规划求解
//			int[][] arrays = new int[n][(int) (maxPrice * 100)];
			System.out.format("%.2f\n",count(k-1,maxPrice));
			values = null;
			
		}
		
		
	}
	
	/**
	 * 方法名称：count()
	 * 方法描述：递归计算，
	 * @param  i：表示第几个物品 
	 * @param w：表示背包剩余的重量
	 * @return String    
	 * @Exception 
	 */
	public static double count(int i, double w){
		if(i < 0){
			return 0;
		}
		if(w >= values[i]){
			return  Math.max(count(i-1,w), count(i-1,w-values[i]) + values[i]);

		}else {
			return count(i-1,w);
		}

	}

}
