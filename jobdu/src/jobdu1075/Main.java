package jobdu1075;

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
		int[] array ;
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			array = new int[2 * n ];
			int i, j;
			array[1] = 1;
			array[0] = 0;
			for(i=2;i<2 * n - 1;i++){
				array[i] = fibi(array,i);
			}
			
			for(i=0;i<n;i++){
				String str = "";
				for(j=0;j<2 * (i + 1) -1;j++){
					str += array[j] + " ";
				}
				
				System.out.println(str.trim());
			}
			
		}
	}

	private static int fibi(int[] array, int i) {
		// TODO Auto-generated method stub
		
		if(i==0){
			return 0;
		}else if(i==1){
			return 1;
		}else if(array[i-1] != 0 && array[i-2] != 0){
			return array[i-1] + array[i-2];
		}else{
			return fibi(array,i-1) + fibi(array,i-2);
		}
	}

}
