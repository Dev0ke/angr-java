import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3165Tests {
    private final Solution3165 solution3165 = new Solution3165();

    @Test
    public void example1() {
        int[] nums = {3, 5, 9};
        int[][] queries = UtUtils.stringToInts2("[[1,-2],[0,-3]]");
        int expected = 21;
        Assertions.assertEquals(expected, solution3165.maximumSumSubsequence(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {0, -1};
        int[][] queries = UtUtils.stringToInts2("[[0,-5]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3165.maximumSumSubsequence(nums, queries));
    }
}