package section3;

import java.io.BufferedReader;

/**
 * java-study
 * section3
 * Created by kukuxiahuni on 2018/5/13.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws Exception;
}
