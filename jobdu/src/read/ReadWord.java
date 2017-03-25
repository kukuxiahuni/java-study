/**
 * 文件名：ReadWord.java
 * 所在包：read
 * 日期：2013-10-27 下午8:13:30
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hwpf.extractor.WordExtractor;
/**
 *
 * 项目名称：jobdu
 * 类名称：ReadWord
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-27 下午8:13:30
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ReadWord {

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
//		try {
//			Scanner scanner = new Scanner(new FileInputStream(new File("D:/test.doc")),"ISO8859-1");
//			while(scanner.hasNext()){
////				byte[] buffer = scanner.next().getBytes();
////				String str = null;
////				if(buffer[0] == -17 && buffer[1] == -69 && buffer[2] == -65){
////					 str = new String(buffer,"UTF-8");
////				}else{
////					str = new String(buffer,"gbk");
////				}
//				String str = scanner.nextLine();
//				System.out.println(str);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		BufferedInputStream bufferedInputStream = null;
//		FileOutputStream out = null;
//		try {
//			 bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("D:/test.doc")));
//			 out = new FileOutputStream(new File("D:/a.doc"));
//			byte[] buffer = new byte[1024];
//			int in = 0;
//			while((in=bufferedInputStream.read(buffer))!= -1){
////				String str = new String(buffer);
////				System.out.println(str);
//				out.write(buffer, 0, in);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				out.close();
//				bufferedInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/test.txt")),"gbk"));
//		 String s=null; 
//		 while((s=br.readLine())!=null) 
//         { 
//             //System.out.println(s); 
//             System.out.println(s);
//         } 
//			
		FileInputStream in = new FileInputStream(new File("D:/test.doc"));
		WordExtractor wordExtractor = new WordExtractor(in);
		
		String text = wordExtractor.getText();
		System.out.println(text);
		
		}

	}


