package chapter14;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerEx {
    public static void main(String[] args) {
        Consumer<String> consumer = t -> System.out.println(t+"8");
        consumer.accept("Java");

        BiConsumer<String, String> consumer1 = (t,u) -> System.out.println(t+u);
        consumer1.accept("Java","8");

        DoubleConsumer consumer2 = d -> System.out.println("Java"+d);
        consumer2.accept(8.0);

        ObjIntConsumer<String> consumer3 = (t, i) -> System.out.println(t+i);
        consumer3.accept("Java",8);
    }
}
