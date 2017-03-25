/**
 * 文件名：AdjacencyMatrix.java
 * 所在包：Graph
 * 日期：2013-12-31 上午9:27:47
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：AdjacencyMatrix
 * 类描述：邻接矩阵 = 顺序表（存储顶点信息） + 二维数组（表示顶点之间的邻接关系）
 * 创建人：黄传聪
 * 创建时间：2013-12-31 上午9:27:47
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class AdjacencyMatrix {

	/** 顶点数量   */
	private int n;
	/** 顶点数组   */    
	private int[] vertexes;
	/** 二维数组，表示顶点之间的邻接关系 0表示无关系  */    
	private int[][] matrix;
	/**  是否是无向图:true ;有向图：false  */    
	private boolean flag ;
	//各个节点的父节点
	private int[] fathers ;
	public AdjacencyMatrix() {
		//默认为10
		this(10,true);
		
	}
	public AdjacencyMatrix(int n, boolean flag) {
		this.n = n;
		this.flag = flag;
		vertexes = new int[n];
		matrix = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		
		fathers = new int[n];
	}
	
	/**
	 * 方法名称：init()
	 * 方法描述：开始填充矩阵
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void init(){
		int head , tail, w = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入 边的起始和终止顶点序号 和 边的权值： ************");
		while(scanner.hasNext()){
			
			head = scanner.nextInt();
			tail = scanner.nextInt();
			w = scanner.nextInt();
			
			if(head==0 && tail==0 && w == 0){
				System.out.println("********输入完毕********************");
				break;
			}
			
			matrix[head-1][tail-1] = w;
			if(flag){
				matrix[tail-1][head-1] = w;
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public int[] getVertexes() {
		return vertexes;
	}
	public void setVertexes(int[] vertexes) {
		this.vertexes = vertexes;
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
		int n = 3;
		//使用邻接矩阵存储一个无向图
		AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(n,false);
		Scanner scanner = new Scanner(System.in);
		int[] vertexes = new int[n];
		System.out.println("请输入顶点节点： ");
		for(int i=0;i<n;i++){
			vertexes[i] = scanner.nextInt();
		}
		
		adjacencyMatrix.setVertexes(vertexes);
		adjacencyMatrix.init();
		/*for(int i=0;i<adjacencyMatrix.n;i++){
			for(int j=0;j<adjacencyMatrix.n;j++){
				System.out.print(adjacencyMatrix.getMatrix()[i][j] + " ");
			}
			
			System.out.println();
		}
		
		int[] result = adjacencyMatrix.prim(2);
		for(int a : result){
			System.out.print((a+1) + " -> ");
		}*/
		
