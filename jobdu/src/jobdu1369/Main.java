package jobdu1369;

import java.util.ArrayList;
import java.util.Collections;
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
			String str = scanner.next();
			char[] chs = str.toCharArray();
			ArrayList<String> strs = new ArrayList<String>();
			permutation(chs,0,chs.length,strs);
			Collections.sort(strs);
			if(strs!=null && strs.size()>0){
				for(String s : strs){
					System.out.println(s);
				}
			}
		}

	}

	static void swap(char[] arr, int idx1, int idx2) {
	    char temp = arr[idx1];
	    arr[idx1] = arr[idx2];
	    arr[idx2] = temp;
	}

	
	/**方法描述：
	 * 方法名：perJmutation
	 * @param arr
	 * @param index 指示第几个字符
	 * @param size
	 * @param strs void
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 下午3:47:01
	 */
	static void permutation(char[] arr, int index, int size,ArrayList<String> strs) {
	    if (index == size) {
//	        for (int i = 0; i < arr.length; i++) {
//	        	System.out.print(arr[i] + " ");
//	        }
//	        System.out.println();
	    	if(!strs.contains(String.valueOf(arr))){
	    		strs.add(String.valueOf(arr));
	    	}
	    } else {
	        for (int i = index; i < size; i++) {
//	            if(i != index && arr[i] == arr[index])
//	                continue;
	            swap(arr, i, index);
	            permutation(arr, index+1, size,strs);
	            swap(arr, i, index);
	        }
	    }
	}
    
}
