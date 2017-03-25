/**
 * 文件名：HuffmanTree.java
 * 所在包：dataStructure_Huffman
 * 日期：2013-12-22 上午11:16:07
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package dataStructure_Huffman;


/**
 *
 * 项目名称：jobdu
 * 类名称：HuffmanTree
 * 类描述：哈夫曼树,使用数组结构存储。平常的树都是采用链表存储
 * 创建人：黄传聪
 * 创建时间：2013-12-22 上午11:16:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class HuffmanTree {

	private int n; // 叶子数，也就是最初的节点
	private int m ; //最终哈夫曼树的节点数
	private Node[] nodes;
	
	
	
	public HuffmanTree(int n) {
		this.n = n;
		m = 2 * n - 1 ;
		//最终有m个节点
		nodes = new Node[m];
	}
	public HuffmanTree() {}
	
	/**
	 * 方法名称：initTree()
	 * 方法描述：根据权值数组来初始化哈夫曼树
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void initTree(int[] weight){
		
		for(int i=0;i<m; i++){
			Node node = new Node();
			if(i < n){
				node.weight = weight[i];
			}else{
				node.weight = 0;
			}
			//初始化，设置每个节点的左右孩子和父节点为-1
			node.pLink = -1;
			node.lChild = -1;
			node.rChild = -1;
			nodes[i] = node;
		}
		
//		for(Node n : nodes){
//			System.out.print(n.weight + " ");
//		}
		//利用前n个叶子节点，构造树
		//每次都要从0-n+i的节点中找到父节点为-1的最小和次小的两个节点，作为叶子
		for(int i=0;i<n-1;i++){
			
			int m1, m2 ,x1, x2;
			//m1 为最小值，m2 为次小值，x1记录最小节点位置，x2记录次小节点位置
			m2 = Integer.MAX_VALUE;
			m1 = Integer.MAX_VALUE;
			x1 = x2 = 0; //x1和x2 是记录的节点的位置
			//查找0-(n+i)中，权值最小、次小的节点
			for(int j=0;j<n+i;j++){
				//权值最小、没有父节点
				if(nodes[j].weight < m1 && nodes[j].pLink == -1){
					m2 = m1;
					x2 = x1;
					m1 = nodes[j].weight;
					x1 = j;
				}else if(nodes[j].weight < m2 && nodes[j].pLink == -1){ 
					//比最小大但是比次小小的节点，如5 3 1 2
					//此时如果最小为1，则次小为3；指针前移，2比最小小，但比次小3要小，故2为次小值
					m2 = nodes[j].weight;
					x2 = j;
				}
			}
			System.out.println(x1 + " " + x2);
			nodes[x1].pLink = n + i;
			nodes[x2].pLink = n + i;
			nodes[n + i].weight = nodes[x1].weight + nodes[x2].weight;
			nodes[n + i].lChild = x1;
			nodes[n + i].rChild = x2;
			
		}
	}
	
	/**
	 * 方法名称：huffCode()
	 * 方法描述：利用哈夫曼树，为每个叶子节点生成哈夫曼编码
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void huffCode(CodeNode[] codeNodes){
		
		//获取需要编码的长度
		int n = codeNodes.length;
		int i,j;
		int s, p; //分别指向孩子节点和父节点
		//哈夫曼树的叶子节点
		for(i=0;i<n;i++){
			int start = n;
			s = i;
			CodeNode node = new CodeNode(n);
			while((p = nodes[s].pLink) != -1){
				node.bits[start--] = (s == nodes[p].lChild) ? '0' : '1';
				s = p;
			}
			
			CodeNode temp = new CodeNode(n);
			for(j = start; j<=n;j++){
				temp.bits[j] = node.bits[j];
			}
			codeNodes[i] = temp;
		}
		
	}
	
	public static void main(String[] args){
		int weight[] = {7,5,2,4};
		HuffmanTree tree = new 	HuffmanTree(4);
		tree.initTree(weight);
		
		for(Node n : tree.nodes){
			System.out.println(n.weight);
		}
		CodeNode[] codeNodes = new CodeNode[4];
		tree.huffCode(codeNodes);
		for(CodeNode n : codeNodes){
			System.out.println(n.bits);
		}
	}
	
	
	/**
	 *
	 * 项目名称：jobdu
	 * 类名称：Node
	 * 类描述：节点内部类
	 * 创建人：黄传聪
	 * 创建时间：2013-12-22 上午11:20:50
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	private final class Node{
		
		private int weight; // 每个节点的权值
		private int pLink, lChild, rChild; //哈夫曼树节点的父、左右孩子链接.其实是节点在数组中的位置
	}
	
	private final class CodeNode{
		private char symbol; //该节点对应的字符
		private char[] bits; //该节点对应的编码
		public CodeNode(int n) {
			this.bits = new char[n + 1];
		}
		
	}
}
