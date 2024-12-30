import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1766Tests {
    private final Solution1766 solution1766 = new Solution1766();

    @Test
    public void example1() {
        int[] nums = {2, 3, 3, 2};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3]]");
        int[] expected = {-1, 0, 0, 1};
        Assertions.assertArrayEquals(expected, solution1766.getCoprimes(nums, edges));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 10, 2, 3, 6, 15};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]");
        int[] expected = {-1, 0, -1, 0, 0, 0, -1};
        Assertions.assertArrayEquals(expected, solution1766.getCoprimes(nums, edges));
    }
}