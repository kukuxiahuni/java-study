
public class Algorithm5 {

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

    public int findMin(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        if (nums.length == 1) {
            return nums[1];
        }


        int min = 0, end = nums.length - 1;

        while (min < end) {
            int middle = min + ((end - min) >> 1);

            if (nums[middle] > nums[min] && nums[middle] > nums[end]) {
                min = middle + 1;
            } else {
                end = middle;
            }

        }

        return nums[min];

    }


}