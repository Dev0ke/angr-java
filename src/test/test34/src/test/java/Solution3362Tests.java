import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3362Tests {
    private final Solution3362 solution3362 = new Solution3362();

    @Test
    public void example1() {
        int[] nums = {2, 0, 2};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[0,2],[1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3362.maxRemoval(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        int[][] queries = UtUtils.stringToInts2("[[1,3],[0,2],[1,3],[1,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3362.maxRemoval(nums, queries));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        int[][] queries = UtUtils.stringToInts2("[[0,3]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution3362.maxRemoval(nums, queries));
    }
}