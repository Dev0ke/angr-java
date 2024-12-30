import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1466Tests {
    private final Solution1466 solution1466 = new Solution1466();

    @Test
    public void example1() {
        int n = 6;
        int[][] connections = UtUtils.stringToInts2("[[0,1],[1,3],[2,3],[4,0],[4,5]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1466.minReorder(n, connections));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] connections = UtUtils.stringToInts2("[[1,0],[1,2],[3,2],[3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1466.minReorder(n, connections));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] connections = UtUtils.stringToInts2("[[1,0],[2,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1466.minReorder(n, connections));
    }
}
