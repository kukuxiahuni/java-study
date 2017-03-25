package jobdu1077;

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
			int n = (int) st.nval;
			
			long[] nums = new long[n];
			int i;
			for(i=0;i<n;i++){
				st.nextToken();
				nums[i] = (long) st.nval;
			}
			long[] results = new long[n];
			long max = 0;
			max = results[0] = nums[0];
			for(i=1;i<n;i++){
				results[i] = Math.max(results[i-1] + nums[i], nums[i]);
				if(max < results[i]){
					max = results[i];
				}
			}
			
			System.out.println(max);
			
		}
	}

}
