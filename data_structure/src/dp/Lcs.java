package dp;

import java.util.Arrays;

/**
 * todo:还没写完：https://www.kancloud.cn/digest/pieces-algorithm/163624
 * 参考：http://blog.csdn.net/v_JULY_v/article/details/6110269
 * Created by kukuxiahuni on 2018/3/1.
 * 最长公共子序列：求解两个字符串的最长公共子序列，其中子序列不一定连续
 * 递归算法
 */
public class Lcs {

    public int findLcs(String a, String b) {

        if (isBlank(a) && isBlank(b)) {
            throw new IllegalArgumentException();
        }

        if (isBlank(a) || isBlank(b)) {
            return 0;
        }

        int[][] commString = new int[a.length() + 1][b.length() + 1];

        for (int[] array : commString) {
            Arrays.fill(array, 0);
        }

        // -表示相等
        // <-表示来自a
        // -> 表示来自b
        String[][] source = new String[a.length() + 1][b.length() + 1];

        //dp
//        char[] aArray = a.toCharArray();
//        char[] bArray = b.toCharArray();

        for (int i = 1; i < a.length(); ++i) {
            for (int j = 1; j < a.length(); ++j) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    commString[i][j] = commString[i - 1][j - 1];
                    source[i][j] = "-";
                } else if (commString[i - 1][j] > commString[i][j - 1]) {
                    commString[i][j] = commString[i - 1][j];
                    source[i][j] = "<-";
                } else if (commString[i - 1][j] < commString[i][j - 1]) {
                    commString[i][j] = commString[i][j - 1];
                    source[i][j] = "->";
                }
            }

        }

        return commString[a.length()][b.length()];

    }


    private boolean isBlank(String s) {

        return s == null && s.length() == 0;
    }

    public static void main(String[] args) {
        Lcs lcs = new Lcs();
        System.out.println(lcs.findLcs("abc", "bc"));

    }

}
