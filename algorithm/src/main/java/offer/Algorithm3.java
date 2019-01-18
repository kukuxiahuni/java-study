package offer;

/**
 * @program: java-study
 * @description: 查找数组中的重复数字
 * @author: kukuxiahuni
 * @create: 2019-01-17 18:37
 * 解决思路：1. map：记录每个位置的数字的数量
 * 2. 将每个数字放在放在相应的位置
 **/
public class Algorithm3 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 5, 7};

        //1. 数字与下标是不是一致；
        //2. 一致：判断数字与下一个数字是不是相等，若相等，则返回
        //3. 不一致：进行数字交换

        for (int i = 0; i < nums.length; ++i) {

            if (i == nums[i]) {
                if (i + 1 < nums.length && i == nums[i + 1]) {
                    System.out.println(i);
                    return;
                }
            }

            //3.  不一致，进行数值交换
            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp;
        }


    }


}
