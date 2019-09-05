package section6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @program: java-study
 * @className: ForkJoinSumCal
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-09-05 17:30
 * @version: v1.0
 **/
public class ForkJoinSumCal extends RecursiveTask<Long> {
    public static final long THRESHOLD = 10_000;
    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinSumCal(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    /**
     * @param numbers
     * @param start
     * @param end
     */
    public ForkJoinSumCal(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCal(numbers);
        return new ForkJoinPool().invoke(task);
    }

    @Override
    protected Long compute() {
        int length = this.end - this.start;
        if (length <= THRESHOLD) {
            return doSeq();
        }

        ForkJoinSumCal leftTask = new ForkJoinSumCal(numbers, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumCal rightTask = new ForkJoinSumCal(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    /**
     * 功能描述: TODO
     *
     * @param:
     * @return:
     * @auther: kukuxiahuni
     * @date: 2019-09-05 17:37
     * @modify_auther: kukuxiahuni
     * @modify_time: 2019-09-05 17:37
     **/
    private long doSeq() {
        long sum = 0;
        for (long num : this.numbers) {
            sum += num;
        }
        return sum;
    }
}
