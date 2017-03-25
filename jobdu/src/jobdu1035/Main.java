package jobdu1035;

import java.util.Scanner;

/**
 * 一颗倒立的二叉树
 * */

public class Main {

	private char data;
	private Main lChild;
	private Main rChild;
	private boolean flag;
	
	
	public Main(char data) {
		this.data = data;
		this.lChild = null;
		this.rChild = null;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			if(m==0 && n == 0){
				break;
			}
			Main root = null;
			int i;
			for(i=0;i<n;i++){
				String str = scanner.next();
				if(root == null){
					root = new Main(str.charAt(0));
				}
				createTree(root, str.charAt(0), str.charAt(1), str.charAt(2));
			}
			
			for(i=0;i<m;i++){
				String strT = scanner.next();
				int a = getLevel(root,strT.charAt(0));
				int b = getLevel(root, strT.charAt(1));
				if(a==0 || b==0 || a-b == 0 || b>a){
					System.out.println("-");
				}else if(a-b == 1){
					System.out.println("parent");
				}else if(a-b == 2){
					System.out.println("grandparent");
				}else if(a-b > 2){
					for(int j=0;j<a-b-2;j++){
						System.out.print("great-");
					}
					System.out.println("grandparent");
				}
			}
			
		}
	}
	
	public static void createTree(Main root,char parent,char lchild,char rchild){
		//首先找到parent节点
		if(root != null){
			if(root.data == parent){
				if(lchild != '-'){
					root.lChild = new Main(lchild);
					root.lChild.flag = false;
				}
				if(rchild != '-'){
					root.rChild = new Main(rchild);
					root.rChild.flag = false;
				}
			}else{
				createTree(root.lChild, parent, lchild, rchild);
				createTree(root.rChild, parent, lchild, rchild);
			}
			
		}
	}
	
	public static int getLevel(Main root, char ch){
		int level;
		if(root == null){
			level = 0;
		}
		else if(root.data == ch){
			level = 1;
		}else {
			int m = getLevel(root.lChild, ch);
			int n = getLevel(root.rChild, ch);
			if(m==0 && n==0){
				level = 0;
			}else {
				level = (m>n?m:n) + 1;
			}
		}
		
		return level;
		
	}
	
	

}
