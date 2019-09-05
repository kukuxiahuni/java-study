package com.java.study;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @program: java-study
 * @description:访问者模式. 不可变的对象结构和多变的算法结构
 * @author: kukuxiahuni
 * @create: 2019-01-04 17:16
 **/
public class Visitor {

    public void test() {
        Predicate<Integer> predicate = a -> a > 5;
        predicate.and(b -> b < 10);
        boolean result = predicate.test(4);
        System.out.println(result);
        String[] arrays = {"a", "b", "c"};
        Arrays.stream(arrays).reduce("", (x, y) -> x + y);
        IntStream.range(1, 2).forEach(System.out::println);
    }

    public interface ComputerPartVisitor {

        void visit(Computer computer);

        void visit(Mouse mouse);

        void visit(Keyboard keyboard);

        void visit(Monitor monitor);
    }

    public interface ComputerPart {

        void accept(ComputerPartVisitor visitor);

    }

    public class Computer implements ComputerPartVisitor {
        @Override
        public void visit(Computer computer) {
            System.out.println("Displaying Computer.");
        }

        @Override
        public void visit(Mouse mouse) {
            System.out.println("Displaying Mouse.");
        }

        @Override
        public void visit(Keyboard keyboard) {
            System.out.println("Displaying Keyboard.");
        }

        @Override
        public void visit(Monitor monitor) {
            System.out.println("Displaying Monitor.");
        }
    }

    public class Mouse implements ComputerPartVisitor {
        @Override
        public void visit(Computer computer) {

        }

        @Override
        public void visit(Mouse mouse) {

        }

        @Override
        public void visit(Keyboard keyboard) {

        }

        @Override
        public void visit(Monitor monitor) {

        }
    }

    public class Keyboard implements ComputerPartVisitor {
        @Override
        public void visit(Computer computer) {

        }

        @Override
        public void visit(Mouse mouse) {

        }

        @Override
        public void visit(Keyboard keyboard) {

        }

        @Override
        public void visit(Monitor monitor) {

        }
    }

    public class Monitor implements ComputerPartVisitor {
        @Override
        public void visit(Computer computer) {

        }

        @Override
        public void visit(Mouse mouse) {

        }

        @Override
        public void visit(Keyboard keyboard) {

        }

        @Override
        public void visit(Monitor monitor) {

        }
    }


}
