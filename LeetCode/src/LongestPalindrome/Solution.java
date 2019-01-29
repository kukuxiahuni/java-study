package LongestPalindrome;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-29 11:58
 **/
public class Solution {

    /**
     * 1. 采用动态规划实施
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        int max = 0;
        String result = "";
        //1. 初始化二维数组，用于记录 p(i,j)的长度
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {

                dp[j][i] = ((s.charAt(j) == s.charAt(i)) && (dp[j + 1][i - 1] || i - j <= 2));

                if (dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    result = s.substring(j, i);
                }


            }
        }

        return result;


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aba"));
    }
}
