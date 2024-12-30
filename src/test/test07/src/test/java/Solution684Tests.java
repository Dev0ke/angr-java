import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution684Tests {
    private final Solution684 solution684 = new Solution684();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[1,2], [1,3], [2,3]]");
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution684.findRedundantConnection(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,2], [2,3], [3,4], [1,4], [1,5]]");
        int[] expected = {1, 4};
        Assertions.assertArrayEquals(expected, solution684.findRedundantConnection(edges));
    }
}
