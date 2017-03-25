package jobdu1019;

import java.util.Scanner;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			String[] strs = str.split(" ");
			
			
			if(str.charAt(0)== '0'){
				break;
			}
			
			int i;
			double[] nums = new double[strs.length];
			
			int index = 0;
			nums[++index] = Double.valueOf(strs[0]);
			for(i=2;i<strs.length;i++){
				if("+".equals(strs[i-1]) ){
					nums[++index] = Double.valueOf(strs[i]);
				}else if("-".equals(strs[i-1])){
					nums[++index] = -1 * (Double.valueOf(strs[i]));
				}else if("*".equals(strs[i-1])){
					nums[index] = nums[index] * (Double.valueOf(strs[i]));
				}else if("/".equals(strs[i-1])){
					nums[index] = nums[index] / (Double.valueOf(strs[i]));
				}
			}
			
			double count = 0;
			for(i=1;i<=index;i++){
				count += nums[i];
			}
			System.out.format("%.2f\n", count);
		}
	}

}
