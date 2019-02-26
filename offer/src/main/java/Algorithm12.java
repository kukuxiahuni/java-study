import java.util.Arrays;

/**
 * @program: java-study
 * @className: Algorithm12
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-02-26 20:05
 * @version: v1.0
 **/
public class Algorithm12 {

        public int singleNumberII(int[] A) {
            // write your code here
            if (A == null || A.length == 0) {
                throw new IllegalArgumentException();
            }

            int[] bitSum = new int[32];
            Arrays.fill(bitSum, 0);




            for (int a : A) {
                //1. 计算数组的每一位
                for (int i = 0; i < 32; ++i) {

                    if ((a & (1<<i)) != 0) {
                        bitSum[31 - i] = (bitSum[31 - i] + 1) % 3;
                    }

                }

            }


            int result = 0;
            for (int i = 0; i < 32; ++i) {
                result = result * 2 + bitSum[i];
            }

            return result;


        }

        public static void main(String[] args) {
            Algorithm12 algorithm9 = new Algorithm12();

            int[] array = {1, 3, 3, 3, 2, 2, 2, 1, 1, 4};
            System.out.println(algorithm9.singleNumberII(array));
        }


}
