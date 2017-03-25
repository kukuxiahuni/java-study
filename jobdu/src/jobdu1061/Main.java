package jobdu1061;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：成绩排序 
 * 1 首先按成绩升序, 
 * 2 成绩相同则按姓名生序, 
 * 3 姓名相同则按年龄升序.
 * 创建人：黄传聪
 * 创建时间：2013-11-11 上午9:14:28
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	private String name;
	private int age;
	private int score;
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
		List<Main> list = null;
		while(scanner.hasNext()){
			list = new ArrayList<Main>();
			int n = scanner.nextInt();
			int i;
			Main student = null;
			for(i=0;i<n;i++){
				student = new Main();
				student.name = scanner.next();
				student.age = scanner.nextInt();
				student.score = scanner.nextInt();
				list.add(student);
			}
			
			
			Collections.sort(list, new Comparator<Main>() {

				@Override
				public int compare(Main o1, Main o2) {
					// TODO Auto-generated method stub
					if(o1.score > o2.score){
						return 1;
					}else if(o1.score == o2.score){
						if(o1.name.compareTo(o2.name) == 0){
							return o1.age - o2.age;
						}else {
							return o1.name.compareTo(o2.name);
						}
					}else{
						return -1;
					}
				}
			});
			
			for(Main m : list){
				System.out.println(m.name + " " + m.age + " " + m.score);
			}
		}
	}

}
