import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: java-study
 * @className: Algorithm5
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-02-19 10:09
 * @version: v1.0
 **/
public class Algorithm9 {
    /**
     * @param nums: n non-negative integer array
     * @return: A string
     */
    public String minNumber(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return "0";
        }

        //1. 搞字符串数组
        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strArray[i] = String.valueOf(nums[i]);
        }
        //2. 字符串数组排序
        Arrays.sort(strArray, new Algorithm9.Com());

        //3. 输出字符串
        //3.1 拼接字符串
        String ans = "";
        for (int i = 0; i <= strArray.length - 1; ++i) {
            ans = ans.concat(strArray[i]);
        }

        //3.2 找到字符不为0的位置
        int index = 0;
        while (index < strArray.length && ans.charAt(index) == '0') {
            ++index;
        }

        if (index == strArray.length) {
            return "0";
        }

        return ans.substring(index);

    }

    public static void main(String[] args) {
        Algorithm9 algorithm5 = new Algorithm9();

        int[] nums = {3, 32, 321};
        System.out.println(algorithm5.minNumber(nums));
    }


    class Com implements Comparator<String> {
        @Override
        public int compare(String a, String b) {

            String ab = a.concat(b);
            String ba = b.concat(a);

            return ab.compareTo(ba);

        }

    }
}