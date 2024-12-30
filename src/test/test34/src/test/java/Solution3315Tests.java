import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3315Tests {
    private final Solution3315 solution3315 = new Solution3315();

    @Test
    public void example1() {
        List<Integer> nums = List.of(2, 3, 5, 7);
        int[] expected = {-1, 1, 4, 3};
        Assertions.assertArrayEquals(expected, solution3315.minBitwiseArray(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(11, 13, 31);
        int[] expected = {9, 12, 15};
        Assertions.assertArrayEquals(expected, solution3315.minBitwiseArray(nums));
    }
}