package jobdu1088;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main2 {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @throws IOException 
	 * @Exception 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
		
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int m = 0;
			int n = 0;
			if(st.ttype == StreamTokenizer.TT_NUMBER){
				m = (int) st.nval;
			}
			st.nextToken();
			if(st.ttype == StreamTokenizer.TT_NUMBER){
				n = (int) st.nval;
			}
			
			int[] trees = new int[m + 1];
			int i;
			for(i=0;i<n;i++){
				st.nextToken();
				int a = (int) st.nval;
				st.nextToken();
				int b = (int) st.nval;
				
				for(;a<=b;a++){
					//表示树被清理
					trees[a] = 1;
				}
			}
			int sum = 0;
			for(i=0;i<=m;i++){
				if(trees[i] == 0){
					sum++;
				}
			}
			System.out.println(sum);
		}
	}

}
