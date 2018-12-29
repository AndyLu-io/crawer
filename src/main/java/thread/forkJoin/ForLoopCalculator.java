package thread.forkJoin;

/**
 * @author qingxiao
 * @date 2018-12-28  16:44
 */
public class ForLoopCalculator implements Calculator {

    @Override
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }
}