//		adjacencyMatrix.kruscal();
		/*int[] result = adjacencyMatrix.prim(1);

		for(int a : result){
			System.out.print((a+1) + " -> ");
		}
		System.out.println("****************888");
		result = adjacencyMatrix.dijkstra(1);
		System.out.println("单源最短路径" );
		for(int a : result){
			System.out.print(a + "  ");
		}*/
		
		adjacencyMatrix.floyd();
	}

	
	/**
	 * 方法名称：prim()
	 * 方法描述：最小生成树，prim 算法实现：对顶点进行遍历，适用于稠密图，时间复杂度o(n*n)
	 * @param  begin: 开始遍历的节点
	 * 测试数据：
	 * 1 2 3 4 5 6
		1 2 6
		1 3 1
		1 4 5
		2 5 3
		2 3 5
		3 4 5
		3 5 6 
		3 6 4 
		4 6 2
		5 6 6
		0 0 0
	 * @return String    
	 * @Exception 
	 */
	public int[] prim(int begin){
		begin = begin - 1;
		int index = 0;
		//结果
		int[] result = new int[n];
		/*两个顶点之间的最小距离*/
		int[] lowCost = new int[n];
		/*记录顶点是否被选中, 默认为未选中*/
		int[] closet = new int[n];
		//标记节点选中
		closet[begin] = 1;
		result[index++] = begin;
		for(int i=0;i<n;i++){
			lowCost[i] =  matrix[begin][i];
		}
		
		//从余下的n-1的节点中查找节点 
		for(int j=1;j<n;j++){
			//从0-i中选出一个路径最小的节点，加入到选中节点中
			int min = Integer.MAX_VALUE;
			int k = 0; //记录最小值得位置,每次都是从lowcost数组中查找最小值节点
			for(int i=0;i<n;i++){
				if(lowCost[i]<min && closet[i] == 0 && lowCost[i] != 0){
					min = lowCost[i];
					k = i;
				}
			}
			//选中节点
			closet[k] = 1;
			lowCost[k] = 0;
			result[index++] = k;
			//修改lowCost中的值
			for(int l=0;l<n;l++){
				if(closet[l]==0 && lowCost[l] > matrix[k][l]&& lowCost[l] != 0){
					lowCost[l] = matrix[k][l];
				}
			}
			
		}
		return result;
	}
	
	public void prim(){
		int[] lowCost = new int[n];
		int[] closeSet = new int[n];
		
		int i ,j, k, min;
		
		for(i=1;i<n;i++){
			lowCost[i] = matrix[0][i];
			closeSet[i] = 1;
		}
		
		for(i=1;i<n;i++){
			min = Integer.MAX_VALUE;
			k = 0;
			for(j=1;j<n;j++){
				if(lowCost[j]<min && lowCost[j] != 0){
					min = lowCost[j];k = j;
				}
			}
			
			lowCost[k] = 0;
			System.out.println(closeSet[k]);
			closeSet[k] = 0;
			for(j=1;j<n;j++){
				if(matrix[k][j]<lowCost[j] && matrix[k][j] != 0){
					lowCost[j] = matrix[k][j];
					closeSet[j] = k;
				}
			}
		}
//		for(int out : closeSet){
//			System.out.println(out);
//		}
	}
	
	/**
	 * 方法名称：kruscal()
	 * 方法描述：kruscal算法，可以使用并查集进行操作
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void kruscal(){
		final class Edge{
			//设置边的两个顶点和权值
			private int from;
			private int end;
			private int weight;
			public Edge(){}
			public Edge(int from, int end, int weight){
				this.from = from;
				this.end = end;
				this.weight = weight;
			}
		}
		
		//初始化其父节点为其本身
		//顶点数组中存放的数据为 1， 2 ，3 。。
		//因 而在使用时，需要减一
		for(int i=0;i<n;i++){
			fathers[vertexes[i]-1] = vertexes[i] - 1;
		}
		List<Edge> edges = new ArrayList<Edge>();
		//构建list
		//如果是无向图，只需构建一侧
		//无向图
		Edge edge = null;
		if(flag){
			
			for(int i=0;i<n;i++){
				for(int j=0;j<=i;j++){
					if(matrix[i][j] != Integer.MAX_VALUE && matrix[i][j] != 0){
						edge = new Edge(i, j, matrix[i][j]);
						edges.add(edge);
					}
				}
			}
		}else{
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(matrix[i][j] != Integer.MAX_VALUE && matrix[i][j] != 0){
						edge = new Edge(i, j, matrix[i][j]);
						edges.add(edge);
					}
				}
			}
		}
		
		//对edges按照权值排序
		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge e1, Edge e2) {
				// TODO Auto-generated method stub
				if(e1.weight - e2.weight > 0){
					return 1;
				}else if(e1.weight - e2.weight < 0){
					return -1;
				}else{
					return 0;
				}
			}
		});
		
		//对每条边的两个顶点设置父顶点
		for(Edge e : edges){
			
			int a = getFather(e.from);
			int b = getFather(e.end);
			if(a != b){
				fathers[b] = a;
				System.out.println((e.from+1) + " -> " + (1+e.end));
			}
		}
		
	}
	
	private int getFather(int x){
		return (x == fathers[x]) ? x : (fathers[x]=getFather(fathers[x]));
	}
	
	/**
	 * 方法名称：dijkstra()
	 * 方法描述：单源最短路径之迪杰斯特拉算法（采用贪心实现（贪心是一种特殊的动态规划））:
	 * 实现方法和prim算法基本相同相同：但是区别在于
	 * 原理不同
	 * 1.prim算法是生成树：保证每一对接点权值最小，且是总权值最小
	 * 2.迪杰斯特拉算法是保证；源点到各个节点的路径的总权值最小，路径有多条，故结果就有多个，使用数组存储
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public int[] dijkstra(int begin){
		begin = begin - 1;
		int index = 0 ;//结果数组位置指针
		//用于存储源点（begin）到各个顶点的最短路径
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		//标记该顶点是否被访问，防止出现回溯现象
		boolean visted[] = new boolean[n];
		Arrays.fill(visted, false);
		//设置源点被访问（数组存储是从0开始，而节点值是从1开始，故需要减1）
		visted[begin] = true;
		
		//设置源点到其他节点的值
		for(int i=0;i<n;i++){
			dist[i] = matrix[begin][i];
		}
		
		//开始查找最小值,并记录最小值的位置
		int position = 0;
		for(int i=1;i<n;i++){
			int min = Integer.MAX_VALUE;
			//从dist中查找最小值
			for(int j=0;j<n;j++){
				if(!visted[j] && dist[j] < min){
					min = dist[j];
					position = j;
				}
			}
			//设置最小值位置被访问
			visted[position] = true;
			//更新最短路径数组（dist）中的值，只更新未被访问的节点具体参看严蔚敏《数据结构》
			for(int j=0;j<n;j++){
				if(!visted[j] && matrix[position][j]!=Integer.MAX_VALUE
						&& dist[j] > dist[position] + matrix[position][j]){
					dist[j] = dist[position] + matrix[position][j];
				}
			}
			
		}
		
		return dist;
		
	}
	
	/**
	 * 方法名称：floyd()
	 * 方法描述：弗洛伊德算法：求解每对顶点之间的最短路径，属于动态规划算法
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void floyd(){
		int[][] shortest = new int[n][n];//其中 a[i][j]存放的是 vi-vj的最短路径长度
		int[][] path = new int[n][n];//后继节点矩阵path来记录两点间的最短路径
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				shortest[i][j] = matrix[i][j];
				path[i][j] = -1;
			}
		}
		
		//对顶点进行操作
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i == j){
						continue;
					}
					
					if(shortest[i][k] + shortest[k][j] < shortest[i][j]){
						shortest[i][j] = shortest[i][k] + shortest[k][j];
						path[i][j] = k;
					}
				}
			}
		}
		String s = null;
	
	}
}


