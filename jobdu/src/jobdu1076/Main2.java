package jobdu1076;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main2
 * 类描述：不对
 * 创建人：黄传聪
 * 创建时间：2013-11-8 上午11:14:38
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main2 {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int nums = scanner.nextInt();
			String[] strs = new String[nums + 1];
			strs[0] = strs[1] = "1";
			int i;
			char[] result = null;
			for(i=2;i<=nums;i++){
				char[] factors1 = strs[i-1].toCharArray();
				char[] factors2 = String.valueOf(i).toCharArray();
				int len = factors1.length > factors2.length ? factors1.length : factors2.length;
				result= new char[len * 2];
				int j,k;
				for(j=0;j<len * 2;j++){
					result[j] = '0';
				}
				
				
				int carry = 0;
				int m = 0;
				int n = 0;
				for(j=factors1.length-1;j>=0;j--,m++){
					for(k=factors2.length-1;k>=0;k--,n++){
						int temp = (factors1[j]-'0') * (factors2[k]-'0') + carry + (result[m + n] - '0');
						carry = temp / 10;
						result[m + n] = (char) (temp % 10) ;
					}
					
					if(carry > 0){
						result[m + n] = (char) carry;
					}
				}
				
				strs[i] = String.valueOf(result);
			}
			
			System.out.println(strs[nums]);
		}
	}
}
