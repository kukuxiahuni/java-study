package section10;

import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * java-study
 * section10
 * Created by kukuxiahuni on 2018/6/3.
 */
public class OptionalTest {

    private final Executor executor = Executors.newFixedThreadPool(Math.min(1, 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true); //使用守护线程，保证线程会被回收

            return t;
        }
    });



    public static void main(String[] args) {
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        Optional<Car> optCar = optPerson.flatMap(Person::getCar);

//        Optional<String> name = optPerson.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName);

        Optional<String> name = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
    }

    public int readDuration(Properties properties, String name) {

        //1. 获取optional值， String的
        return Optional.ofNullable(properties.getProperty("name"))
                //2. flatmap，将optional<String> ----> Optional<Integer>
                //3. Optional的value值是不可变的
                .flatMap(OptionalTest::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);

    }

    public final static Optional<Integer> stringToInt(String s) {

        try {
            Runtime.getRuntime().availableProcessors();

            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

    }
}
