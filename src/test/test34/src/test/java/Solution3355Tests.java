import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3355Tests {
    private final Solution3355 solution3355 = new Solution3355();

    @Test
    public void example1() {
        int[] nums = {1, 0, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,2]]");
        Assertions.assertTrue(solution3355.isZeroArray(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = UtUtils.stringToInts2("[[1,3],[0,2]]");
        Assertions.assertFalse(solution3355.isZeroArray(nums, queries));
    }
}