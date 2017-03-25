package jobdu1384;

import java.io.IOException;
import java.util.Scanner;


/**
 * 
 * 项目名称：jobdu 
 * 类名称：Main ,使用scanner是会超时的
 * 类描述：不需要存储，只是在读入的时候就开始判定就行了
 *  创建人：黄传聪 创建时间：2014-3-12 下午11:58:21 修改人： 修改时间： 修改备注：
 * @version
 */
public class Main2 {

	/**
	 * 方法名称：main() 方法描述：
	 * 
	 * @param
	 * @return String
	 * @throws IOException 
	 * @Exception
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while( scanner.hasNext() ){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int t = scanner.nextInt();
			boolean re = false;
			
			for(int i=0;i<a;i++){
				for(int j=0;j<b;j++){
					if(t == scanner.nextInt()){
						re = true;
					}
				}
			}
			
			System.out.println(re == true ?  "Yes" : "No");
		}
	}

}