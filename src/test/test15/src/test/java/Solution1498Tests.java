import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1498Tests {
    private final Solution1498 solution1498 = new Solution1498();

    @Test
    public void example1() {
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        int expected = 4;
        Assertions.assertEquals(expected, solution1498.numSubseq(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 6, 8};
        int target = 10;
        int expected = 6;
        Assertions.assertEquals(expected, solution1498.numSubseq(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 3, 4, 6, 7};
        int target = 12;
        int expected = 61;
        Assertions.assertEquals(expected, solution1498.numSubseq(nums, target));
    }
}
