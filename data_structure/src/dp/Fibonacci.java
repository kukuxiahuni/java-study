package dp;

/**
 * @program: java-study
 * @className: Fi
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-09-16 10:09
 * @version: v1.0
 **/
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(20));
    }

    /**
     * 功能描述: TODO
     *
     * @param:
     * @return:
     * @auther: kukuxiahuni
     * @date: 2019-09-16 10:10
     * @modify_auther: kukuxiahuni
     * @modify_time: 2019-09-16 10:10
     **/
    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
