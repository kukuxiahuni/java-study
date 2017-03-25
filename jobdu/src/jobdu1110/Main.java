/**
 * 文件名：Main.java
 * 所在包：jobdu1110
 * 日期：2014-2-18 下午11:55:21
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 * 题目描述：
 * 最短路径 
 */  


package jobdu1110;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 本题应该不适合使用迪杰斯特拉算法，使用并查集（克鲁斯卡尔算法进行最小生成树的计算）
 * 创建人：黄传聪
 * 创建时间：2014-2-18 下午11:55:21
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	private int from;
	private int end;
	private int weight;
	
	
	public Main(int from, int end) {
		this.from = from;
		this.end = end;
		weight = 0;
	}

	public Main() {
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

	}

}
