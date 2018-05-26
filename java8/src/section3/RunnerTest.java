package section3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * java-study
 * section3
 * Created by kukuxiahuni on 2018/5/13.
 */
public class RunnerTest {

    public static void main(String[] args) throws Exception {
        Runnable runnable = () -> System.out.println("Hello, world");
        process(runnable);

//        String oneLine = processFile(bufferedReader -> bufferedReader.readLine());

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmptyString = filter(new ArrayList<String>(), nonEmptyStringPredicate);

        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println(evenNumbers.test(2));
    }

    public static void process(Runnable runnable) {
        runnable.run();
    }

    public static String processFile(BufferedReaderProcessor processor) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
            return processor.process(br);
        }
    }

    /**
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();

        for (T t : list) {
            if (predicate.test(t)) {
                results.add(t);
            }
        }
        return results;
    }


}
