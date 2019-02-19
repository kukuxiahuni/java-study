/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-18 09:19
 **/
public class Algorithm7 {
    public int digitCounts(int k, int n) {
        // write your code here

        int count = 0;

        for (int i = 0; i <= n; ++i) {
            int realCount = numCount(i, k);
            count += realCount;
        }

        return count;
    }

    public int numCount(int num, int k) {

        if (num == 0 && k == 0) {
            return 1;
        }

        int count = 0;
        while (num > 0) {

            if (num % 10 == k) {
                ++count;

            }

            num = num / 10;


        }

        return count;

    }

    public static void main(String[] args) {
        int result = 0;
        Algorithm7 algorithm6 = new Algorithm7();
        result = algorithm6.digitCounts(0, 1);
        System.out.println(result);

    }
}
