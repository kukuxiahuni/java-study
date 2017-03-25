package jobdu1074;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：此处不用开数组
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i ;
		for(i=0;i<256;i++){
			int temp = i * i;
			int sum = 0;
//			int[] array = new int[7];
//			int k = 0;
			
			//数字倒序输出 233->332
			while(temp != 0){
//				array[k] = temp % 10;
				sum = sum * 10 + temp % 10; //3->3x10+3->33x10+2
				temp = temp / 10;
//				k++;
			}
			
			if(sum == i * i){
				System.out.println(i);
			}
		
		}
	}

}
