import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3356Tests {
    private final Solution3356 solution3356 = new Solution3356();

    @Test
    public void example1() {
        int[] nums = {2, 0, 2};
        int[][] queries = UtUtils.stringToInts2("[[0,2,1],[0,2,1],[1,1,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3356.minZeroArray(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = UtUtils.stringToInts2("[[1,3,2],[0,2,1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution3356.minZeroArray(nums, queries));
    }
}