import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Algorithm3Test {

    @Test
    public void findDumplateNumWithoutChangeArray() {

        Integer[] nums = {1, 2, 4, 3, 5, 5, 7, 6};

        Map<Integer, Integer> countMap = new HashMap<>(nums.length);

        Stream.of(nums).forEach(num -> {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                System.out.println(num);
                return;
            }
        });
    }

    @Test
    public void findDumplateNumWithoutChangeArray2() {
        Integer[] nums = {1, 2, 4, 3, 5, 5, 7, 6};
        Integer[] copy = new Integer[nums.length];
        Arrays.fill(copy, 0);

        Stream.of(nums).forEach(num -> {
                    if (copy[num] != 0) {
                        System.out.println(num);
                        return;
                    } else {
                        copy[num] = num;
                    }
                }
        );
    }

    /**
     * 采用分治策略
     * 1. 注意是将 1-n进行分治，不是将无序数组 nums进行分治；
     * 2. 针对每一段分治的1-m, 都有统计nums在这个区间内的元素数量；如果 count > m-1 + 1 则在此处有重复
     */
    @Test
    public void findDumplateNumWithoutChangeArray3() {
        int[] nums = {1, 2, 4, 3, 5, 5, 7, 6};

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            //1. mid = (low + end) >> 1, 但是这样会出现int类型上溢
            //2. (low+end) = (low + low - low + end ) 故 mid = low + (end -low)/2
            int mid = start + ((end - start) >> 1);

            int count = count(nums, start, mid);

            if (end == start) {
                if (count > 1) {
                    System.out.println(nums[start]);
                    break;
                }
            }

            //3. 左半区
            if (count > (mid - start) + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }

            System.out.println("begin=" + start + " , end = " + end);


        }
    }

    /**
     * 统计什么数字
     *
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    private final static int count(int[] nums, int begin, int end) {

        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= begin && nums[i] <= end) {
                ++count;
            }
        }
        return count;
    }


}