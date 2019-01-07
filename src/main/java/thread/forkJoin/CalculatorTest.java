package thread.forkJoin;

/**
 * @author qingxiao
 * @date 2018-12-29  15:34
 */
public class CalculatorTest {

    public static void main(String[] args) {
        ForLoopCalculator calculator = new ForLoopCalculator();
        ExecutorServiceCalculator executorServiceCalculator = new ExecutorServiceCalculator();
        ForkJoinCalculator forkJoinCalculator = new ForkJoinCalculator();
        int size = 99999;
        long[] sumList = new long[size];
        for (int i =1; i <= size; i ++) {
            sumList[i -1] = i;
        }
        //long resut = calculator.sumUp(sumList);
        long resut = executorServiceCalculator.sumUp(sumList);
        long result2 = forkJoinCalculator.sumUp(sumList);
        System.out.println(resut);
    }
}
