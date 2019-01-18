public class Algorithm3 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 5, 7, 6};


        //1. 数字与下标是不是一致；
        //2. 一致：判断数字与下一个数字是不是相等，若相等，则返回
        //3. 不一致：进行数字交换

        for (int i = 0; i < nums.length; ++i) {

            while (i != nums[i]) {

                if (nums[i] == nums[nums[i]]) {
                    System.out.println(nums[i]);
                    return;
                }
                //3.  不一致，进行数值交换
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;

            }

        }



    }



}
