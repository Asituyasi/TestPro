package muitithread;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class IntConsumerTest {
    public static void main(String[] args) {
        IntConsumer outPrint = System.out::println;
        IntConsumer errPrint = System.err::println;
        int[] arr = {1,2,3,4,5};
        Arrays.stream(arr).forEach(outPrint.andThen(errPrint));
    }
}