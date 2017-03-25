package 小球下落;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：小球下落：6.3.1
 * 创建人：黄传聪
 * 创建时间：2014-7-14 上午9:36:34
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	private final static int MAX_DEGREE = 20;
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int degree, index;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			degree = scanner.nextInt();
			index = scanner.nextInt();
			int max = (1<<degree) - 1;
			boolean[] status = new boolean[1<<MAX_DEGREE];
			Arrays.fill(status, false);
			int k = 0;
			for(int i=0;i<index;i++){
				k = 1;
				while(true){
					status[k]  =!status[k];
					k = status[k] ? k * 2 : k * 2 + 1;
					if(k > max) break;
				}
				
			}
			
			System.out.println(k / 2);
			calculate(degree, index);
		}
	}
	
	/**
	 * 方法名称：calculate()
	 * 方法描述：改进的方法，根据index的奇偶判断其走向
	 * @param  如果继续使用main方法中的序号，可以发现：0,2,4..偶数号小球向左子树运动，奇数号小球向右子树运动
	 * @return String    
	 * @Exception 
	 */
	public static void calculate(int degree, int index){
		int k = 1;
		//对每一层进行遍历
		for(int i=0;i<(degree - 1); ++i){
			
//			if(index % 2 == 1){
//				k *= 2;
//				index = (index + 1) / 2;
//			}else{
//				//如果index为偶数,专项左子树且左子树节点序号为奇数
//				k = 2 * k + 1; //右子树节点
//				index = index / 2;
//			}
			
			if((index & 1) == 1){
				k <<= 1;
				index = ((index + 1) >> 1);
			}else{
				k = (1<<k) + 1;
				index >>= 1;
			} 
		}
		
		System.out.println(k);
		
	}

}
