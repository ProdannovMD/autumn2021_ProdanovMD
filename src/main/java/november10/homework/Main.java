package november10.homework;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 6, 123, 12, 312, 1425);
        Integer[] intArray = integerStream.collect(MyCollectors.toArray(new Integer[0]));
        System.out.println(Arrays.toString(intArray));
    }
}
