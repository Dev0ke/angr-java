import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2897Tests {
    private final Solution2897 solution2897 = new Solution2897();

    @Test
    public void example1() {
        List<Integer> nums = List.of(2, 6, 5, 8);
        int k = 2;
        int expected = 261;
        Assertions.assertEquals(expected, solution2897.maxSum(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(4, 5, 4, 7);
        int k = 3;
        int expected = 90;
        Assertions.assertEquals(expected, solution2897.maxSum(nums, k));
    }
}