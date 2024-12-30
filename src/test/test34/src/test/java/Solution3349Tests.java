import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3349Tests {
    private final Solution3349 solution3349 = new Solution3349();

    @Test
    public void example1() {
        List<Integer> nums = List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
        int k = 3;
        Assertions.assertTrue(solution3349.hasIncreasingSubarrays(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
        int k = 5;
        Assertions.assertFalse(solution3349.hasIncreasingSubarrays(nums, k));
    }
}