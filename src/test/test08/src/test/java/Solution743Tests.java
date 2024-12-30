import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution743Tests {
    private final Solution743 solution743 = new Solution743();

    @Test
    public void example1() {
        int[][] times = UtUtils.stringToInts2("[[2,1,1],[2,3,1],[3,4,1]]");
        int n = 4;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution743.networkDelayTime(times, n, k));
        Assertions.assertEquals(expected, solution743.networkDelayTime2(times, n, k));
    }

    @Test
    public void example2() {
        int[][] times = UtUtils.stringToInts2("[[1,2,1]]");
        int n = 2;
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution743.networkDelayTime(times, n, k));
        Assertions.assertEquals(expected, solution743.networkDelayTime2(times, n, k));
    }

    @Test
    public void example3() {
        int[][] times = UtUtils.stringToInts2("[[1,2,1]]");
        int n = 2;
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution743.networkDelayTime(times, n, k));
        Assertions.assertEquals(expected, solution743.networkDelayTime2(times, n, k));
    }
}
