package section11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * java-study
 * section11
 * Created by kukuxiahuni on 2018/6/3.
 */
public class CompleteableFutureTest {

    public Future<Double> getPriceAsync(String product) {

        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = 1.0;
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();

        return futurePrice;
    }

    public Future<Double> getPriceAsyncWithFactory(String product) {

        return CompletableFuture.supplyAsync(() -> {
            return 1.0;
        });

    }


}
