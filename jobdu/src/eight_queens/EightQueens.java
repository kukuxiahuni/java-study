/**
 * 文件名：EightQueens.java
 * 所在包：eight_queens
 * 日期：2013-12-30 上午11:46:35
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package eight_queens;

import java.util.Arrays;

/**
 *
 * 项目名称：jobdu
 * 类名称：EightQueens
 * 类描述：八皇后问题
 * 创建人：
 * 创建时间：2013-12-30 上午11:46:35
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class EightQueens {

	//皇后数量,默认为8
	private int M = 8;
	
	//记录该列，左右对角线有没有棋子
	private int[] colums ;
	//对角线：左上右下(行号-列号绝对值相等)
	private int[] lUrD ;
	//对角线：右上左下(行号+列号相等)
	private int[] rUlD ;
	//最后记录的答案，其中只是记录列号
	private int[] answers ;
	/** 记录解集的个数   */    
	private int counts = 0;
	
	
	private void init(){
		colums = new int[M];
		//对角线：左上右下
		lUrD = new int[2 * M -1];
		//对角线：右上左下
		rUlD = new int[2 * M -1];
		//最后记录的答案，其中只是记录列号
		answers = new int[M];
		
		//设定1表示占用，0表示未占用
		Arrays.fill(colums, 0);
		Arrays.fill(lUrD, 0);
		Arrays.fill(rUlD, 0);
	}
	
	public EightQueens(){
		init();
	}
	
	public EightQueens(int M) {
		this.M = M;
		//记录该列，左右对角线有没有棋子
		init();
	}

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightQueens q = new EightQueens(4);
		q.trail(0);
		
	}
	
	
	/**
	 * 方法名称：trail()
	 * 方法描述：遍历
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private  void trail(int i, int m) {
		// TODO Auto-generated method stub
		//得到一个合法的棋局
		if(i >= m){
			printQueen();
		}else{
			//在第I行J列放置一个棋子
			for(int j = 0; j< m ;j++){
				//如果合法,所在的列，对角线上面没有棋子
				if(colums[j] != 1 && rUlD[i+j] != 1 && lUrD[i-j + m - 1] != 1){
					answers[i] = j; //第i行j列放置棋子可行
					//标记此处已经填放了棋子
					colums[j] = rUlD[i+j] = lUrD[i-j + m - 1] = 1;
					trail(i+1, m );
					colums[j] = rUlD[i+j] = lUrD[i-j + m - 1] = 0;
				}
			}
		}
		
	}
	
	public void trail (int i){
		trail(i, M);
	}
	
	/**
	 * 方法名称：printQueen()
	 * 方法描述：输出棋盘分部
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private void printQueen(){
		// M * M
		counts++;
		System.out.println("解答： " + counts);
		for(int i = 0;i < M ; i++){
			for(int j=0;j < M ;j++){
				//此处是皇后位置
				if(answers[i] == j){
					System.out.print(" Q");
				}else{
					System.out.print(" .");
				}
			}
			System.out.println();
		}
	}
}
