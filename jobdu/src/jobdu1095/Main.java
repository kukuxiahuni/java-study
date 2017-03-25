package jobdu1095;

import java.util.Scanner;

public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：该题使用的是递归方式
	 * 
	 * 
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			solve(n);
			System.out.println();
		}
	}
	
    /**
     * 方法名称：solve()
     * 方法描述：1. 寻找最接近或等于n的2^i，确定i的值；
     * 2. 设定打印条件：i==0,1,2,或者是i>2情形
     * 3. i>2情形：需要对i进行递归操作。
     * 4. 判断 n是否已经被完全求解。通过 n-2^i>0是否为真，如果为真，继续递归。否则，返回
     * @param  
     * @return String    
     * @Exception 
     */
    public static void solve(int n){
    	
    	int i = 0 ;
    	//寻找最大的i，也就是最接近n 的2^i
    	while(Math.pow(2, i) <= n){
    		i++;
    	}
    	i--;
    	if(i == 0){
    		System.out.print("2(0)");
    	}else if(i == 1){
    		System.out.print("2");
    	}else {
    		System.out.print("2(");
    		solve(i);
    		System.out.print(")");
    	}
    	
    	if((n=(int) (n-Math.pow(2, i))) > 0){
    		
    		System.out.print("+");
    		solve(n);
    	}
    	return ;
    }
}
