package dp;

import java.util.Arrays;

/**
 * longest increasing subsequence 最长非降子序列
 * ProjectName: data_structure
 * Package: dp
 * Created by kukuxiahuni on 17/1/6.
 */
public class Lis {

    private int length;
    private int[] longest;

    private int[] array;

    public Lis(int[] array) {

        if (array == null || array.length == 0) {
            System.out.println("请正确输入数据");
            return;
        }
        this.array = array;
        this.length = this.array.length;
        this.longest = new int[this.length];
//        this.longest[0] = 1; //设定第一个元素的非降子序列的长度为1
        Arrays.fill(this.longest, 1);
    }

    /**
     *
     */
    public int lis() {

        int maxLen = 1;
        for (int i=1; i<this.length; ++i) {
            for (int j=0; j<i; ++j) {
                if (array[j] <= array[i] && longest[j] + 1 > longest[i]) {
                    longest[i] = longest[j] + 1;
                }
            }

            if (longest[i] > maxLen) {
                maxLen = longest[i];
            }
        }

        return maxLen;
    }

    /**
     * 输出最长子序列
     */
    public void print() {
        for (int i : longest) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 8, 6, 7};
        Lis lis = new Lis(array);
        System.out.println(lis.lis());
        lis.print();
    }
}
