package dp;

import java.util.Arrays;

/**
 * 动态规划,查找最少使用钱数
 * ProjectName: data_structure
 * Package : ${PACKAGE_NAME}
 * Created by kukuxiahuni on 16/12/28.
 */
public class Leatest {

    private static int[] coins = {1, 3, 5};

    public static void dp(int sum) {

        int[] minCounts = new int[sum + 1];
        //注意次数要将除0号位之外的所有位设置为最大值
        Arrays.fill(minCounts, Integer.MAX_VALUE);
        minCounts[0] = 0;

        for (int value = 1; value <= sum; ++value) {

            for (int j = 0; j < coins.length; ++j) {

                if (coins[j] <= value) {
                    if (minCounts[value] > minCounts[value - coins[j]] + 1) {
                        minCounts[value] = minCounts[value - coins[j]] + 1;
                    }
                }
            }
        }

        for (int counts : minCounts) {
            System.out.println(counts);
        }


    }

    public static void main(String[] args) {
        dp(11);
    }
}
