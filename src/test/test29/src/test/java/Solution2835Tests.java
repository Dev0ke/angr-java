import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2835Tests {
    private final Solution2835 solution2835 = new Solution2835();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 2, 8);
        int target = 7;
        int expected = 1;
        Assertions.assertEquals(expected, solution2835.minOperations(nums, target));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(1, 32, 1, 2);
        int target = 12;
        int expected = 2;
        Assertions.assertEquals(expected, solution2835.minOperations(nums, target));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(1, 32, 1);
        int target = 35;
        int expected = -1;
        Assertions.assertEquals(expected, solution2835.minOperations(nums, target));
    }
}