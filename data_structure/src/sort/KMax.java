package sort;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * @program: java-study
 * @className: KMax
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-08-29 12:10
 * @version: v1.0
 **/
public class KMax {
    public int findKthLargest(int[] nums, int k) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.getOrDefault("a", "a");
        /**
         * 默认生成小顶堆
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
