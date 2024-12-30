import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1519Tests {
    private final Solution1519 solution1519 = new Solution1519();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]");
        String labels = "abaedcd";
        int[] expected = {2, 1, 1, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution1519.countSubTrees(n, edges, labels));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[0,3]]");
        String labels = "bbbb";
        int[] expected = {4, 2, 1, 1};
        Assertions.assertArrayEquals(expected, solution1519.countSubTrees(n, edges, labels));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[0,4]]");
        String labels = "aabab";
        int[] expected = {3, 2, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution1519.countSubTrees(n, edges, labels));
    }
}