package jobdu1029;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Map<String,String> map = new HashMap<String, String>();
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			while(!"@END@".equals(str)){
				String header = str.substring(str.indexOf("[") + 1,str.indexOf("]"));
				String content = str.substring(str.indexOf("]") + 2);
				map.put(header, content);
				str = scanner.nextLine();
			}
			int num = Integer.valueOf(scanner.nextLine());
			for(int i=0;i<num;i++){
				String testCase = scanner.nextLine();
				String result = "";
				 if(testCase.charAt(0)=='['){
					 testCase = testCase.substring(1,testCase.length()-1);
					 result = map.get(testCase);
				 }else{
						for(Map.Entry<String, String> entry : map.entrySet()){
							if(entry.getValue().equals(testCase)){
								result = entry.getKey();
								break;
							}
						}
					}
				if(result!=null && !"".equals(result)){
					System.out.println(result);
				}else{
					System.out.println("what?");
				}
			}
		}
	}
}
