package jobdu1098;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
			Map<Character,Integer> map = new HashMap<Character,Integer>();
			
			char[] chs = str.toCharArray();
			int i;
			//
			for(i=65;i<=90;i++){
				map.put((char) i, 0);
			}
			for(i=0;i<chs.length;i++){
				if(chs[i] <= 90 && chs[i] >= 65){
					if(map.containsKey(chs[i])){
						map.put(chs[i], map.get(chs[i])+1);
					}else{
						map.put(chs[i], 1);
					}
				}
			}
			//好像是用不到排序
			List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>() {

				@Override
				public int compare(Entry<Character, Integer> o1,
						Entry<Character, Integer> o2) {
					// TODO Auto-generated method stub
					return o1.getKey()-o2.getKey();
				}
			});
			for(Map.Entry<Character,Integer> entry : list){
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
				
		}
	}

}
