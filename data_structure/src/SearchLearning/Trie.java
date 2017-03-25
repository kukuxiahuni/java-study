/**
 * 文件名：Trie.java
 * 所在包：SearchLearning
 * 日期：2014-10-26 下午8:32:02
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package SearchLearning;

/**
 *
 * 项目名称：data_structure
 * 类名称：Trie,字典树
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-26 下午8:32:02
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Trie {

	private final static int SIZE = 26;
	private TreeNode root;
	
	public Trie(){
		root = new TreeNode();
	}
	
	
	private static class TreeNode{
		
		private int num; //记录有多少单词通过该节点，即该节点的字符在多少个字符串中出现
		private TreeNode[] children; //该节点拥有的孩子节点
		private char val; //该节点的值
		private boolean isLast; // 该节点是否是最后一个节点
		
		public TreeNode(){
			num = 1;
			isLast = false;
			children = new TreeNode[SIZE];
		}
		public TreeNode(char val){
			num = 1;
			this.val = val;
			isLast = false;
			children = new TreeNode[SIZE];
		}
	}
	
	/**
	 * 方法名称：insert()
	 * 方法描述：在字典树中插入一个字符串
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void insert(String str){
		
		if (str==null || str.length()<=0 ){
			throw new IllegalArgumentException("字符串为null，或是空串");
		}
		
		TreeNode node = this.root;
		char[] chs = str.toCharArray();
		//每一个字符串都是从根节点起插入
		for (char ch : chs){
			int index = ch - 'a'; // 获取字符存储的位置
			if (node.children[index] == null){
				node.children[index] = new TreeNode(ch);
			} else{
				++node.children[index].num;
			}
			node = node.children[index];
		}
		node.isLast = true;
	}
	
	/**
	 * 方法名称：searchWord()
	 * 方法描述：查询字典树中是否存在一个给定的字符串
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public boolean searchWord(String str){
		
		if (root == null || str == null || str.length() <= 0){
			return false;
		}
		
		char[] chs = str.toCharArray();
		TreeNode node = root;
		for (char ch : chs){
			int index = ch - 'a';
			if (node.children[index] == null){
				return false;
			} else{
				node = node.children[index];
			}
		}
		
		return node.isLast; //只有到达叶子节点才能是一条完整的路径，才能代表一个String串
		
	}
	
	/**
	 * 方法名称：countPrefix()
	 * 方法描述：统计字符串前缀
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public int countPrefix(String prefix){
		
		if (root == null || prefix == null || prefix.length() <= 0){
			return -1;
		}
		
		char[] chs = prefix.toCharArray();
		TreeNode node = root;
		for (char ch : chs){
			int index = ch - 'a';
			if (node.children[index] == null){
				return 0;
			} else{
				node = node.children[index];
			}
		}
		
		return node.num; //返回经过最后一个节点的字符串数
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

		Trie trie = new Trie();
		String[] strs={  
                "banana",
                "band",
                "bee",
                "absolute",
                "acm",
        };
		
		  String[] prefix={
	                "ba",
	                "b",
	                "band",
	                "abc",
	        };
		
		for (String str : strs){
			trie.insert(str);
		}
		
		for (String pre : prefix){
			System.out.println(pre + " : " + trie.countPrefix(pre));
		}
	}

}
