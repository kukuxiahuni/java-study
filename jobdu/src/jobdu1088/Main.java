package jobdu1088;

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

		Scanner scanner = new Scanner (System.in);
		
		while(scanner.hasNext()){
			int m = scanner.nextInt();
			//表示树的个数，0-500每个下标代表一个树
			//输入500表示501颗树
			int[] trees = new int[m+1];
			int n = scanner.nextInt();
			
			int i;
			for(i=0;i<n;i++){
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				for(;a<=b;a++){
					//表示树被清理
					trees[a] = 1;
				}
			}
			int sum = 0;
			for(i=0;i<=m;i++){
				if(trees[i] == 0){
					sum++;
				}
			}
			
			System.out.println(sum);
		}
	}

}
