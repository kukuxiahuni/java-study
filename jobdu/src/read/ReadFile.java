package read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
	private static Properties properties;
	// private static Set<String > keySets;
	static {
		// 静态代码快，用于读取配置文件信息
		InputStream in = null;
		try {
			in = ClassLoader
					.getSystemResourceAsStream("read/properties/read.properties");
			properties = new Properties();
			properties.load(in);
//			Set<String> keySets = properties.stringPropertyNames();

//			for (String set : keySets) {
//				System.out.println(set);
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 方法名称：main() 方法描述：
	 * 
	 * @param
	 * @return String
	 * @Exception
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(
					new File("D:/eight.txt")));
			writer = new PrintWriter(new File("D:/pdll.txt"));
			String str;
			// 指定函数名称的序号 如：P0
			int index = 0;
			// 查找函数名信息
			while ((str = reader.readLine()) != null) {

				String regex = "Procedure\\s+([a-zA-Z0-9_]+)\\(.*\\)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(str);

				if (matcher.matches()) {
					// 存储方式： 函数名，
					map.put(matcher.group(1), "P" + index);
					index++;
				}
			}

//			for (Map.Entry<String, String> entry : map.entrySet()) {
//				System.out.println(entry.getKey() + " : " + entry.getValue());
//			}
			//读入时解决中文乱码问题
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/eight.txt"),"gbk"));
			str = null;
			StringBuffer buffer = new StringBuffer();
			Set<String> keySets = properties.stringPropertyNames();
			while ((str = reader.readLine()) != null) {
				if ("begin".equals(str)) {
					int lineIndex = 1;
					buffer.append(str + "\n");
					while ((str = reader.readLine()) != null) {
						if (str.startsWith("end:")) {
							break;
						}
						// 判断其是否是函数名称
						String regex = "([a-zA-Z0-9_]+)\\(.*\\).*";
						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(str);

						if (matcher.matches()) {
							// 存储方式： 函数名，
							// 是函数名称
							if (map.containsKey(matcher.group(1))) {
								if(map.get(matcher.group(1)) != null ){
									
									buffer.append(map.get(matcher.group(1)));
									buffer.append(":");
								}
							}
							buffer.append(str);
							buffer.append("\n");
						} else {
							// 判断是否是保留字类型
							String[] temp = str.split(" ");
							// for(String s : temp){
							if (keySets.contains(temp[0])) {
								buffer.append(lineIndex++);
								buffer.append(":");
							}
							// }
							buffer.append(str);
							buffer.append("\n");
							
							if(keySets.contains(temp[0]) && "for".equals(temp[0])){
								//读取下一非空行
								String tem = "";
								//标记是否存在需要标记的内容
								boolean flag = false;
								
								while((str=reader.readLine())!=null && !"endfor".equals(str)){
									
//									System.out.println(str);
									if(keySets.contains(str.split(" ")[0])){
										flag = true;
									}
									tem += str + "\r\n";
								}
								String[] substrs = tem.split("\r\n");
								
								if(flag){
									for(int i=0;i<substrs.length;i++){
										//有
//										System.out.println(substrs[i].split(" ")[0]);
										//判断是否是函数ming
										matcher = pattern.matcher(substrs[i]);
										if(matcher.matches()){
											if(map.get(matcher.group(1)) != null ){
												buffer.append(map.get(matcher.group(1)));
												buffer.append(":");
											}

										}else if (keySets.contains(substrs[i].split(" ")[0])) {
											buffer.append(lineIndex++);
											buffer.append(":");
										}
										buffer.append(substrs[i]);
										buffer.append("\n");
									}
								}else{
									for(int i=0;i<substrs.length;i++){
										if (keySets.contains(substrs[i].split(" ")[0]) || substrs[i].startsWith("do")) {
											buffer.append(lineIndex++);
											buffer.append(":");
										}
										
										buffer.append(str);
										buffer.append("\n");
									}
								}
								
								//补充漏掉的endfor
								buffer.append(lineIndex++);
								buffer.append(":");
								buffer.append(str);
								buffer.append("\n");
							}
						}
					}
				}
				buffer.append(str);
				buffer.append("\n");

			}
			 System.out.println(buffer.toString());
			String out = buffer.toString().replaceAll("\n", "\r\n");
			writer.write(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
