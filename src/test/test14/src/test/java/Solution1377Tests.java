import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1377Tests {
    private final Solution1377 solution1377 = new Solution1377();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]");
        int t = 2;
        int target = 4;
        double expected = 0.16666666666666666;
        Assertions.assertEquals(expected, solution1377.frogPosition(n, edges, t, target));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]");
        int t = 1;
        int target = 7;
        double expected = 0.3333333333333333;
        Assertions.assertEquals(expected, solution1377.frogPosition(n, edges, t, target));
    }
}