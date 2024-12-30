import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2831Tests {
    private final Solution2831 solution2831 = new Solution2831();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 3, 2, 3, 1, 3);
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2831.longestEqualSubarray(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(1, 1, 2, 2, 1, 1);
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2831.longestEqualSubarray(nums, k));
    }
}