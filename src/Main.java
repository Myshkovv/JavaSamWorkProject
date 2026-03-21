import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Stream stream = (Stream) Arrays.stream(ints);
//        stream.forEach(x -> System.out.println(x));


//        int[] a = new int[] {1, 2, 3, 5, 7};
//
//        IntStream stream = Arrays.stream(a).filter(x->x%2==0);
//
//        a[0] = 10;
//        a[2] = 4;
//
//        stream.forEach(System.out::println);
        

        Stream<String> stream = Stream.of("Moscow", "London", "Paris", "Kazan");

        stream.forEach(System.out::println);// после этого не можем работать со стримом



    }
}