import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2841Tests {
    private final Solution2841 solution2841 = new Solution2841();

    @Test
    public void example1() {
        List<Integer> nums = List.of(2, 6, 7, 3, 1, 7);
        int m = 3;
        int k = 4;
        long expected = 18;
        Assertions.assertEquals(expected, solution2841.maxSum(nums, m, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(5, 9, 9, 2, 4, 5, 4);
        int m = 1;
        int k = 3;
        long expected = 23;
        Assertions.assertEquals(expected, solution2841.maxSum(nums, m, k));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(1, 2, 1, 2, 1, 2, 1);
        int m = 3;
        int k = 3;
        long expected = 0;
        Assertions.assertEquals(expected, solution2841.maxSum(nums, m, k));
    }
}