/**
 * 文件名：TopSort.java
 * 所在包：Graph
 * 日期：2014-2-18 上午9:32:28
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package Graph;

import java.util.Scanner;

/**
 *
 * 项目名称：data_structure
 * 类名称：TopSort
 * 类描述：拓扑排序
 * 创建人：黄传聪
 * 创建时间：2014-2-18 上午9:32:28
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class TopSort {

	/** 顶点数   */    
	private int n;
	/** 头节点数组  */    
	private Vexnode[] vexArr;
	
	
	
	public TopSort(int n) {
		this.n = n;
		vexArr = new Vexnode[n];
	}

	/**
	 *
	 * 项目名称：data_structure
	 * 类名称：Vexnode
	 * 类描述：头节点域
	 * 创建人：黄传聪
	 * 创建时间：2014-2-18 上午9:39:16
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	private final class Vexnode{
		private int vexData;
		private int inDegree;
		private Arcnode firstArc;
		public Vexnode(int vexData, int inDegree, Arcnode firstArc) {
			this.vexData = vexData;
			this.inDegree = inDegree;
			this.firstArc = firstArc;
		}
		public Vexnode() {
		}
		
		
	}
	
	/**
	 *
	 * 项目名称：data_structure
	 * 类名称：Arcnode
	 * 类描述：表结点域
	 * 创建人：黄传聪
	 * 创建时间：2014-2-18 上午9:38:57
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	private final class Arcnode{
		private int arcData;
		private Arcnode nextArc;
	}
	
	/**
	 * 方法名称：createAdjTable()
	 * 方法描述：生成邻接表
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void createAdjTable(){
		
		//弧的头尾节点
		int head, tail;
		//表头数组初始化
		for(int i=0;i<n;i++){
			vexArr[i] = new Vexnode((i+1), 0, null);
		}
		
		System.out.println("please input a line");
		
		//输入一条边
		Scanner scanner = new Scanner(System.in);

		tail = scanner.nextInt();
		head = scanner.nextInt();
		Arcnode arcNode = null;
		//弧头和弧尾全部为0时，结束
		while((tail != 0 && head != 0)){
			arcNode = new Arcnode();
			arcNode.arcData = head;
			
			//新节点插入单链表的表头
			arcNode.nextArc = vexArr[tail - 1].firstArc;
			vexArr[tail - 1].firstArc = arcNode;
			//设置该顶点的入度+1
			vexArr[head - 1].inDegree++;
			
			System.out.println("input the next line");
			tail = scanner.nextInt();
			head = scanner.nextInt();
		}
	}
	/**
	 * 方法名称：topSort()
	 * 方法描述：拓扑排序
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void topSort(){
		int[] vexNode = new int[n];
		int top = -1;
		//入度为0 的顶点入栈
		for(int i=0;i<n;i++){
			if(vexArr[i].inDegree == 0){
				vexNode[++top] = i;
			}
		}
		int j, m = 0,k;
		while(top != -1){
			j = vexNode[top--];//取栈顶元素，并退栈
			System.out.println(vexArr[j].vexData);
			m++;
			//查找j的所有后继k，将k的入度减1
			Arcnode arcNode = vexArr[j].firstArc;
			while(arcNode != null){
				k = arcNode.arcData - 1;
				vexArr[k].inDegree--;
				if(vexArr[k].inDegree == 0){
					vexNode[++top] = k;
				}
				
				arcNode = arcNode.nextArc;
			}
		}
		if(m < n){
			System.out.println("有环");
		}
	}
	public static void main(String[] args){
		TopSort sort = new TopSort(6);
		sort.createAdjTable();
		sort.topSort();
	}
}
