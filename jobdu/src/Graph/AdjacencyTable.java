/**
 * 文件名：AdjacencyTable.java
 * 所在包：Graph
 * 日期：2014-1-2 上午9:54:32
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 项目名称：jobdu
 * 类名称：AdjacencyTable
 * 类描述：邻接表： 表结点 + 头节点 (顶点表 + 边表)
 * 创建人：黄传聪
 * 创建时间：2014-1-2 上午9:54:32
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class AdjacencyTable {

	/** 邻接表 (顶点表)   */    
	private List<Vexnode> list;
	/** 顶点数   */    
	private int n;
	/** 边数   */    
	private int e;
	
	/**  标记是有向图还是无向图  flag=true ：无向图*/    
	private boolean flag;
	/**  标识是否访问  */    
	private boolean[] visited;
	public AdjacencyTable(int n, boolean flag) {
		this.n = n;
		this.flag = flag;
		//无向图
		if(flag){
			this.e = n * (n - 1 ) / 2;
		}else{
			this.e = n * (n - 1);
		}
		visited = new boolean[n];
		Arrays.fill(visited, false);
	}

	/**
	 *
	 * 项目名称：jobdu
	 * 类名称：Arcnode
	 * 类描述：表结点
	 * 创建人：黄传聪
	 * 创建时间：2014-1-2 上午9:55:44
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	private final class Arcnode{
		private int adjvex; //邻接点域,指示与几点vi邻接的点在图中的编号
		private Arcnode nextarc; // 指示下一条边或狐的节点
		private Object info; //弧的信息
	}
	
	/**
	 *
	 * 项目名称：jobdu
	 * 类名称：Vexnode
	 * 类描述：头节点域
	 * 创建人：黄传聪
	 * 创建时间：2014-1-2 上午9:58:52
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	private final class Vexnode{
		
		//和顶点有关的信息
		private int vexData;
		/**  第一个邻接点  */    
		private Arcnode firstArc;

	}
	
	/**
	 * 方法名称：createAdjacencyTable()
	 * 方法描述：创建邻接表
	 * @param  flag: 指示创建有向图还是无向图的邻接表： true 为 无向图
	 * @return String    
	 * @throws Exception 
	 * @Exception 
	 */
	public void createAdjacencyTable() throws Exception{
		list = new ArrayList<Vexnode>();
		Scanner scanner = new Scanner(System.in);
		Vexnode node = null;
		//创建顶点表
		System.out.println("请输入顶点值： **************");
		for(int i=0;i<n;i++){
			node = new Vexnode();
			node.vexData = scanner.nextInt();
			node.firstArc = null;
			list.add(node);
		}
		
		System.out.println("请输入边： ******************");
		//边表节点
		Arcnode arcNode = null;
		//创建边表
		for(int i=0;i<e;i++){
			//输入一条边
			int begin = scanner.nextInt() ;
			int end = scanner.nextInt();
			if(begin==0 && end==0){
				System.out.println(" 创建结束***");
				break;//输入结束
			}
			//如果边的两个顶点序号大于列表长短
			if(begin > list.size() || end > list.size()){
				throw new Exception("begin 或 end 下标越界");
			}
			//以begin为头，end为尾,由于列表从0开始则都减一
			arcNode = new Arcnode();
			arcNode.adjvex = end;
			arcNode.nextarc = null;
			insertNode(arcNode, begin-1);
			//创建无向图
			if(flag){
				arcNode = new Arcnode();
				arcNode.adjvex = begin ;
				arcNode.nextarc = null;
				insertNode(arcNode, end-1);
			}
			
		}
	}


	/**
	 * 方法名称：insertNode()
	 * 方法描述 ： 插入节点
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private void insertNode(Arcnode arcNode, int begin) {
		//查找顶点表，如果顶点为begin的第一个顶点为空
		if(list.get(begin).firstArc == null){
			list.get(begin).firstArc = arcNode;
		}else{
			//如果不为空，则查找后续列表，找到最后一个顶点插入
			Arcnode temp = new Arcnode();
			temp = list.get(begin).firstArc;
			while(temp.nextarc != null){
				temp = temp.nextarc;
			}
			temp.nextarc = arcNode;
		}
	}

	/**
	 * 方法名称：dfs()
	 * 方法描述：
	 * @param  begin:开始节点
	 * @return String    
	 * @Exception 
	 */
	
	public void dfs(int begin){
		//正在访问第
//		System.out.println("正在访问第  " + begin + " 个节点");
		System.out.print(list.get(begin).vexData + " -> ");
		visited[begin] = true;//标识被访问
		Arcnode temp = list.get(begin).firstArc;
		while(temp != null){
			//未被访问
			if(visited[temp.adjvex - 1] == false){
				dfs(temp.adjvex - 1);//访问
			}
			temp = temp.nextarc;
		}
	}
	
	/**
	 * 方法名称：dfsRecuive()
	 * 方法描述：深度优先搜索递归操作
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void dfsRecuive(int begin){
		Arrays.fill(visited, false);
		
		//设定栈，用于存储节点序号
		Stack<Integer> stack = new Stack<Integer>();
		stack.clear();
		stack.add(begin);
		visited[begin] = true;
		//栈非空
		while(!stack.isEmpty()){
			//出栈,并访问
			int temp = stack.pop();
			System.out.print((temp + 1) + " -> ");
			
			
			//将其未访问的邻接点压入栈
			Arcnode node = list.get(temp).firstArc;
			while(node != null ){
				if(visited[node.adjvex - 1] == false){
					stack.add(node.adjvex - 1);
					visited[node.adjvex - 1] = true;
				}
				node = node.nextarc;
			}
//			visited[begin] = true;
		}
	}
	/**
	 * 方法名称：bfs()
	 * 方法描述：广度优先搜索，需要使用队列辅助
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void bfs(int begin){
		Arrays.fill(visited, false);
		Queue<Integer> queue = new LinkedList<Integer>();
		System.out.print((begin + 1) + " -> ");
		visited[begin] = true;
		queue.clear();
		//将顶点序号加入到队列中
		queue.add(begin);
		//队列非空
		while(!queue.isEmpty()){
			//队头元素出队列
			int temp = queue.poll();
			//获取队头元素的第一个邻接点
			Arcnode node = list.get(temp).firstArc;
			while(node != null){
				//节点未被访问
				if(visited[node.adjvex - 1] == false){
					//开始访问
					System.out.print(node.adjvex + " -> ");
					visited[node.adjvex - 1] = true;
					//节点的顶点信息入栈
					queue.add(node.adjvex - 1);
				}
				node = node.nextarc;
			}
		}
		
	}
	
	/**
	 * 方法名称：search()
	 * 方法描述：查找联通分量或强连通图
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void searchConnectedComponent(){
		//标识是否是连通图,默认是
		System.out.println("     ***查找连通图开始******");
		boolean flag = true;
		for(int i=0;i<n;i++){
			//如果顶点没有被遍历，以该节点为入口查询
			if(visited[i] == false){
				flag = false;
				System.out.println("    *******查询连通分量 入口节点为： " + (i+1) + "**********");
				dfs(i);
				//bfs(i);
				System.out.println();
				System.out.println("    ********以 " + (i+1) + " 为入口的联通分量查询结束 ********");
			}
		}
		
		if(flag){
			System.out.println("     其为连通图，连通分量为其本身！");
		}
		
		System.out.println("     ***查找连通图结束******");
	}
	public static void main(String[] args) throws Exception{
		AdjacencyTable table = new AdjacencyTable(8 , true);
		table.createAdjacencyTable();
		/*System.out.println("The first adjvex is : " + table.list.get(0).firstArc.adjvex);
		System.out.println("深度度优先搜索递归方式： **************");
		table.dfs(0);
		System.out.println();
		System.out.println("深度度优先搜索非递归方式： **************");
		table.dfsRecuive(0);
		System.out.println();
		System.out.println("广度优先搜索： **************");*/
/*		for(boolean b : table.visited){
			System.out.println(b);
		}
*/		
//		table.bfs(0);
//		System.out.println();
		table.searchConnectedComponent();
		

	}

	public List<Vexnode> getList() {
		return list;
	}


	public void setList(List<Vexnode> list) {
		this.list = list;
	}


	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}
	
	
}
