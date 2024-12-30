import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2824Tests {
    private final Solution2824 solution2824 = new Solution2824();

    @Test
    public void example1() {
        List<Integer> nums = Arrays.asList(-1, 1, 2, 3, 1);
        int target = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2824.countPairs(nums, target));
        Assertions.assertEquals(expected, solution2824.countPairs2(nums, target));
    }

    @Test
    public void example2() {
        List<Integer> nums = Arrays.asList(-6, 2, 5, -2, -7, -1, 3);
        int target = -2;
        int expected = 10;
        Assertions.assertEquals(expected, solution2824.countPairs(nums, target));
        Assertions.assertEquals(expected, solution2824.countPairs2(nums, target));
    }
}