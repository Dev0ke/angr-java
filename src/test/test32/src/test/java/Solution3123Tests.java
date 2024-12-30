import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3123Tests {
    private final Solution3123 solution3123 = new Solution3123();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4,5,2]]");
        boolean[] expected = {true, true, true, false, true, true, true, false};
        Assertions.assertArrayEquals(expected, solution3123.findAnswer(n, edges));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[2,0,1],[0,1,1],[0,3,4],[3,2,2]]");
        boolean[] expected = {true, false, false, true};
        Assertions.assertArrayEquals(expected, solution3123.findAnswer(n, edges));
    }
}