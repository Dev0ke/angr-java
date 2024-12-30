import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2779Tests {
    private final Solution2779 solution2779 = new Solution2779();

    @Test
    public void example1() {
        int[] nums = {4, 6, 1, 2};
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2779.maximumBeauty(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        int k = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution2779.maximumBeauty(nums, k));
    }
}