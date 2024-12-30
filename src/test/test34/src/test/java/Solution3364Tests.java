import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3364Tests {
    private final Solution3364 solution3364 = new Solution3364();

    @Test
    public void example1() {
        List<Integer> nums = List.of(3, -2, 1, 4);
        int l = 2;
        int r = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3364.minimumSumSubarray(nums, l, r));
        Assertions.assertEquals(expected, solution3364.minimumSumSubarray2(nums, l, r));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(-2, 2, -3, 1);
        int l = 2;
        int r = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution3364.minimumSumSubarray(nums, l, r));
        Assertions.assertEquals(expected, solution3364.minimumSumSubarray2(nums, l, r));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int l = 2;
        int r = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3364.minimumSumSubarray(nums, l, r));
        Assertions.assertEquals(expected, solution3364.minimumSumSubarray2(nums, l, r));
    }
}