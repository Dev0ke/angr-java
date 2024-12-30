import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3241Tests {
    private final Solution3241 solution3241 = new Solution3241();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] expected = {2, 4, 3};
        Assertions.assertArrayEquals(expected, solution3241.timeTaken(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution3241.timeTaken(edges));
    }
}