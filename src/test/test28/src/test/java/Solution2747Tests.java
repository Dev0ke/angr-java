import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2747Tests {
    private final Solution2747 solution2747 = new Solution2747();

    @Test
    public void example1() {
        int n = 3;
        int[][] logs = UtUtils.stringToInts2("[[1,3],[2,6],[1,5]]");
        int x = 5;
        int[] queries = {10, 11};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution2747.countServers(n, logs, x, queries));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] logs = UtUtils.stringToInts2("[[2,4],[2,1],[1,2],[3,1]]");
        int x = 2;
        int[] queries = {3, 4};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution2747.countServers(n, logs, x, queries));
    }
}