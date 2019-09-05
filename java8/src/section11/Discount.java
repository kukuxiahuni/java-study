package section11;

import java.util.Random;

/**
 * java-study
 * section11
 * Created by kukuxiahuni on 2018/6/3.
 */
public class Discount {

    private final Random random = new Random();

    public enum Code{
        NONE(0), SILVER(5);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }

    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Code.values().length)];
        return String.format("%s:%.2f:%s", code.name());
    }

    private double calculatePrice(String product) {
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
