import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3350Tests {
    private final Solution3350 solution3350 = new Solution3350();

    @Test
    public void example1() {
        List<Integer> nums = List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
        int expected = 3;
        Assertions.assertEquals(expected, solution3350.maxIncreasingSubarrays(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
        int expected = 2;
        Assertions.assertEquals(expected, solution3350.maxIncreasingSubarrays(nums));
    }
}