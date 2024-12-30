import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution834Tests {
    private final Solution834 solution834 = new Solution834();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[2,4],[2,5]]");
        int[] expected = {8, 12, 6, 10, 10, 10};
        Assertions.assertArrayEquals(expected, solution834.sumOfDistancesInTree(n, edges));
    }

    @Test
    public void example2() {
        int n = 1;
        int[][] edges = UtUtils.stringToInts2("[]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution834.sumOfDistancesInTree(n, edges));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[1,0]]");
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution834.sumOfDistancesInTree(n, edges));
    }
}