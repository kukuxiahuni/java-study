/**
 * 文件名：Main.java
 * 所在包：jobdu1346
 * 日期：2014-4-3 下午4:54:52
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1346;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-4-3 下午4:54:52
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	private int id;
	private int s;
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n,m;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			n = scanner.nextInt();
			m = scanner.nextInt();
			Main[] mains = new Main[n];
			
			for(int i=0;i<n;i++){
				Main main = new Main();
				main.id = scanner.nextInt();
				main.s = scanner.nextInt();
				mains[i] = main;
			}
			
			Arrays.sort(mains,new Comparator<Main>() {

				@Override
				public int compare(Main o1, Main o2) {
					// TODO Auto-generated method stub
					if(o1.s > o2.s){
						return -1;
					}else if(o1.s == o2.s){
						if(o1.id < o2.id){
							return -1;
						}else if(o1.id == o2.id){
							return 0;
						}else {
							return 1;
						}
					}else{
						return 1;
					}
				}
			});
			
			for(int i=0;i<(n<=m?n:m);i++){
				System.out.println(mains[i].id);
			}
		}
	}

}
