import javax.xml.transform.Source;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-18 09:19
 **/
public class Algorithm6 {

    public int[][] generateMatrix(int n) {
        // write your code here

        if (n <= 0) {
            return null;
        }

        int rows = n;
        int columns = n;

        int start = 0;

        int[][] result = new int[rows][columns];
        int num = 1;
        while (rows > start * 2 && columns > start * 2) {

            int endRows = rows - 1 - start;
            int endColums = columns - 1 - start;

            //1. 填充最上面的行
            if (start <= endColums) {
                for (int i = start; i <= endColums; ++i) {
                    result[start][i] = num++;
                }
            }

            //2. 填充最右侧列:起码两行起
            if (start <= endRows) {
                for (int i = start + 1; i <= endRows; ++i) {
                    result[i][endColums] = num++;
                }
            }

            //3. 填充最下面行
            if (start < endRows && start < endColums) {
                for (int i = endColums - 1; i >= start; --i) {
                    result[endRows][i] = num++;
                }
            }

            //4. 填充最左侧行
            if (endRows - 1 > start && start < endColums) {
                for (int i = endRows - 1; i > start; --i) {
                    result[i][start] = num++;
                }
            }


            ++start;
        }

        return result;


    }

    public static void main(String[] args) {
        int[][] result = null;
        int n = 4;
        Algorithm6 algorithm6 = new Algorithm6();
        result = algorithm6.generateMatrix(n);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
