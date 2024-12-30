import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2261Tests {
    private final Solution2261 solution2261 = new Solution2261();

    @Test
    public void example1() {
        int[] nums = {2, 3, 3, 2, 2};
        int k = 2;
        int p = 2;
        int expected = 11;
        Assertions.assertEquals(expected, solution2261.countDistinct(nums, k, p));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int k = 4;
        int p = 1;
        int expected = 10;
        Assertions.assertEquals(expected, solution2261.countDistinct(nums, k, p));
    }
}
