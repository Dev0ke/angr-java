import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3068Tests {
    private final Solution3068 solution3068 = new Solution3068();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1};
        int k = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        long expected = 6;
        Assertions.assertEquals(expected, solution3068.maximumValueSum(nums, k, edges));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3};
        int k = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        long expected = 9;
        Assertions.assertEquals(expected, solution3068.maximumValueSum(nums, k, edges));
    }

    @Test
    public void example3() {
        int[] nums = {7, 7, 7, 7, 7, 7};
        int k = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[0,4],[0,5]]");
        long expected = 42;
        Assertions.assertEquals(expected, solution3068.maximumValueSum(nums, k, edges));
    }
}