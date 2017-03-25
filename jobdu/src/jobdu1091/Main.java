/**
 * 文件名：Main.java
 * 所在包：jobdu1091
 * 日期：2013-11-30 上午11:05:47
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1091;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：具体原理就是，对于任何一个node，都要在其四个方向进行寻找（已经寻找过的点不可再寻找）。找出
 * 最小的结果，其余比他大的结果的节点及其后续节点全部剪掉。
 * 创建人：黄传聪
 * 创建时间：2013-11-30 上午11:05:47
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：使用DFS加剪枝
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int[][] prices;
	//设定用于输出的值
	private static int MAX = Integer.MAX_VALUE;
	private static int result;
	//起始位置坐标
	static int bx,by,ex,ey;
	private static boolean[][] flags ;
	//每个节点四个方向上面的坐标
	private static final int[][] positions = 
		{
			 {0, 1},
			 {0, -1},
			 {1, 0},
			 {-1, 0}
		};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			if(n == 0){
				break;
			}
			int i,j ;
			prices= new int[8][8];
			//输入每组数据
			while(n-- > 0){
				//全部初始化为false
				flags = new boolean[8][8];
				for(i=0;i<6;i++){
					for(j=0;j<6;j++){
						prices[i][j] = scanner.nextInt();
					}
					
				}
				
				bx = scanner.nextInt();
				by = scanner.nextInt();
				ex = scanner.nextInt();
				ey = scanner.nextInt();
				//对每组数据进行处理,初始状态为1，初始值为0
				//设定输出结果
				result = MAX;
				DFS(bx,by,0,1);
				System.out.println(result);
				
			}
		}
		
		
	}
	private static void DFS(int x, int y, int val, int status) {
		// TODO Auto-generated method stub
		//如果结束
		if(x == ex && y == ey){
			if(result > val){
				result = val;
			}
			
			return ;
		}
		
		//剪枝（原因），只保留最小的值
		
		if(val > result){
			return ;
		}
		
		//对四个方向上的值进行计算
		int tempx, tempy;
		for(int i=0;i<4;i++){
			tempx = x + positions[i][0];
			tempy = y + positions[i][1];
			
			//判断位置是否合法
			if(tempx<0 || tempx >=6 || tempy < 0 || tempy>=6 || flags[tempx][tempy]){
				continue;//位置不合法，其后语句不执行，继续循环
			}
			
			//标记访问过
			flags[tempx][tempy] = true;
			//计算代价
			int price = prices[tempx][tempy] * status;
			DFS(tempx,tempy,val + price, price % 4 + 1);
			flags[tempx][tempy] = false;
		}
		
	}

}
