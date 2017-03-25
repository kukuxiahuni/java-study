package jobdu1068;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			double x0 = scanner.nextInt();
			double y0 = scanner.nextInt();
			double z0 = scanner.nextInt();
			double x1 = scanner.nextInt();
			double y1 = scanner.nextInt();
			double z1 = scanner.nextInt();
			
			double r = Math.sqrt(Math.pow((x1-x0),2) + Math.pow((y1-y0),2) + Math.pow((z1-z0),2));
			double v = 4 * Math.acos(-1) * Math.pow(r, 3) / 3;
			System.out.format("%.3f %.3f\n", r,v);
		}
	}
}
