package section6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @program: java-study
 * @className: Section6
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-09-06 09:58
 * @version: v1.0
 **/
public class Section6 {

    public void test() {
        String oneLine = processFile((BufferedReader b) -> b.readLine());

    }

    public String processFile(BufferedReaderProcessor bufferedReaderProcessor) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(""))) {
            return bufferedReaderProcessor.process(bufferedReader);
        }
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futureAsync = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice("a");
            futureAsync.complete(price);

        }).start();

        return futureAsync;
    }

    /**
     * 功能描述: TODO
     * @param: 
     * @return: 
     * @auther: kukuxiahuni
     * @date: 2019-09-09 14:41
     * @modify_auther: kukuxiahuni
     * @modify_time: 2019-09-09 14:41
     **/
    public Future<Integer> getPrice(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice("a"));
    }

    private final int calculatePrice(String product) {
        return Integer.MAX_VALUE;
    }

    /**
     * 功能描述: TODO
     *
     * @param:
     * @return:
     * @auther: kukuxiahuni
     * @date: 2019-09-06 10:00
     * @modify_auther: kukuxiahuni
     * @modify_time: 2019-09-06 10:00
     **/
    private interface BufferedReaderProcessor {
        String process(BufferedReader bufferedReader) throws IOException;
    }
}
