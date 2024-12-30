import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1319Tests {
    private final Solution1319 solution1319 = new Solution1319();

    @Test
    public void example1() {
        int n = 4;
        int[][] connections = UtUtils.stringToInts2("[[0,1],[0,2],[1,2]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1319.makeConnected(n, connections));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] connections = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[1,2],[1,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1319.makeConnected(n, connections));
    }

    @Test
    public void example3() {
        int n = 6;
        int[][] connections = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[1,2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1319.makeConnected(n, connections));
    }

    @Test
    public void example4() {
        int n = 5;
        int[][] connections = UtUtils.stringToInts2("[[0,1],[0,2],[3,4],[2,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1319.makeConnected(n, connections));
    }
}
