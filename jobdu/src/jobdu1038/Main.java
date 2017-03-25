package jobdu1038;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

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
		StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
		int n = -1;
		//设置阶乘数组
		int[] factorials = new int[11];
		factorials[0] = 1;
		int i;
		for(i=1;i<11;i++){
			factorials[i] = factorials[i-1] * i;
		}
		try {
			while(st.nextToken() != StreamTokenizer.TT_EOF){
				switch(st.ttype){
				case StreamTokenizer.TT_NUMBER:
					n = (int) st.nval;
					break;
				}
				
				for(i=factorials.length-1;i>=0;i--){
					if(n >= factorials[i]){
						n -= factorials[i];
					}
				}
				
				if(n == 0){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
