import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2045Tests {
    private final Solution2045 solution2045 = new Solution2045();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[1,4],[3,4],[4,5]]");
        int time = 3;
        int change = 5;
        int expected = 13;
        Assertions.assertEquals(expected, solution2045.secondMinimum(n, edges, time, change));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[1,2]]");
        int time = 3;
        int change = 2;
        int expected = 11;
        Assertions.assertEquals(expected, solution2045.secondMinimum(n, edges, time, change));
    }
}
