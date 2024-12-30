import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2432Tests {
    private final Solution2432 solution2432 = new Solution2432();

    @Test
    public void example1() {
        int n = 10;
        int[][] logs = UtUtils.stringToInts2("[[0,3],[2,5],[0,9],[1,15]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2432.hardestWorker(n, logs));
    }

    @Test
    public void example2() {
        int n = 26;
        int[][] logs = UtUtils.stringToInts2("[[1,1],[3,7],[2,12],[7,17]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2432.hardestWorker(n, logs));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] logs = UtUtils.stringToInts2("[[0,10],[1,20]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2432.hardestWorker(n, logs));
    }
}
