import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2733Tests {
    private final Solution2733 solution2733 = new Solution2733();

    @Test
    public void example1() {
        int[] nums = {3, 2, 1, 4};
//        int expected = 2;
        // 2 或 3 都是有效答案。
        int expected = 3;
        Assertions.assertEquals(expected, solution2733.findNonMinOrMax(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int expected = -1;
        Assertions.assertEquals(expected, solution2733.findNonMinOrMax(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution2733.findNonMinOrMax(nums));
    }
}