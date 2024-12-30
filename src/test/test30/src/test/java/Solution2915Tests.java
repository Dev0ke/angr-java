import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2915Tests {
    private final Solution2915 solution2915 = new Solution2915();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        int target = 9;
        int expected = 3;
        Assertions.assertEquals(expected, solution2915.lengthOfLongestSubsequence(nums, target));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(4, 1, 3, 2, 1, 5);
        int target = 7;
        int expected = 4;
        Assertions.assertEquals(expected, solution2915.lengthOfLongestSubsequence(nums, target));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(1, 1, 5, 4, 5);
        int target = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution2915.lengthOfLongestSubsequence(nums, target));
    }
}