import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2869Tests {
    private final Solution2869 solution2869 = new Solution2869();

    @Test
    public void example1() {
        List<Integer> nums = List.of(3, 1, 5, 4, 2);
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2869.minOperations(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(3, 1, 5, 4, 2);
        int k = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution2869.minOperations(nums, k));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(3, 2, 5, 3, 1);
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution2869.minOperations(nums, k));
    }
}