import org.junit.Test;

/**
 * @program: java-study
 * @description:
 * @author: kukuxiahuni
 * @create: 2019-01-18 10:35
 * 二分查找
 **/
public class BinarySearch {

    @Test
    public void bsWithIterator() {

        int[] nums = {1, 2, 4, 3, 5, 5, 7, 6};
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);

            if (mid == 5) {
                return;
            } else if (nums[mid] < 5) {
                //右侧
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
    }

    @Test
    public void bsWithRecurisive(int[] nums, int begin, int end) {
        int mid = begin + ((end - begin) >> 1);
        if (mid == 5) {
            return;
        } else if (nums[mid] < 5) {
            //右侧
            bsWithRecurisive(nums, mid + 1, end);
        } else {
            //左侧
            bsWithRecurisive(nums, begin, mid);
        }
    }
}
