package Demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            final int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    if (finalI % 3 == 0) {
                        System.out.print('a');
                    }
                    if (finalI % 3 == 1) {
                        System.out.print('b');
                    }
                    if (finalI % 3 == 2) {
                        System.out.println('c');
                    }
                }
            });
        }
    }
}
