package SearchLearning;

/**
 * java-study
 * SearchLearning
 * Created by kukuxiahuni on 2019/1/19.
 */
public class Fibonacci {


    /**
     * @param n
     */
    public final static void fibonacci(int n) {

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n < 2) {
            System.out.println(n);
            return;
        }

        //f(n) = f(n-1) + f(n-2) when n >= 2

        int one = 0;
        int two = 1;

        int sum = 0;

        for (int i = 2; i <= n; ++i) {

            sum = one + two;
            one = two;
            two = sum;

        }

        System.out.println(sum);


    }

    public final static int fibonacciRec(int n) {

        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n < 2) {
            return n;
        }

        return fibonacciRec(n-1) + fibonacciRec(n-2);

    }

    public static void main(String[] args) {
        fibonacci(100);
        System.out.println(fibonacciRec(100));
    }
}
