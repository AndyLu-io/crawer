package basicTest;

import java.util.Scanner;

/**
 * @author qingxiao
 * @date 2019-04-27  18:45
 */
public class ScannerTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println("你输入了" +  s);
    }
}
