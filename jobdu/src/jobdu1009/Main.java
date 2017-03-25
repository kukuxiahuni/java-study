/**
 * 文件名：Main.java
 * 所在包：jobdu1009
 * 日期：2014-4-3 上午11:22:44
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1009;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-4-3 上午11:22:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {
	private char data;
	private Main lChild;
	private Main rChild;
	
	public Main(char data){
		this.data = data;
		lChild = null;
		rChild = null;
	}
	public Main(){
		this.data = '0';
		lChild = null;
		rChild = null;
	}
	
	private static String result = "";
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			result = "";
			int n = scanner.nextInt();
			if(n == 0) break;
			String str = scanner.next();
			Main root = new Main(str.charAt(0));
			for(int i=1;i<str.length();i++){
				insert(root,str.charAt(i));
			}
			String postStr = postOrder(root);
			for(int i=0;i<n;i++){
				result = "";
				str = scanner.next();
				root = new Main(str.charAt(0));
				for(int j=1;j<str.length();j++){
					insert(root,str.charAt(j));
				}
				String compareStr = postOrder(root);
				if(postStr.equals(compareStr)){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}

	}
	/**
	 * 方法名称：postOrder()
	 * 方法描述：后序遍历
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static String  postOrder(Main root) {
		// TODO Auto-generated method stub
		if(root != null){
			postOrder(root.lChild);
			postOrder(root.rChild);
			result += root.data;
		}
		
		return result;
	}
	
	/**
	 * 方法名称：insert()
	 * 方法描述：插入节点
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void insert(Main root, char ch) {
		if(root != null){
			if(ch < root.data){
				if(root.lChild == null){
					
					root.lChild = new Main(ch);
				}else{
					insert(root.lChild, ch);
				}
			}else if(ch > root.data){
				if(root.rChild == null){
					root.rChild = new Main(ch);
				}else{
					insert(root.rChild, ch);
				}
			}
		}
	}

}
