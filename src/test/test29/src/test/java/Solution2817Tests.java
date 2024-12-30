import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2817Tests {
    private final Solution2817 solution2817 = new Solution2817();

    @Test
    public void example1() {
        List<Integer> nums = List.of(4, 3, 2, 4);
        int x = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2817.minAbsoluteDifference(nums, x));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(5, 3, 2, 10, 15);
        int x = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution2817.minAbsoluteDifference(nums, x));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int x = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2817.minAbsoluteDifference(nums, x));
    }
}