package java8;

import java.util.Arrays;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 下午12:05  2017/11/3
 */
public class StreamTest {

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 45).stream()
              .filter(i -> i % 2 == 0 || i % 3 == 0)
              .map(i -> i * i)
              .forEach(System.out::println);

    }
}
