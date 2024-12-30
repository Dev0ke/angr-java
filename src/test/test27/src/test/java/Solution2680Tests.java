import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2680Tests {
    private final Solution2680 solution2680 = new Solution2680();

    @Test
    public void example1() {
        int[] nums = {12, 9};
        int k = 1;
        long expected = 30;
        Assertions.assertEquals(expected, solution2680.maximumOr(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {8, 1, 2};
        int k = 2;
        long expected = 35;
        Assertions.assertEquals(expected, solution2680.maximumOr(nums, k));
    }
}