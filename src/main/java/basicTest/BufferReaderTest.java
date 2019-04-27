package basicTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author qingxiao
 * @date 2019-04-27  18:48
 */
public class BufferReaderTest {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        System.out.println("你输入了：" +  s);

    }
}
