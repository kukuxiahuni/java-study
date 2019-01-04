package com.java.study;

/**
 * @program: java-study
 * @description:访问者模式. 不可变的对象结构和多变的算法结构
 * @author: kukuxiahuni
 * @create: 2019-01-04 17:16
 **/
public class Visitor {

    public interface ComputerPartVisitor {

        void visit(Computer computer);

        void visit(Mouse mouse);

        void visit(Keyboard keyboard);

        void visit(Monitor monitor);
    }

    public class Computer implements ComputerPartVisitor {
        public void visit(Computer computer) {
            System.out.println("Displaying Computer.");
        }

        public void visit(Mouse mouse) {
            System.out.println("Displaying Mouse.");
        }

        public void visit(Keyboard keyboard) {
            System.out.println("Displaying Keyboard.");
        }

        public void visit(Monitor monitor) {
            System.out.println("Displaying Monitor.");
        }
    }

    public class Mouse implements ComputerPartVisitor {
        public void visit(Computer computer) {

        }

        public void visit(Mouse mouse) {

        }

        public void visit(Keyboard keyboard) {

        }

        public void visit(Monitor monitor) {

        }
    }

    public class Keyboard implements ComputerPartVisitor {
        public void visit(Computer computer) {

        }

        public void visit(Mouse mouse) {

        }

        public void visit(Keyboard keyboard) {

        }

        public void visit(Monitor monitor) {

        }
    }

    public class Monitor implements ComputerPartVisitor {
        public void visit(Computer computer) {

        }

        public void visit(Mouse mouse) {

        }

        public void visit(Keyboard keyboard) {

        }

        public void visit(Monitor monitor) {

        }
    }

    public interface ComputerPart {

        void accept(ComputerPartVisitor visitor);

    }


}
