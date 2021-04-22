package lambda;

import org.junit.Test;

import java.util.function.Consumer;

public class lambda1 {
    //没有形参和返回值的情况
    @Test
    public void test1()
    {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("兰帕德真牛");
            }
        };
        runnable.run();
        Runnable runnable1=()-> System.out.println("java真牛");
        runnable1.run();
    }
    //一个参数 但没有返回值的情况
    @Test
    public void test2()
    {Consumer<String> consumer=new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };
    consumer.accept("ccc");

    Consumer<String> consumer1=(String s)-> System.out.println(s);
    consumer1.accept("aaa");

    }
    //泛型的类型可以省略,因为编译器可以推断出,"类型推断"
    @Test
    public void test3()
    {

        Consumer<String> consumer=new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };
        consumer.accept("ccc");

        Consumer<String> consumer1=(s)-> System.out.println(s);
        consumer1.accept("aaa");

    }

}
