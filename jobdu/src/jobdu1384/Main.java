package jobdu1384;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


/**
 * 
 * 项目名称：jobdu 
 * 类名称：Main 
 * 类描述：不需要存储，只是在读入的时候就开始判定就行了
 *  创建人：黄传聪 创建时间：2014-3-12 下午11:58:21 修改人： 修改时间： 修改备注：
 * 
 * @version
 */
public class Main {

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
		StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while( tokenizer.nextToken() != StreamTokenizer.TT_EOF ){
			int a = (int) tokenizer.nval;
			tokenizer.nextToken();
			int b = (int) tokenizer.nval;
			tokenizer.nextToken();
			int t = (int) tokenizer.nval;
			boolean re = false;
			
			for(int i=0;i<a;i++){
				for(int j=0;j<b;j++){
					tokenizer.nextToken();
					if(t == (int)tokenizer.nval){
						re = true;
					}
				}
			}
			
			System.out.println(re == true ?  "Yes" : "No");
		}
	}

}