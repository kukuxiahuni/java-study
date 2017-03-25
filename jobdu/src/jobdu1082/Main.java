package jobdu1082;

import java.util.Scanner;

public class Main {

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
			int n = scanner.nextInt();
			int i;
			String[] agent = new String[n +1];
			for(i=0;i<n;i++){
				agent[i] = scanner.next();
			}
			int m = scanner.nextInt();
			String[] server = new String[m +1];
			for(i=0;i<m;i++){
				server[i] = scanner.next();
			}
			
			int count = secdule(agent,n,server,0,m);
			System.out.println(count);
		}
	}

	/**
	 * 方法名称：secdule()
	 * 方法描述：
	 * @param  n,m:分别是两个数组的长度
	 * @param begin : server数组的起始位置
	 * @return String    
	 * @Exception 
	 */
	private static int secdule(String[] agent, int n, String[] server, int begin,int m) {
		// TODO Auto-generated method stub
		
		if(begin > m){
			return 0;
		}
		//表示最大的序号
		int max = -1;
		int i,j = 0;
		//找到agent与server IP地址相等时的序号
		//此二重循环结束，得到的是agent中出现在server中出现最晚的一个ip地址
		for(i=0;i<n;i++){
			//内循环，循环server
			for(j=begin;j<m;j++){
				if(agent[i].equals(server[j])){
					if(max < j){
						max = j;
					}
					break;
				}
			}
		}
		//表示存在代理服务器，在服务器列表中没有出现，此时无需调度
		if(j == m){
			return 0;
		}
		//只有一个代理服务器，并且还出现在服务器的列表中，无法完成调度
		if(n == 1 && max != -1){
			return -1;
		}
		
		return 1 + secdule(agent, n, server, max, m);
		
	}

}
