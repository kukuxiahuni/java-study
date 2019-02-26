import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm11 {

    List<List<String>> result = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        // write your code here

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        int[] column = new int[n];
        int[] l2r = new int[2 * n - 1];
        int[] r2l = new int[2 * n - 1];
        int[] answer = new int[n]; //记录第i行j列的数据

        Arrays.fill(column, 0);
        Arrays.fill(l2r, 0);
        Arrays.fill(r2l, 0);
        dfs(0, n, column, l2r, r2l, answer);
        return result;


    }

    public void dfs(int row, int n, int[] column, int[] l2r, int[] r2l, int[] answer) {

        if (row >= n) {
            List<String> unit = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                int c = answer[i];
                for (int j = 0; j < n; ++j) {
                    if (j == c) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                unit.add(sb.toString());

            }

            result.add(unit);


        } else {

            for (int c = 0; c < n; ++c) {

                if (column[c] != 1 && l2r[c-row + n - 1] != 1 && r2l[c + row] != 1) {
                    answer[row] = c;
                    column[c] = l2r[c-row + n - 1] = r2l[c + row] = 1;
                    dfs(row + 1, n, column, l2r, r2l, answer);
                    //恢复现场
                    column[c] = l2r[c-row + n - 1] = r2l[c + row] = 0;

                }

            }
        }

    }

    public static void main(String[] args) {
        Algorithm11 algorithm11 = new Algorithm11();

        System.out.println(algorithm11.solveNQueens(2));
    }


}
